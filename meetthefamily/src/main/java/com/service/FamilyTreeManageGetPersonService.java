package com.service;

import java.util.List;
import java.util.Map;

import com.dto.Person;

public abstract class FamilyTreeManageGetPersonService implements FamilyTreeGetPersonService {

	public List<String> getRelatives(Map<String, Person> familyMembers, String personName, String relationship) {
		
		switch(relationship) {
			case "Paternal-Uncle" : return getPaternalUncle(familyMembers, personName, relationship);
			case "Maternal-Uncle" : return getMaternalUncle(familyMembers, personName, relationship);
			case "Paternal-Aunt" : 	return getPaternalAunt(familyMembers, personName, relationship);
			case "Maternal-Aunt" : 	return getMaternalAunt(familyMembers, personName, relationship);
			case "Sister-In-Law" : 	return getSistersInLaw(familyMembers, personName, relationship);
			case "Brother-In-Law" : return getBrothersInLaw(familyMembers, personName, relationship);
			case "Son" : 			return getSons(familyMembers, personName, relationship);
			case "Daughter" : 		return getDaughters(familyMembers, personName, relationship);
			case "Siblings" : 		return getSiblings(familyMembers, personName, relationship);
			default : 				return null;
		}
	}


	abstract List<String> getPaternalUncle(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract List<String> getMaternalUncle(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract List<String> getPaternalAunt(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract List<String> getMaternalAunt(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract List<String> getSistersInLaw(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract List<String> getBrothersInLaw(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract List<String> getSons(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract List<String> getDaughters(Map<String, Person> familyMembers, String personName, String relationship);
	
	abstract List<String> getSiblings(Map<String, Person> familyMembers, String personName, String relationship);
}
