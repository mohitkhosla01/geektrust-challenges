package com.service;

import java.util.Map;

import com.dto.Person;
import com.utilities.FamilyTreeEnum;

public abstract class FamilyTreeManageValidateGetPersonService implements FamilyTreeValidateGetPersonService {

	
	public String validateGetRelatives(Map<String, Person> familyMembers, String personName, String relationship) {
		
		switch(relationship) {
			case "Paternal-Uncle" : return validateGetPaternalUncle(familyMembers, personName, relationship);
			case "Maternal-Uncle" : return validateGetMaternalUncle(familyMembers, personName, relationship);
			case "Paternal-Aunt" : 	return validateGetPaternalAunt(familyMembers, personName, relationship);
			case "Maternal-Aunt" : 	return validateGetMaternalAunt(familyMembers, personName, relationship);
			case "Sister-In-Law" : 	return validateGetPerson(familyMembers, personName, relationship);
			case "Brother-In-Law" : return validateGetPerson(familyMembers, personName, relationship);
			case "Son" : 			return validateGetPerson(familyMembers, personName, relationship);
			case "Daughter" : 		return validateGetPerson(familyMembers, personName, relationship);
			case "Siblings" : 		return validateGetPerson(familyMembers, personName, relationship);
			default : 				return FamilyTreeEnum.INVALID_INPUT.getMessage();
		}
	}


	abstract String validateGetPaternalUncle(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract String validateGetMaternalUncle(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract String validateGetPaternalAunt(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract String validateGetMaternalAunt(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract String validateGetPerson(Map<String, Person> familyMembers, String personName, String relationship);
}
