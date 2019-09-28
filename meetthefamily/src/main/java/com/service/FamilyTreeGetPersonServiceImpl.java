package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dto.Person;
import com.utilities.FamilyTreeEnum;

public class FamilyTreeGetPersonServiceImpl extends FamilyTreeManageGetPersonService {

	// Function to get all paternal uncles of a single family member.
	public List<String> getPaternalUncle(Map<String, Person> familyMembers, String personName, String relationship) {

		boolean validationResult = new FamilyTreeValidateGetPersonServiceImpl().isPaternalUncleDeterminable(familyMembers, personName, relationship);
		if(validationResult) {

			Person mother = familyMembers.get(personName).getMother();
			Person father = mother.getSpouse();
			Person paternalGrandmother = father.getMother();

			List<String> uncleNames = new ArrayList<String>();
			List<Person> paternalGrandmothersChildren = paternalGrandmother.getChildren();

			for(Person paternalGrandmothersChild : paternalGrandmothersChildren) {
				if(!paternalGrandmothersChild.getName().equals(father.getName()) && paternalGrandmothersChild.getGender().equals(FamilyTreeEnum.MALE.getMessage())) {
					uncleNames.add(paternalGrandmothersChild.getName());
				}
			}

			return uncleNames;
		}
		else {
			return null;
		}
	}

	// Function to get all maternal uncles of a single family member.
	public List<String> getMaternalUncle(Map<String, Person> familyMembers, String personName, String relationship) {

		boolean validationResult = new FamilyTreeValidateGetPersonServiceImpl().isMaternalUncleDeterminable(familyMembers, personName, relationship);
		if(validationResult) {

			Person mother = familyMembers.get(personName).getMother();
			Person maternalGrandmother = mother.getMother();

			List<String> uncleNames = new ArrayList<String>();
			List<Person> maternalGrandmothersChildren = maternalGrandmother.getChildren();

			for(Person maternalGrandmothersChild : maternalGrandmothersChildren) {
				if(maternalGrandmothersChild.getGender().equals(FamilyTreeEnum.MALE.getMessage())) {
					uncleNames.add(maternalGrandmothersChild.getName());
				}
			}

			return uncleNames;
		}
		else {
			return null;
		}
	}

	// Function to get all paternal aunts of a single family member.
	public List<String> getPaternalAunt(Map<String, Person> familyMembers, String personName, String relationship) {

		boolean validationResult = new FamilyTreeValidateGetPersonServiceImpl().isPaternalAuntDeterminable(familyMembers, personName, relationship);
		if(validationResult) {

			Person mother = familyMembers.get(personName).getMother();
			Person father = mother.getSpouse();
			Person paternalGrandmother = father.getMother();

			List<String> auntNames = new ArrayList<String>();
			List<Person> paternalGrandmothersChildren = paternalGrandmother.getChildren();

			for(Person paternalGrandmothersChild : paternalGrandmothersChildren) {
				if(paternalGrandmothersChild.getGender().equals(FamilyTreeEnum.FEMALE.getMessage())) {
					auntNames.add(paternalGrandmothersChild.getName());
				}
			}

			return auntNames;
		}
		else {
			return null;
		}
	}

	// Function to get all maternal aunts of a single family member.
	public List<String> getMaternalAunt(Map<String, Person> familyMembers, String personName, String relationship) {

		boolean validationResult = new FamilyTreeValidateGetPersonServiceImpl().isMaternalAuntDeterminable(familyMembers, personName, relationship);
		if(validationResult) {

			Person mother = familyMembers.get(personName).getMother();
			Person maternalGrandmother = mother.getMother();

			List<String> auntNames = new ArrayList<String>();
			List<Person> maternalGrandmothersChildren = maternalGrandmother.getChildren();

			for(Person maternalGrandmothersChild : maternalGrandmothersChildren) {
				if(!maternalGrandmothersChild.getName().equals(mother.getName()) && maternalGrandmothersChild.getGender().equals(FamilyTreeEnum.FEMALE.getMessage())) {
					auntNames.add(maternalGrandmothersChild.getName());
				}
			}

			return auntNames;
		}
		else {
			return null;
		}
	}

