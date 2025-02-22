package com.inputtypemapper;

import com.dto.Person;
import com.utilities.FamilyTreeEnum;

public abstract class InputOperationMapper {

	public String mapInputOperation(Person person, String inputLine) throws Exception {
		
		String[] inputParameters = inputLine.split(" ");
		String operationName = inputParameters[0];
		
		switch(operationName) {
			case "ADD_CHILD" : 			return addChild(person, inputParameters);
			case "GET_RELATIONSHIP" : 	return getRelationship(person, inputParameters);
			default : 					return FamilyTreeEnum.INVALID_INPUT.getMessage();
		}
	}

	// Abstract function to add a child to a family tree.
	public abstract String addChild(Person person, String[] inputParameters) throws Exception;

	// Abstract function to get relationships from a family tree.
	public abstract String getRelationship(Person person, String[] inputParameters) throws Exception;
}
