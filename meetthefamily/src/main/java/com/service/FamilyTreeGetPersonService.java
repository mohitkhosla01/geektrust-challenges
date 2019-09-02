package com.service;

import java.util.List;
import java.util.Map;

import com.dto.Person;

public interface FamilyTreeGetPersonService {

	List<String> getRelatives(Map<String, Person> familyMembers, String personName, String relationship);
}
