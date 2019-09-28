package com.service;

import java.util.Map;

import com.dto.Person;

public interface FamilyTreeValidateGetPersonService {
	
	boolean isPaternalUncleDeterminable(Map<String, Person> familyMembers, String personName, String relationship);
	
	boolean isMaternalUncleDeterminable(Map<String, Person> familyMembers, String personName, String relationship);
	
	boolean isPaternalAuntDeterminable(Map<String, Person> familyMembers, String personName, String relationship);
	
	boolean isMaternalAuntDeterminable(Map<String, Person> familyMembers, String personName, String relationship);
	
	boolean isPersonDeterminable(Map<String, Person> familyMembers, String personName, String relationship);
}
