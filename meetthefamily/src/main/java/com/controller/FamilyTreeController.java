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
import com.utilities.FamilyTreeEnum;

public class FamilyTreeController {

	public static void main(String[] args) {

		Map<String, Person> familyMembers = new HashMap<String, Person>();
		/* 
		 * 'familyMembers' collection stores a map of Person object references for quick lookup.
		 * KEY: Person names
		 * VALUE: Person object references
		 */

		FamilyTreeController controllerObject = new FamilyTreeController();

		FamilyTreeAddPersonService addPersonServiceObject = new FamilyTreeAddPersonServiceImpl();		
		addPersonServiceObject.constructInitialFamilyTree(familyMembers);

		FamilyTreeGetPersonService getPersonServiceObject = new FamilyTreeGetPersonServiceImpl();


		System.out.println("-> -> ->  Welcome to 'Meet the Family' Geektrust backend challenge  <- <- <-");
		System.out.print("Enter the input file path: ");
		Scanner sc = new Scanner(System.in);
		String fileSource = sc.nextLine();

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileSource));

			String line;
			while ((line = br.readLine()) != null) {

				String[] inputParameters = line.split(" ");
				String operationName = inputParameters[0], operationResponse = null;

				switch(operationName) {
				case "ADD_CHILD" : 
					operationResponse = controllerObject.addChildToFamilyTree(addPersonServiceObject, inputParameters, familyMembers);
					break;
				case "GET_RELATIONSHIP" : 
					operationResponse = controllerObject.getRelativesFromFamilyTree(getPersonServiceObject, inputParameters, familyMembers);
					break;
				default : 
					operationResponse = FamilyTreeEnum.INVALID_INPUT.getMessage();
				}

				System.out.println(operationResponse);
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


	/* 
	 * Function to orchestrate calls to other functions for adding a new member to 'familyMembers' data structure.
	 * 
	 * FamilyTreeValidateAddPersonService.validateAddChild() is initially called to validate input parameters.
	 * Once input parameters are successfully validated, FamilyTreeAddPersonService.addChild() is called to add the new member.
	 */
	public String addChildToFamilyTree(FamilyTreeAddPersonService addPersonServiceObject, String[] inputParameters, Map<String, Person> familyMembers) throws FamilyTreeException {

		if(inputParameters.length == 4) {
			String mothersName = inputParameters[1];
			String childsName = inputParameters[2];
			String childsGender = inputParameters[3];

			return addPersonServiceObject.addChild(familyMembers, mothersName, childsName, childsGender);
		}
		else {
			return FamilyTreeEnum.INVALID_INPUT.getMessage();
		}
	}


	/* 
	 * Function to orchestrate calls to other functions for getting relatives from 'familyMembers' data structure of a particular person.
	 * 
	 * FamilyTreeValidateGetPersonService.validateGetRelatives() is initially called to validate input parameters.
	 * Once input parameters are successfully validated, FamilyTreeGetPersonService.getRelatives() is called to obtain the list of relatives.
	 */
	public String getRelativesFromFamilyTree(FamilyTreeGetPersonService getPersonServiceObject, String[] inputParameters, Map<String, Person> familyMembers) throws FamilyTreeException {

		if(inputParameters.length == 3) {
			String person = inputParameters[1];
			String relationship = inputParameters[2];

			List<String> relatives = getPersonServiceObject.getRelatives(familyMembers, person, relationship);

			if(relatives != null && relatives.size() > 0) {
				StringBuilder relativeNames = new StringBuilder();

				for(String relative : relatives) {
					relativeNames.append(relative);
					relativeNames.append(" ");
				}
				return relativeNames.toString().trim();
			}
			else if(relatives == null) {
				return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
			}
			else {
				return FamilyTreeEnum.NONE.getMessage();
			}
		}
		else {
			return FamilyTreeEnum.INVALID_INPUT.getMessage();
		}
	}
}
