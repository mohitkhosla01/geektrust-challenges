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
			return "CHILD_ADDITION_FAILED";
		}
		if(!familyMembers.containsKey(motherName)) {
			return "CHILD_ADDITION_FAILED";
		}
		if(familyMembers.containsKey(motherName) && !familyMembers.get(motherName).getGender().equals("female")) {
			return "CHILD_ADDITION_FAILED";
		}

		gender = gender.toLowerCase();
		if(!(gender.equals("male") || gender.equals("female"))) {
			return "CHILD_ADDITION_FAILED";
		}

		Person child = new Person(childName, gender);
		child.setMother(familyMembers.get(motherName));

		List<Person> mothersChildren = familyMembers.get(motherName).getChildren();
		if(mothersChildren == null) {
			mothersChildren = new ArrayList<Person>();
		}
		mothersChildren.add(child);

		familyMembers.put(childName, child);

		return "CHILD_ADDITION_SUCCEEDED";
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

		Person paternalGrandmother = father.getMother();
		if(paternalGrandmother == null) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}

		List<Person> paternalGrandmothersChildren = paternalGrandmother.getChildren();

		for(Person paternalGrandmothersChild : paternalGrandmothersChildren) {
			if(!paternalGrandmothersChild.getName().equals(father.getName()) && paternalGrandmothersChild.getGender().equals("male")) {
				uncleNames.add(paternalGrandmothersChild.getName());
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

		Person maternalGrandmother = mother.getMother();
		if(maternalGrandmother == null) {
			uncleNames.add("PERSON_NOT_FOUND");
			return uncleNames;
		}

		List<Person> maternalGrandmothersChildren = maternalGrandmother.getChildren();

		for(Person maternalGrandmothersChild : maternalGrandmothersChildren) {
			if(maternalGrandmothersChild.getGender().equals("male")) {
				uncleNames.add(maternalGrandmothersChild.getName());
			}
		}

		return uncleNames;
	}


	private static List<String> getPaternalAunt(String personName, String relationship) {

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

		Person father = mother.getSpouse();
		if(father == null) {
			auntNames.add("PERSON_NOT_FOUND");
			return auntNames;
		}

		Person paternalGrandmother = father.getMother();
		if(paternalGrandmother == null) {
			auntNames.add("PERSON_NOT_FOUND");
			return auntNames;
		}

		List<Person> paternalGrandmothersChildren = paternalGrandmother.getChildren();

		for(Person paternalGrandmothersChild : paternalGrandmothersChildren) {
			if(paternalGrandmothersChild.getGender().equals("female")) {
				auntNames.add(paternalGrandmothersChild.getName());
			}
		}

		return auntNames;
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

		Person maternalGrandmother = mother.getMother();
		if(maternalGrandmother == null) {
			auntNames.add("PERSON_NOT_FOUND");
			return auntNames;
		}

		List<Person> maternalGrandmothersChildren = maternalGrandmother.getChildren();

		for(Person maternalGrandmothersChild : maternalGrandmothersChildren) {
			if(!maternalGrandmothersChild.getName().equals(mother.getName()) && maternalGrandmothersChild.getGender().equals("female")) {
				auntNames.add(maternalGrandmothersChild.getName());
			}
		}

		return auntNames;
	}


	private static List<String> getSistersInLaw(String personName, String relationship) {	

		List<String> sistersInLawNames = new ArrayList<String>();

		if(!familyMembers.containsKey(personName)) {
			sistersInLawNames.add("PERSON_NOT_FOUND");
			return sistersInLawNames;
		}

		Person person = familyMembers.get(personName);

		Person spouse = person.getSpouse();
		if(spouse != null) {

			Person spousesMother = spouse.getMother();
			if(spousesMother != null) {

				List<Person> spousesMothersChildren = spousesMother.getChildren();

				for(Person spousesMothersChild : spousesMothersChildren) {
					if(spousesMothersChild.getGender().equals("female")) {
						sistersInLawNames.add(spousesMothersChild.getName());
					}
				}
			}
		}

		Person mother = person.getMother();
		if(mother != null) {
			List<Person> mothersChildren = mother.getChildren();

			for(Person mothersChild : mothersChildren) {
				if(!mothersChild.getName().equals(person.getName()) && mothersChild.getGender().equals("male") && mothersChild.getSpouse() != null) {
					sistersInLawNames.add(mothersChild.getSpouse().getName());
				}
			}
		}

		return sistersInLawNames;
	}
	

	private static List<String> getBrothersInLaw(String personName, String relationship) {

		List<String> brothersInLawNames = new ArrayList<String>();

		if(!familyMembers.containsKey(personName)) {
			brothersInLawNames.add("PERSON_NOT_FOUND");
			return brothersInLawNames;
		}

		Person person = familyMembers.get(personName);

		Person spouse = person.getSpouse();
		if(spouse != null) {

			Person spousesMother = spouse.getMother();
			if(spousesMother != null) {

				List<Person> spousesMothersChildren = spousesMother.getChildren();

				for(Person spousesMothersChild : spousesMothersChildren) {
					if(spousesMothersChild.getGender().equals("male")) {
						brothersInLawNames.add(spousesMothersChild.getName());
					}
				}
			}
		}

		Person mother = person.getMother();
		if(mother != null) {
			List<Person> mothersChildren = mother.getChildren();

			for(Person mothersChild : mothersChildren) {
				if(!mothersChild.getName().equals(person.getName()) && mothersChild.getGender().equals("female") && mothersChild.getSpouse() != null) {
					brothersInLawNames.add(mothersChild.getSpouse().getName());
				}
			}
		}

		return brothersInLawNames;
	}


	private static List<String> getSons(String personName, String relationship) {

		List<String> sonsNames = new ArrayList<String>();

		if(!familyMembers.containsKey(personName)) {
			sonsNames.add("PERSON_NOT_FOUND");
			return sonsNames;
		}

		Person person = familyMembers.get(personName);
		Person mother = person.getGender().equals("female") ? person : person.getSpouse();

		List<Person> children = mother.getChildren();

		for(Person child : children) {
			if(child.getGender().equals("male")) {
				sonsNames.add(child.getName());
			}
		}

		return sonsNames;
	}


	private static List<String> getDaughters(String personName, String relationship) {

		List<String> daughtersNames = new ArrayList<String>();

		if(!familyMembers.containsKey(personName)) {
			daughtersNames.add("PERSON_NOT_FOUND");
			return daughtersNames;
		}

		Person person = familyMembers.get(personName);
		Person mother = person.getGender().equals("female") ? person : person.getSpouse();

		List<Person> children = mother.getChildren();

		for(Person child : children) {
			if(child.getGender().equals("female")) {
				daughtersNames.add(child.getName());
			}
		}

		return daughtersNames;
	}
	

	private static List<String> getSiblings(String personName, String relationship) {

		List<String> siblingsNames = new ArrayList<String>();

		if(!familyMembers.containsKey(personName)) {
			siblingsNames.add("PERSON_NOT_FOUND");
			return siblingsNames;
		}

		Person mother = familyMembers.get(personName).getMother();

		List<Person> children = mother.getChildren();

		for(Person child : children) {
			if(!child.getName().equals(personName)) {
				siblingsNames.add(child.getName());
			}
		}

		return siblingsNames;
	}
}
