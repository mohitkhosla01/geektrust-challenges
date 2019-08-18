package com.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

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

		String[] inputs = {		    
				"GET_RELATIONSHIP Satvy Sister-In-Law",
				"GET_RELATIONSHIP Ish Son",
				"GET_RELATIONSHIP Misha Daughter"
		};

		
		for(String input : inputs) {

			String[] inputParameters = input.split(" ");

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
	}
}
