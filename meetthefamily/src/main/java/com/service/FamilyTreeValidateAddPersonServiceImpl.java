package com.service;

import java.util.Map;

import com.dto.Person;
import com.exception.FamilyTreeException;
import com.utilities.FamilyTreeEnum;

public class FamilyTreeValidateAddPersonServiceImpl implements FamilyTreeValidateAddPersonService {


	public String validateAddChild(Map<String, Person> familyMembers, String mothersName, String childsName, String childsGender) throws FamilyTreeException {

		if(familyMembers.containsKey(childsName)) {
			return FamilyTreeEnum.CHILD_ADDITION_FAILED.getMessage();
		}
		if(!familyMembers.containsKey(mothersName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}
		if(familyMembers.containsKey(mothersName) && !familyMembers.get(mothersName).getGender().equals("female")) {
			return FamilyTreeEnum.CHILD_ADDITION_FAILED.getMessage();
		}

		childsGender = childsGender.toLowerCase();
		if(!(childsGender.equals("male") || childsGender.equals("female"))) {
			return FamilyTreeEnum.CHILD_ADDITION_FAILED.getMessage();
		}

		return FamilyTreeEnum.ADD_PERSON_POSSIBLE.getMessage();
	}
}
