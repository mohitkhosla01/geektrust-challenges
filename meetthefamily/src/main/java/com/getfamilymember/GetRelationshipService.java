package com.getfamilymember;

import java.util.List;
import java.util.ArrayList;

import com.dto.Person;
import com.utilities.FamilyTreeEnum;

/* 
 * This class contains functions that can be invoked to get family members by relationship from the Shan family tree.
 */
public class GetRelationshipService extends RelationshipMapper {
	
	// Function to get relatives from the Shan family tree.
	public String getRelatives(Person shan, String[] inputParameters) throws Exception {

		if(inputParameters.length == 3) {
			String person = inputParameters[1];
			String relationship = inputParameters[2];

			List<String> relatives = mapRelationships(shan, person, relationship);

			if(relatives != null && relatives.size() > 0) {
				StringBuilder relativeNames = new StringBuilder();
	
				for(String relative : relatives) {
					relativeNames.append(relative);
					relativeNames.append(" ");
				}
				return relativeNames.toString().trim();
			}
			else if(relatives == null) {
				return FamilyTreeEnum.PERSON_NOT_FOUND.getMessage();
			}
			else {
				return FamilyTreeEnum.NONE.getMessage();
			}
		}
		else {
			return FamilyTreeEnum.INVALID_INPUT.getMessage();
		}
	}
	
	// Function to get paternal uncles of a Shan family tree member.
	public List<String> getPaternalUncle(Person shan, String personName, String relationship) throws Exception {
		
		Person person = shan.getFamilyMember(personName);
		if(person != null) {
			
			Person mother = person.getMother();
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

	// Function to get maternal uncles of a Shan family tree member.
	public List<String> getMaternalUncle(Person shan, String personName, String relationship) throws Exception {
		
		Person person = shan.getFamilyMember(personName);
		if(person != null) {
			
			Person mother = person.getMother();
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

	// Function to get paternal aunts of a Shan family tree member.
	public List<String> getPaternalAunt(Person shan, String personName, String relationship) throws Exception {
		
		Person person = shan.getFamilyMember(personName);
		if(person != null) {
			
			Person mother = person.getMother();
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

	// Function to get maternal aunts of a Shan family tree member.
	public List<String> getMaternalAunt(Person shan, String personName, String relationship) throws Exception {
		
		Person person = shan.getFamilyMember(personName);
		if(person != null) {
			
			Person mother = person.getMother();
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

	// Function to get sisters-in-law of a Shan family tree member.
	public List<String> getSistersInLaw(Person shan, String personName, String relationship) throws Exception {

		Person person = shan.getFamilyMember(personName);
		if(person != null) {
			
			List<String> sistersInLawNames = new ArrayList<String>();
			
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

	// Function to get brothers-in-law of a Shan family tree member.
	public List<String> getBrothersInLaw(Person shan, String personName, String relationship) throws Exception {
		
		Person person = shan.getFamilyMember(personName);
		if(person != null) {
			
			List<String> brothersInLawNames = new ArrayList<String>();
			
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

	// Function to get sons of a Shan family tree member.
	public List<String> getSons(Person shan, String personName, String relationship) throws Exception {
		
		Person person = shan.getFamilyMember(personName);
		if(person != null) {
			
			List<String> sonsNames = new ArrayList<String>();
			
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

	// Function to get daughters of a Shan family tree member.
	public List<String> getDaughters(Person shan, String personName, String relationship) throws Exception {
		
		Person person = shan.getFamilyMember(personName);
		if(person != null) {
			
			List<String> daughtersNames = new ArrayList<String>();
			
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

	// Function to get siblings of a Shan family tree member.
	public List<String> getSiblings(Person shan, String personName, String relationship) throws Exception {
		
		Person person = shan.getFamilyMember(personName);
		if(person != null) {
			
			List<String> siblingsNames = new ArrayList<String>();
			
			Person mother = person.getMother();
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
