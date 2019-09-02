package com.service;

import java.util.Map;
import com.dto.Person;
import com.exception.FamilyTreeException;

public interface FamilyTreeAddPersonService {

	void constructInitialFamilyTree(Map<String, Person> familyMembers);
	
	String addChild(Map<String, Person> familyMembers, String mothersName, String childsName, String childsGender) throws FamilyTreeException;
}
