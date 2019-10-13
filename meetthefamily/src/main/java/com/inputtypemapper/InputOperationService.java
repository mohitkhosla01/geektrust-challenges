package com.inputtypemapper;

import com.addfamilymember.AddChildService;
import com.dto.Person;
import com.getfamilymember.GetRelationshipService;

public class InputOperationService extends InputOperationMapper {
	
	// Function to add a child to the Shan family tree.
	public String addChild(Person shan, String[] inputParameters) throws Exception {

		return new AddChildService().addChild(shan, inputParameters);
	}

	// Function to get relationships from the Shan family tree.
	public String getRelationship(Person shan, String[] inputParameters) throws Exception {
		
		return new GetRelationshipService().getRelatives(shan, inputParameters);
	}
}
