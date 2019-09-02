package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dto.Person;
import com.utilities.FamilyTreeEnum;

public class FamilyTreeGetPersonServiceImpl extends FamilyTreeManageGetPersonService {

	
	public List<String> getPaternalUncle(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		Person father = mother.getSpouse();
		if(father == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		Person paternalGrandmother = father.getMother();
		if(paternalGrandmother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}
		
		List<String> uncleNames = new ArrayList<String>();
		List<Person> paternalGrandmothersChildren = paternalGrandmother.getChildren();

		for(Person paternalGrandmothersChild : paternalGrandmothersChildren) {
			if(!paternalGrandmothersChild.getName().equals(father.getName()) && paternalGrandmothersChild.getGender().equals("male")) {
				uncleNames.add(paternalGrandmothersChild.getName());
			}
		}

		return uncleNames;
	}


	public List<String> getMaternalUncle(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		Person maternalGrandmother = mother.getMother();
		if(maternalGrandmother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		List<String> uncleNames = new ArrayList<String>();
		List<Person> maternalGrandmothersChildren = maternalGrandmother.getChildren();

		for(Person maternalGrandmothersChild : maternalGrandmothersChildren) {
			if(maternalGrandmothersChild.getGender().equals("male")) {
				uncleNames.add(maternalGrandmothersChild.getName());
			}
		}

		return uncleNames;
	}


	public List<String> getPaternalAunt(Map<String, Person> familyMembers, String personName, String relationship) {
		
		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		Person father = mother.getSpouse();
		if(father == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		Person paternalGrandmother = father.getMother();
		if(paternalGrandmother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		List<String> auntNames = new ArrayList<String>();
		List<Person> paternalGrandmothersChildren = paternalGrandmother.getChildren();

		for(Person paternalGrandmothersChild : paternalGrandmothersChildren) {
			if(paternalGrandmothersChild.getGender().equals("female")) {
				auntNames.add(paternalGrandmothersChild.getName());
			}
		}

		return auntNames;
	}


	public List<String> getMaternalAunt(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		Person mother = familyMembers.get(personName).getMother();
		if(mother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		Person maternalGrandmother = mother.getMother();
		if(maternalGrandmother == null) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		List<String> auntNames = new ArrayList<String>();
		List<Person> maternalGrandmothersChildren = maternalGrandmother.getChildren();

		for(Person maternalGrandmothersChild : maternalGrandmothersChildren) {
			if(!maternalGrandmothersChild.getName().equals(mother.getName()) && maternalGrandmothersChild.getGender().equals("female")) {
				auntNames.add(maternalGrandmothersChild.getName());
			}
		}

		return auntNames;
	}


	public List<String> getSistersInLaw(Map<String, Person> familyMembers, String personName, String relationship) {	

		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		List<String> sistersInLawNames = new ArrayList<String>();
		Person person = familyMembers.get(personName);

		Person spouse = person.getSpouse();
		if(spouse != null) {

			Person spousesMother = spouse.getMother();
			if(spousesMother != null) {

				List<Person> spousesMothersChildren = spousesMother.getChildren();

				for(Person spousesMothersChild : spousesMothersChildren) {
					if(!spousesMothersChild.getName().equals(person.getSpouse().getName()) && spousesMothersChild.getGender().equals("female")) {
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


	public List<String> getBrothersInLaw(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		List<String> brothersInLawNames = new ArrayList<String>();
		Person person = familyMembers.get(personName);

		Person spouse = person.getSpouse();
		if(spouse != null) {

			Person spousesMother = spouse.getMother();
			if(spousesMother != null) {

				List<Person> spousesMothersChildren = spousesMother.getChildren();

				for(Person spousesMothersChild : spousesMothersChildren) {
					if(!spousesMothersChild.getName().equals(person.getSpouse().getName()) && spousesMothersChild.getGender().equals("male")) {
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


	public List<String> getSons(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		List<String> sonsNames = new ArrayList<String>();
		Person person = familyMembers.get(personName);
		Person mother = person.getGender().equals("female") ? person : person.getSpouse();
		if(mother != null) {

			List<Person> children = mother.getChildren();

			for(Person child : children) {
				if(child.getGender().equals("male")) {
					sonsNames.add(child.getName());
				}
			}
		}

		return sonsNames;
	}


	public List<String> getDaughters(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		List<String> daughtersNames = new ArrayList<String>();
		Person person = familyMembers.get(personName);
		Person mother = person.getGender().equals("female") ? person : person.getSpouse();
		if(mother != null) {

			List<Person> children = mother.getChildren();

			for(Person child : children) {
				if(child.getGender().equals("female")) {
					daughtersNames.add(child.getName());
				}
			}
		}

		return daughtersNames;
	}


	public List<String> getSiblings(Map<String, Person> familyMembers, String personName, String relationship) {

		if(!familyMembers.containsKey(personName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsList();
		}

		List<String> siblingsNames = new ArrayList<String>();
		Person mother = familyMembers.get(personName).getMother();
		if(mother != null) {

			List<Person> children = mother.getChildren();

			for(Person child : children) {
				if(!child.getName().equals(personName)) {
					siblingsNames.add(child.getName());
				}
			}
		}

		return siblingsNames;
	}
}
