package com.addfamilymember;

import com.dto.Person;
import com.utilities.FamilyTreeEnum;

public class AddChildService {
	
	public String addChild(Person shan, String[] inputParameters) throws Exception {
		
		if(inputParameters.length == 4) {
			String mothersName = inputParameters[1];
			String childsName = inputParameters[2];
			String childsGender = inputParameters[3];
			
			if(!(childsGender.equalsIgnoreCase(FamilyTreeEnum.MALE.getMessage()) || childsGender.equalsIgnoreCase(FamilyTreeEnum.FEMALE.getMessage()))) {
				return FamilyTreeEnum.INVALID_INPUT.getMessage();
			}

			boolean childAdded = shan.addFamilyMember(mothersName, childsName, childsGender);

			if(childAdded) {
				return FamilyTreeEnum.CHILD_ADDITION_SUCCEEDED.getMessage();
			}
			else {
				return FamilyTreeEnum.CHILD_ADDITION_FAILED.getMessage();
			}
		}
		else {
			return FamilyTreeEnum.INVALID_INPUT.getMessage();
		}
	}
}
