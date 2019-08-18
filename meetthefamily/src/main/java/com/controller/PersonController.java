package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dto.Person;

public class PersonController {

	private static HashMap<String, Person> familyMembers = new HashMap<String, Person>();
	/* 
	 * Storing a local map of Person object references for quick lookup.
	 * KEY: Person names
	 * VALUE: Person object references
	 */


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
	
	
	private static void constructInitialFamilyTree() {

		// ->-> LEVEL 1 <-<-
		Person kingShan = new Person("Shan", "male");
		Person queenAnga = new Person("Anga", "female");

		kingShan.setSpouse(queenAnga);
		queenAnga.setSpouse(kingShan);

		familyMembers.put("Shan", kingShan);
		familyMembers.put("Anga", queenAnga);


		// ->-> LEVEL 2 <-<-
		Person chit = new Person("Chit", "male");
		Person amba = new Person("Amba", "female");

		chit.setSpouse(amba);
		amba.setSpouse(chit);

		familyMembers.put("Chit", chit);
		familyMembers.put("Amba", amba);


		Person ish = new Person("Ish", "male");
		familyMembers.put("Ish", ish);


		Person vich = new Person("Vich", "male");
		Person lika = new Person("Lika", "female");

		vich.setSpouse(lika);
		lika.setSpouse(vich);

		familyMembers.put("Vich", vich);
		familyMembers.put("Lika", lika);


		Person aras = new Person("Aras", "male");
		Person chitra = new Person("Chitra", "female");

		aras.setSpouse(chitra);
		chitra.setSpouse(aras);

		familyMembers.put("Aras", aras);
		familyMembers.put("Chitra", chitra);


		Person satya = new Person("Satya", "female");
		Person vyan = new Person("Vyan", "male");

		satya.setSpouse(vyan);
		vyan.setSpouse(satya);

		familyMembers.put("Satya", satya);
		familyMembers.put("Vyan", vyan);


		List<Person> angasChildren = new ArrayList<Person>();
		angasChildren.add(chit);
		angasChildren.add(ish);
		angasChildren.add(vich);
		angasChildren.add(aras);
		angasChildren.add(satya);
		queenAnga.setChildren(angasChildren);


		// ->-> LEVEL 3 <-<-

		// -> SEGMENT 1 <-
		Person dritha = new Person("Dritha", "female");
		Person jaya = new Person("Jaya", "male");

		dritha.setSpouse(jaya);
		jaya.setSpouse(dritha);

		familyMembers.put("Dritha", dritha);
		familyMembers.put("Jaya", jaya);


		Person tritha = new Person("Tritha", "female");
		familyMembers.put("Tritha", tritha);

		Person vritha = new Person("Vritha", "male");
		familyMembers.put("Vritha", vritha);


		List<Person> ambasChildren = new ArrayList<Person>();
		ambasChildren.add(chit);
		ambasChildren.add(ish);
		ambasChildren.add(vich);
		amba.setChildren(ambasChildren);


		// -> SEGMENT 2 <-
		Person vila = new Person("Vila", "female");
		familyMembers.put("Vila", vila);

		Person chika = new Person("Chika", "female");
		familyMembers.put("Chika", chika);


		List<Person> likasChildren = new ArrayList<Person>();
		likasChildren.add(vila);
		likasChildren.add(chika);
		lika.setChildren(likasChildren);


		// -> SEGMENT 3 <-
		Person arit = new Person("Arit", "male");
		Person jnki = new Person("Jnki", "female");

		arit.setSpouse(jnki);
		jnki.setSpouse(arit);

		familyMembers.put("Arit", arit);
		familyMembers.put("Jnki", jnki);


		Person ahit = new Person("Ahit", "male");
		familyMembers.put("Ahit", ahit);


		List<Person> chitrasChildren = new ArrayList<Person>();
		chitrasChildren.add(jnki);
		chitrasChildren.add(ahit);
		chitra.setChildren(chitrasChildren);


		// -> SEGMENT 4 <-
		Person satvy = new Person("Satvy", "female");
		Person asva = new Person("Asva", "male");

		satvy.setSpouse(asva);
		asva.setSpouse(satvy);

		familyMembers.put("Satvy", satvy);
		familyMembers.put("Asva", asva);


		Person krpi = new Person("Krpi", "female");
		Person vyas = new Person("Vyas", "male");

		krpi.setSpouse(vyas);
		vyas.setSpouse(krpi);

		familyMembers.put("Krpi", krpi);
		familyMembers.put("Vyas", vyas);


		Person atya = new Person("Atya", "female");
		familyMembers.put("Atya", atya);


		List<Person> satyasChildren = new ArrayList<Person>();
		satyasChildren.add(asva);
		satyasChildren.add(vyas);
		satyasChildren.add(atya);
		satya.setChildren(satyasChildren);


		// ->-> LEVEL 4 <-<-

		// -> SEGMENT 1 <-
		Person yodhan = new Person("Yodhan", "male");
		familyMembers.put("Yodhan", yodhan);


		List<Person> drithasChildren = new ArrayList<Person>();
		drithasChildren.add(yodhan);
		dritha.setChildren(drithasChildren);
		
		
		// -> SEGMENT 2 <-
		Person laki = new Person("Laki", "male");
		familyMembers.put("Laki", laki);
		
		Person lavnya = new Person("Lavnya", "female");
		familyMembers.put("Lavnya", lavnya);


		List<Person> jnkisChildren = new ArrayList<Person>();
		jnkisChildren.add(laki);
		jnkisChildren.add(lavnya);
		jnki.setChildren(jnkisChildren);
		
		
		// -> SEGMENT 3 <-
		Person vasa = new Person("Vasa", "male");
		familyMembers.put("Vasa", vasa);


		List<Person> satvysChildren = new ArrayList<Person>();
		satvysChildren.add(vasa);
		satvy.setChildren(satvysChildren);
		
		
		// -> SEGMENT 4 <-
		Person kriya = new Person("Kriya", "male");
		familyMembers.put("Kriya", kriya);
		
		Person krithi = new Person("Krithi", "female");
		familyMembers.put("Krithi", krithi);


		List<Person> krpisChildren = new ArrayList<Person>();
		krpisChildren.add(kriya);
		krpisChildren.add(krithi);
		krpi.setChildren(krpisChildren);
	}


	public static void main(String[] args) {

		constructInitialFamilyTree();
	}
}
