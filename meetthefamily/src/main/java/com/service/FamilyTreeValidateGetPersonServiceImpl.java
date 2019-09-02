package com.service;

import java.util.Map;

import com.dto.Person;
import com.utilities.FamilyTreeEnum;

public class FamilyTreeValidateGetPersonServiceImpl extends FamilyTreeManageValidateGetPersonService {
	
	
	public String validateGetPaternalUncle(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		Person father = mother.getSpouse();
		if(father == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		Person paternalGrandmother = father.getMother();
		if(paternalGrandmother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		return FamilyTreeEnum.GET_PERSON_POSSIBLE.getMessage();
	}


	public String validateGetMaternalUncle(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		Person maternalGrandmother = mother.getMother();
		if(maternalGrandmother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		return FamilyTreeEnum.GET_PERSON_POSSIBLE.getMessage();
	}


	public String validateGetPaternalAunt(Map<String, Person> familyMembers, String personName, String relationship) {
		
		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		Person father = mother.getSpouse();
		if(father == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		Person paternalGrandmother = father.getMother();
		if(paternalGrandmother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		return FamilyTreeEnum.GET_PERSON_POSSIBLE.getMessage();
	}


	public String validateGetMaternalAunt(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		Person maternalGrandmother = mother.getMother();
		if(maternalGrandmother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		return FamilyTreeEnum.GET_PERSON_POSSIBLE.getMessage();
	}


	public String validateGetPerson(Map<String, Person> familyMembers, String personName, String relationship) {	

		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
		}

		return FamilyTreeEnum.GET_PERSON_POSSIBLE.getMessage();
	}
}
