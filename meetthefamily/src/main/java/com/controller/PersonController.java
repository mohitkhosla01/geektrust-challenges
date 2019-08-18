package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dto.Person;

public class PersonController {

	private static HashMap<String, Person> familyMembers = new HashMap<String, Person>();
	/* 
	 * Storing a local map of Person object references for fast retrieval.
	 * KEY: Person names
	 * VALUE: Person object references
	 */

	
	public static void main(String[] args) {

		Person kingShan = new Person("Shan", "male");
		Person queenAnga = new Person("Anga", "female");

		kingShan.setSpouse(queenAnga);
		queenAnga.setSpouse(kingShan);

		familyMembers.put("Shan", kingShan);
		familyMembers.put("Anga", queenAnga);
	}
	
	
	private static String addChild(String motherName, String childName, String gender) {

		if(familyMembers.containsKey(childName)) {
			return "PERSON_ALREADY_EXISTS";
		}
		if(!familyMembers.containsKey(motherName)) {
			return "PERSON_NOT_FOUND";
		}
		if(familyMembers.containsKey(motherName) && !familyMembers.get(motherName).getGender().equals("female")) {
			return "CHILD_ADDITION_FAILED";
		}

		gender = gender.toLowerCase();
		if(!(gender.equals("male") || gender.equals("female"))) {
			return "GENDER_INVALID";
		}

		Person child = new Person(childName, gender);
		child.setMother(familyMembers.get(motherName));

		List<Person> mothersChildren = familyMembers.get(motherName).getChildren();
		if(mothersChildren == null) {
			mothersChildren = new ArrayList<Person>();
		}
		mothersChildren.add(child);
		
		familyMembers.put(childName, child);

		return null;
	}
	
	
	private static List<String> getPaternalUncle(String personName, String relationship) {
		
		List<String> uncleNames = new ArrayList<String>();
		
		if(!familyMembers.containsKey(personName)) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}
		
		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}
		
		Person father = mother.getSpouse();
		if(father == null) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}
		
		Person grandmother = father.getMother();
		if(grandmother == null) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}
		
		List<Person> grandmothersChildren = grandmother.getChildren();
		
		for(Person grandmothersChild : grandmothersChildren) {
			if(!grandmothersChild.getName().equals(father.getName()) && grandmothersChild.getGender().equals("male")) {
				uncleNames.add(grandmothersChild.getName());
			}
		}
		
		return uncleNames;
	}
	
	
	private static List<String> getMaternalUncle(String personName, String relationship) {
		
		List<String> uncleNames = new ArrayList<String>();
		
		if(!familyMembers.containsKey(personName)) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}
		
		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}
		
		Person grandmother = mother.getMother();
		if(grandmother == null) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}
		
		List<Person> grandmothersChildren = grandmother.getChildren();
		
		for(Person grandmothersChild : grandmothersChildren) {
			if(grandmothersChild.getGender().equals("male")) {
				uncleNames.add(grandmothersChild.getName());
			}
		}
		
		return uncleNames;
	}
	
	
	private static List<String> getPaternalAunt(String personName, String relationship) {
		
		List<String> uncleNames = new ArrayList<String>();
		
		if(!familyMembers.containsKey(personName)) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}
		
		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}
		
		Person father = mother.getSpouse();
		if(father == null) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}
		
		Person grandmother = father.getMother();
		if(grandmother == null) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}
		
		List<Person> grandmothersChildren = grandmother.getChildren();
		
		for(Person grandmothersChild : grandmothersChildren) {
			if(grandmothersChild.getGender().equals("female")) {
				uncleNames.add(grandmothersChild.getName());
			}
		}
		
		return uncleNames;
	}
	
	
	private static List<String> getMaternalAunt(String personName, String relationship) {
		
		List<String> auntNames = new ArrayList<String>();
		
		if(!familyMembers.containsKey(personName)) {
			auntNames.add("PERSON_NOT_FOUND");
			return auntNames;
		}
		
		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			auntNames.add("PERSON_NOT_FOUND");
			return auntNames;
		}
		
		Person grandmother = mother.getMother();
		if(grandmother == null) {
			auntNames.add("PERSON_NOT_FOUND");
			return auntNames;
		}
		
		List<Person> grandmothersChildren = grandmother.getChildren();
		
		for(Person grandmothersChild : grandmothersChildren) {
			if(!grandmothersChild.getName().equals(mother.getName()) && grandmothersChild.getGender().equals("female")) {
				auntNames.add(grandmothersChild.getName());
			}
		}
		
		return auntNames;
	}
	
	private static List<String> getSistersInLaw(String personName, String relationship) {
		
		return null;
	}
	
	private static List<String> getBrothersInLaw(String personName, String relationship) {
		
		return null;
	}
	
	private static List<String> getSons(String personName, String relationship) {
		
		return null;
	}
	
	private static List<String> getDaughters(String personName, String relationship) {
		
		return null;
	}
	
	private static List<String> getSiblings(String personName, String relationship) {
		
		return null;
	}
}
