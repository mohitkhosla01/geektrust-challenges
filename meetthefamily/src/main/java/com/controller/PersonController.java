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
			return "MOTHER_DOES NOT_EXIST";
		}

		gender = gender.toLowerCase();
		if(!(gender.equals("male") || gender.equals("female"))) {
			return "GENDER_INVALID";
		}

		Person child = new Person(childName, gender);
		child.setMother(familyMembers.get(motherName));

		List<Person> children = familyMembers.get(motherName).getChildren();
		if(children == null) {
			children = new ArrayList<Person>();
		}
		children.add(child);
		
		familyMembers.put(childName, child);

		return null;
	}
	
	private static String getPaternalUncle(String personName, String relationship) {
		
		return null;
	}
	
	private static String getMaternalUncle(String personName, String relationship) {
		
		return null;
	}
	
	private static String getPaternalAunt(String personName, String relationship) {
		
		return null;
	}
	
	private static String getMaternalAunt(String personName, String relationship) {
		
		return null;
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
