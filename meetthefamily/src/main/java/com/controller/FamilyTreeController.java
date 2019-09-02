package com.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dto.Person;
import com.exception.FamilyTreeException;
import com.service.FamilyTreeAddPersonService;
import com.service.FamilyTreeAddPersonServiceImpl;
import com.service.FamilyTreeGetPersonService;
import com.service.FamilyTreeGetPersonServiceImpl;
import com.service.FamilyTreeValidateAddPersonService;
import com.service.FamilyTreeValidateAddPersonServiceImpl;
import com.service.FamilyTreeValidateGetPersonService;
import com.service.FamilyTreeValidateGetPersonServiceImpl;
import com.utilities.FamilyTreeEnum;

public class FamilyTreeController {

	public static void main(String[] args) {
		
		Map<String, Person> familyMembers = new HashMap<String, Person>();
		/* 
		 * 'familyMembers' collection stores a map of Person object references for quick lookup.
		 * KEY: Person names
		 * VALUE: Person object references
		 */
		
		FamilyTreeAddPersonService familyTreeAddPersonService = new FamilyTreeAddPersonServiceImpl();		
		familyTreeAddPersonService.constructInitialFamilyTree(familyMembers);
		
		FamilyTreeGetPersonService familyTreeGetPersonService = new FamilyTreeGetPersonServiceImpl();
		
		FamilyTreeValidateAddPersonService familyTreeValidateAddPersonService = new FamilyTreeValidateAddPersonServiceImpl();
		FamilyTreeValidateGetPersonService familyTreeValidateGetPersonService = new FamilyTreeValidateGetPersonServiceImpl();
		
		
		System.out.println("-> -> ->  Welcome to 'Meet the Family' Geektrust backend challenge  <- <- <-");
		System.out.print("Enter the input file path: ");
		Scanner sc = new Scanner(System.in);
		String fileSource = sc.nextLine();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileSource));
		    
			String line;
		    while ((line = br.readLine()) != null) {
		       
				String[] inputParameters = line.split(" ");

				if(inputParameters[0].equals(FamilyTreeEnum.ADD_CHILD.getMessage())) {

					if(inputParameters.length == 4) {
						String mothersName = inputParameters[1];
						String childsName = inputParameters[2];
						String childsGender = inputParameters[3];

						String addChildValidationResult = familyTreeValidateAddPersonService.validateAddChild(familyMembers, mothersName, childsName, childsGender);
						if(addChildValidationResult.equals(FamilyTreeEnum.ADD_PERSON_POSSIBLE.getMessage())) {
							System.out.println(familyTreeAddPersonService.addChild(familyMembers, mothersName, childsName, childsGender));
						}
						else {
							System.out.println(addChildValidationResult);
						}
					}
					else {
						System.out.println(FamilyTreeEnum.INVALID_INPUT.getMessage());
					}
				}
				else if(inputParameters[0].equals(FamilyTreeEnum.GET_RELATIONSHIP.getMessage())) {

					if(inputParameters.length == 3) {
						String person = inputParameters[1];
						String relationship = inputParameters[2];
						
						String getChildValidationResult = familyTreeValidateGetPersonService.validateGetRelatives(familyMembers, person, relationship);
						if(getChildValidationResult.equals(FamilyTreeEnum.GET_PERSON_POSSIBLE.getMessage())) {
							
							List<String> relatives = familyTreeGetPersonService.getRelatives(familyMembers, person, relationship);
							
							if(relatives.size() > 0) {
								for(String relative : relatives) {
									System.out.print(relative + " ");
								}
								System.out.println();
							}
							else {
								System.out.println(FamilyTreeEnum.NONE.getMessage());
							}
						}
						else {
							System.out.println(getChildValidationResult);
						}
					}
					else {
						System.out.println(FamilyTreeEnum.INVALID_INPUT.getMessage());
					}
				}
				else {
					System.out.println(FamilyTreeEnum.INVALID_INPUT.getMessage());
				}
		    }
		    
		    br.close();
		} 
		catch(FileNotFoundException fne) {
			System.out.println("No file found at location: " + fileSource);
		}
		catch(IOException ioe) {
			System.out.println("IOException occured!");
			ioe.printStackTrace();
		}
		catch(FamilyTreeException fte) {
			System.out.println(fte.getFamilyTreeEnum().getMessage());
		}
		catch(NullPointerException npe) {
			System.out.println("NullPointerException occured!");
			npe.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Exception occured!");
			e.printStackTrace();
		}
		
		sc.close();
	}
}
