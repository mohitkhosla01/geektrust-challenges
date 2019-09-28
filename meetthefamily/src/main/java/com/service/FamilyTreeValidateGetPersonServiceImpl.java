package com.service;

import java.util.Map;

import com.dto.Person;

public class FamilyTreeValidateGetPersonServiceImpl implements FamilyTreeValidateGetPersonService {
	
	// Function to determine if paternal uncles of a family member can be obtained based on given input parameters.
	public boolean isPaternalUncleDeterminable(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return false;
		}

		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			return false;
		}

		Person father = mother.getSpouse();
		if(father == null) {
			return false;
		}

		Person paternalGrandmother = father.getMother();
		if(paternalGrandmother == null) {
			return false;
		}

		return true;
	}

	// Function to determine if maternal uncles of a family member can be obtained based on given input parameters.
	public boolean isMaternalUncleDeterminable(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return false;
		}

		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			return false;
		}

		Person maternalGrandmother = mother.getMother();
		if(maternalGrandmother == null) {
			return false;
		}

		return true;
	}

	// Function to determine if paternal aunts of a family member can be obtained based on given input parameters.
	public boolean isPaternalAuntDeterminable(Map<String, Person> familyMembers, String personName, String relationship) {
		
		if(!familyMembers.containsKey(personName)) {
			return false;
		}

		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			return false;
		}

		Person father = mother.getSpouse();
		if(father == null) {
			return false;
		}

		Person paternalGrandmother = father.getMother();
		if(paternalGrandmother == null) {
			return false;
		}

		return true;
	}

	// Function to determine if maternal aunts of a family member can be obtained based on given input parameters.
	public boolean isMaternalAuntDeterminable(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return false;
		}

		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			return false;
		}

		Person maternalGrandmother = mother.getMother();
		if(maternalGrandmother == null) {
			return false;
		}

		return true;
	}

	// Function to determine if 'familyMembers' data structure contains a particular person.
	public boolean isPersonDeterminable(Map<String, Person> familyMembers, String personName, String relationship) {
		
		if(!familyMembers.containsKey(personName)) {
			return false;
		}

		return true;
	}
}
