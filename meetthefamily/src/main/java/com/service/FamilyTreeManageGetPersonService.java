package com.service;

import java.util.List;
import java.util.Map;

import com.dto.Person;
import com.utilities.FamilyTreeConstants;

public abstract class FamilyTreeManageGetPersonService implements FamilyTreeGetPersonService {

	public List<String> getRelatives(Map<String, Person> familyMembers, String personName, String relationship) {
		
		switch(relationship) {
			case FamilyTreeConstants.PATERNAL_UNCLE : 	return getPaternalUncle(familyMembers, personName, relationship);
			case FamilyTreeConstants.MATERNAL_UNCLE : 	return getMaternalUncle(familyMembers, personName, relationship);
			case FamilyTreeConstants.PATERNAL_AUNT : 	return getPaternalAunt(familyMembers, personName, relationship);
			case FamilyTreeConstants.MATERNAL_AUNT : 	return getMaternalAunt(familyMembers, personName, relationship);
			case FamilyTreeConstants.SISTER_IN_LAW : 	return getSistersInLaw(familyMembers, personName, relationship);
			case FamilyTreeConstants.BROTHER_IN_LAW : 	return getBrothersInLaw(familyMembers, personName, relationship);
			case FamilyTreeConstants.SON : 				return getSons(familyMembers, personName, relationship);
			case FamilyTreeConstants.DAUGHTER : 		return getDaughters(familyMembers, personName, relationship);
			case FamilyTreeConstants.SIBLINGS : 		return getSiblings(familyMembers, personName, relationship);
			default : 									return null;
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
