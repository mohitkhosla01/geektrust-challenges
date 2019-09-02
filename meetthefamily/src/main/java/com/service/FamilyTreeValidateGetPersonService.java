package com.service;

import java.util.Map;

import com.dto.Person;

public interface FamilyTreeValidateGetPersonService {

	public String validateGetRelatives(Map<String, Person> familyMembers, String personName, String relationship);
}