	// Function to get all sisters-in-law of a single family member.
	public List<String> getSistersInLaw(Map<String, Person> familyMembers, String personName, String relationship) {

		boolean validationResult = new FamilyTreeValidateGetPersonServiceImpl().isPersonDeterminable(familyMembers, personName, relationship);
		if(validationResult) {

			List<String> sistersInLawNames = new ArrayList<String>();
			Person person = familyMembers.get(personName);

			Person spouse = person.getSpouse();
			if(spouse != null) {

				Person spousesMother = spouse.getMother();
				if(spousesMother != null) {

					List<Person> spousesMothersChildren = spousesMother.getChildren();

					for(Person spousesMothersChild : spousesMothersChildren) {
						if(!spousesMothersChild.getName().equals(person.getSpouse().getName()) && spousesMothersChild.getGender().equals(FamilyTreeEnum.FEMALE.getMessage())) {
							sistersInLawNames.add(spousesMothersChild.getName());
						}
					}
				}
			}

			Person mother = person.getMother();
			if(mother != null) {
				List<Person> mothersChildren = mother.getChildren();

				for(Person mothersChild : mothersChildren) {
					if(!mothersChild.getName().equals(person.getName()) && mothersChild.getGender().equals(FamilyTreeEnum.MALE.getMessage()) && mothersChild.getSpouse() != null) {
						sistersInLawNames.add(mothersChild.getSpouse().getName());
					}
				}
			}

			return sistersInLawNames;
		}
		else {
			return null;
		}
	}

	// Function to get all brothers-in-law of a single family member.
	public List<String> getBrothersInLaw(Map<String, Person> familyMembers, String personName, String relationship) {

		boolean validationResult = new FamilyTreeValidateGetPersonServiceImpl().isPersonDeterminable(familyMembers, personName, relationship);
		if(validationResult) {

			List<String> brothersInLawNames = new ArrayList<String>();
			Person person = familyMembers.get(personName);

			Person spouse = person.getSpouse();
			if(spouse != null) {

				Person spousesMother = spouse.getMother();
				if(spousesMother != null) {

					List<Person> spousesMothersChildren = spousesMother.getChildren();

					for(Person spousesMothersChild : spousesMothersChildren) {
						if(!spousesMothersChild.getName().equals(person.getSpouse().getName()) && spousesMothersChild.getGender().equals(FamilyTreeEnum.MALE.getMessage())) {
							brothersInLawNames.add(spousesMothersChild.getName());
						}
					}
				}
			}

			Person mother = person.getMother();
			if(mother != null) {
				List<Person> mothersChildren = mother.getChildren();

				for(Person mothersChild : mothersChildren) {
					if(!mothersChild.getName().equals(person.getName()) && mothersChild.getGender().equals(FamilyTreeEnum.FEMALE.getMessage()) && mothersChild.getSpouse() != null) {
						brothersInLawNames.add(mothersChild.getSpouse().getName());
					}
				}
			}

			return brothersInLawNames;
		}
		else {
			return null;
		}
	}

	// Function to get sons of a single family member.
	public List<String> getSons(Map<String, Person> familyMembers, String personName, String relationship) {

		boolean validationResult = new FamilyTreeValidateGetPersonServiceImpl().isPersonDeterminable(familyMembers, personName, relationship);
		if(validationResult) {

			List<String> sonsNames = new ArrayList<String>();
			Person person = familyMembers.get(personName);
			Person mother = person.getGender().equals(FamilyTreeEnum.FEMALE.getMessage()) ? person : person.getSpouse();
			if(mother != null) {

				List<Person> children = mother.getChildren();

				for(Person child : children) {
					if(child.getGender().equals(FamilyTreeEnum.MALE.getMessage())) {
						sonsNames.add(child.getName());
					}
				}
			}

			return sonsNames;
		}
		else {
			return null;
		}
	}

	// Function to get daughters of a single family member.
	public List<String> getDaughters(Map<String, Person> familyMembers, String personName, String relationship) {

		boolean validationResult = new FamilyTreeValidateGetPersonServiceImpl().isPersonDeterminable(familyMembers, personName, relationship);
		if(validationResult) {

			List<String> daughtersNames = new ArrayList<String>();
			Person person = familyMembers.get(personName);
			Person mother = person.getGender().equals(FamilyTreeEnum.FEMALE.getMessage()) ? person : person.getSpouse();
			if(mother != null) {

				List<Person> children = mother.getChildren();

				for(Person child : children) {
					if(child.getGender().equals(FamilyTreeEnum.FEMALE.getMessage())) {
						daughtersNames.add(child.getName());
					}
				}
			}

			return daughtersNames;
		}
		else {
			return null;
		}
	}

	// Function to get siblings of a single family member.
	public List<String> getSiblings(Map<String, Person> familyMembers, String personName, String relationship) {

		boolean validationResult = new FamilyTreeValidateGetPersonServiceImpl().isPersonDeterminable(familyMembers, personName, relationship);
		if(validationResult) {

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
		else {
			return null;
		}
	}
}
