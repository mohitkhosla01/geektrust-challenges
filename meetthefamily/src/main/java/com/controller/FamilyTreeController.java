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
import com.service.FamilyTreeCreateService;
import com.service.FamilyTreeManageService;

public class FamilyTreeController {

	public static void main(String[] args) {
		
		Map<String, Person> familyMembers = new HashMap<String, Person>();
		/* 
		 * 'familyMembers' collection stores a map of Person object references for quick lookup.
		 * KEY: Person names
		 * VALUE: Person object references
		 */

		
		FamilyTreeCreateService.constructInitialFamilyTree(familyMembers);
		
		
		Scanner sc = new Scanner(System.in);
		String fileSource = sc.nextLine();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileSource));
		    
			String line;
		    while ((line = br.readLine()) != null) {
		       
				String[] inputParameters = line.split(" ");

				if(inputParameters[0].equals("ADD_CHILD")) {

					if(inputParameters.length == 4) {
						String mothersName = inputParameters[1];
						String childsName = inputParameters[2];
						String childsGender = inputParameters[3];

						System.out.println(FamilyTreeManageService.addChild(familyMembers, mothersName, childsName, childsGender));
					}
					else {
						System.out.println("INVALID_INPUT");
					}
				}
				else if(inputParameters[0].equals("GET_RELATIONSHIP")) {

					if(inputParameters.length == 3) {
						String person = inputParameters[1];
						String relationship = inputParameters[2];
						
						List<String> relatives = FamilyTreeManageService.getRelatives(familyMembers, person, relationship);
						
						if(relatives.size() > 0) {
							for(String relative : relatives) {
								System.out.print(relative + " ");
							}
							System.out.println();
						}
						else {
							System.out.println("NONE");
						}
					}
					else {
						System.out.println("INVALID_INPUT");
					}
				}
				else {
					System.out.println("INVALID_INPUT");
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
		
		sc.close();
	}
}
