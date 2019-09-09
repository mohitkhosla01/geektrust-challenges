package com.service;

import java.util.Map;

import com.dto.Person;
import com.utilities.FamilyTreeConstants;
import com.utilities.FamilyTreeEnum;

public abstract class FamilyTreeManageValidateGetPersonService implements FamilyTreeValidateGetPersonService {

	public String validateGetRelatives(Map<String, Person> familyMembers, String personName, String relationship) {
		
		switch(relationship) {
			case FamilyTreeConstants.PATERNAL_UNCLE : 	return validateGetPaternalUncle(familyMembers, personName, relationship);
			case FamilyTreeConstants.MATERNAL_UNCLE : 	return validateGetMaternalUncle(familyMembers, personName, relationship);
			case FamilyTreeConstants.PATERNAL_AUNT : 	return validateGetPaternalAunt(familyMembers, personName, relationship);
			case FamilyTreeConstants.MATERNAL_AUNT : 	return validateGetMaternalAunt(familyMembers, personName, relationship);
			case FamilyTreeConstants.SISTER_IN_LAW : 	return validateGetPerson(familyMembers, personName, relationship);
			case FamilyTreeConstants.BROTHER_IN_LAW : 	return validateGetPerson(familyMembers, personName, relationship);
			case FamilyTreeConstants.SON : 				return validateGetPerson(familyMembers, personName, relationship);
			case FamilyTreeConstants.DAUGHTER : 		return validateGetPerson(familyMembers, personName, relationship);
			case FamilyTreeConstants.SIBLINGS : 		return validateGetPerson(familyMembers, personName, relationship);
			default : 									return FamilyTreeEnum.INVALID_INPUT.getMessage();
		}
	}


	abstract String validateGetPaternalUncle(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract String validateGetMaternalUncle(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract String validateGetPaternalAunt(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract String validateGetMaternalAunt(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract String validateGetPerson(Map<String, Person> familyMembers, String personName, String relationship);
}
