package com.controller;

import java.util.List;

import com.service.FamilyTreeService;

public class FamilyTreeController {

	public static void main(String[] args) {

		FamilyTreeService.constructInitialFamilyTree();


		String[] inputs = {
				"ADD_CHILD Chitra Aria Female",
				"GET_RELATIONSHIP Lavnya Maternal-Aunt",
				"GET_RELATIONSHIP Aria Siblings",
				"ADD_CHILD Pjali Srutak Male",
				"GET_RELATIONSHIP Pjali Son",
				"ADD_CHILD Asva Vani Female",
				"GET_RELATIONSHIP Vasa Siblings",
				"GET_RELATIONSHIP Atya Sister-In-Law"
		};

		
		for(String input : inputs) {

			String[] inputParameters = input.split(" ");

			if(inputParameters[0].equals("ADD_CHILD")) {

				if(inputParameters.length == 4) {
					String mothersName = inputParameters[1];
					String childsName = inputParameters[2];
					String childsGender = inputParameters[3];

					System.out.println(FamilyTreeService.addChild(mothersName, childsName, childsGender));
				}
				else {
					System.out.println("INVALID_INPUT");
				}
			}
			else if(inputParameters[0].equals("GET_RELATIONSHIP")) {

				if(inputParameters.length == 3) {
					String person = inputParameters[1];
					String relationship = inputParameters[2];
					
					List<String> relatives = FamilyTreeService.getRelatives(person, relationship);
					
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
