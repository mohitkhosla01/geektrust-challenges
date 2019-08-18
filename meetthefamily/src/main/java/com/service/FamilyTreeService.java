package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dto.Person;

public class FamilyTreeService {

	private static HashMap<String, Person> familyMembers = new HashMap<String, Person>();
	/* 
	 * Storing a local map of Person object references for quick lookup.
	 * KEY: Person names
	 * VALUE: Person object references
	 */


	public static String addChild(String mothersName, String childsName, String childsGender) {

		if(familyMembers.containsKey(childsName)) {
			return "CHILD_ADDITION_FAILED";
		}
		if(!familyMembers.containsKey(mothersName)) {
			return "PERSON_NOT_FOUND";
		}
		if(familyMembers.containsKey(mothersName) && !familyMembers.get(mothersName).getGender().equals("female")) {
			return "CHILD_ADDITION_FAILED";
		}

		childsGender = childsGender.toLowerCase();
		if(!(childsGender.equals("male") || childsGender.equals("female"))) {
			return "CHILD_ADDITION_FAILED";
		}

		Person child = new Person(childsName, childsGender);
		child.setMother(familyMembers.get(mothersName));

		List<Person> mothersChildren = familyMembers.get(mothersName).getChildren();
		if(mothersChildren == null) {
			mothersChildren = new ArrayList<Person>();
		}
		mothersChildren.add(child);

		familyMembers.put(childsName, child);

		return "CHILD_ADDITION_SUCCEEDED";
	}
	
	
	public static List<String> getRelatives(String personName, String relationship) {
		
		if(relationship.equals("Paternal-Uncle")) {
			return getPaternalUncle(personName, relationship);
		}
		else if(relationship.equals("Maternal-Uncle")) {
			return getMaternalUncle(personName, relationship);
		}
		else if(relationship.equals("Paternal-Aunt")) {
			return getPaternalAunt(personName, relationship);
		}
		else if(relationship.equals("Maternal-Aunt")) {
			return getMaternalAunt(personName, relationship);
		}
		else if(relationship.equals("Sister-In-Law")) {
			return getSistersInLaw(personName, relationship);
		}
		else if(relationship.equals("Brother-In-Law")) {
			return getBrothersInLaw(personName, relationship);
		}
		else if(relationship.equals("Son")) {
			return getSons(personName, relationship);
		}
		else if(relationship.equals("Daughter")) {
			return getDaughters(personName, relationship);
		}
		else if(relationship.equals("Siblings")) {
			return getSiblings(personName, relationship);
		}
		else {
			List<String> invalidInput = new ArrayList<String>();
			invalidInput.add("INVALID_INPUT");
			return invalidInput;
		}
	}


	public static List<String> getPaternalUncle(String personName, String relationship) {

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


	public static List<String> getMaternalUncle(String personName, String relationship) {

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


	public static List<String> getPaternalAunt(String personName, String relationship) {

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


	public static List<String> getMaternalAunt(String personName, String relationship) {

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


	public static List<String> getSistersInLaw(String personName, String relationship) {	

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


	public static List<String> getBrothersInLaw(String personName, String relationship) {

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


	public static List<String> getSons(String personName, String relationship) {

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


	public static List<String> getDaughters(String personName, String relationship) {

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


	public static List<String> getSiblings(String personName, String relationship) {

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
	
	
	public static void constructInitialFamilyTree() {

		// ->-> LEVEL 1 <-<-
		Person shan = new Person("Shan", "male");
		Person anga = new Person("Anga", "female");

		shan.setSpouse(anga);
		anga.setSpouse(shan);

		familyMembers.put("Shan", shan);
		familyMembers.put("Anga", anga);


		// ->-> LEVEL 2 <-<-
		Person chit = new Person("Chit", "male");
		Person amba = new Person("Amba", "female");

		chit.setSpouse(amba);
		chit.setMother(anga);
		amba.setSpouse(chit);

		familyMembers.put("Chit", chit);
		familyMembers.put("Amba", amba);


		Person ish = new Person("Ish", "male");
		familyMembers.put("Ish", ish);


		Person vich = new Person("Vich", "male");
		Person lika = new Person("Lika", "female");

		vich.setSpouse(lika);
		vich.setMother(anga);
		lika.setSpouse(vich);

		familyMembers.put("Vich", vich);
		familyMembers.put("Lika", lika);


		Person aras = new Person("Aras", "male");
		Person chitra = new Person("Chitra", "female");

		aras.setSpouse(chitra);
		aras.setMother(anga);
		chitra.setSpouse(aras);

		familyMembers.put("Aras", aras);
		familyMembers.put("Chitra", chitra);


		Person satya = new Person("Satya", "female");
		Person vyan = new Person("Vyan", "male");

		satya.setSpouse(vyan);
		satya.setMother(anga);
		vyan.setSpouse(satya);

		familyMembers.put("Satya", satya);
		familyMembers.put("Vyan", vyan);


		List<Person> angasChildren = new ArrayList<Person>();
		angasChildren.add(chit);
		angasChildren.add(ish);
		angasChildren.add(vich);
		angasChildren.add(aras);
		angasChildren.add(satya);
		anga.setChildren(angasChildren);


		// ->-> LEVEL 3 <-<-

		// -> SEGMENT 1 <-
		Person dritha = new Person("Dritha", "female");
		Person jaya = new Person("Jaya", "male");

		dritha.setSpouse(jaya);
		dritha.setMother(amba);
		jaya.setSpouse(dritha);

		familyMembers.put("Dritha", dritha);
		familyMembers.put("Jaya", jaya);


		Person tritha = new Person("Tritha", "female");
		tritha.setMother(amba);
		familyMembers.put("Tritha", tritha);

		Person vritha = new Person("Vritha", "male");
		vritha.setMother(amba);
		familyMembers.put("Vritha", vritha);


		List<Person> ambasChildren = new ArrayList<Person>();
		ambasChildren.add(chit);
		ambasChildren.add(ish);
		ambasChildren.add(vich);
		amba.setChildren(ambasChildren);


		// -> SEGMENT 2 <-
		Person vila = new Person("Vila", "female");
		vila.setMother(lika);
		familyMembers.put("Vila", vila);

		Person chika = new Person("Chika", "female");
		chika.setMother(lika);
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
		jnki.setMother(chitra);

		familyMembers.put("Arit", arit);
		familyMembers.put("Jnki", jnki);


		Person ahit = new Person("Ahit", "male");
		ahit.setMother(chitra);
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
		asva.setMother(satya);

		familyMembers.put("Satvy", satvy);
		familyMembers.put("Asva", asva);


		Person krpi = new Person("Krpi", "female");
		Person vyas = new Person("Vyas", "male");

		krpi.setSpouse(vyas);
		vyas.setSpouse(krpi);
		vyas.setMother(satya);

		familyMembers.put("Krpi", krpi);
		familyMembers.put("Vyas", vyas);


		Person atya = new Person("Atya", "female");
		atya.setMother(satya);
		familyMembers.put("Atya", atya);


		List<Person> satyasChildren = new ArrayList<Person>();
		satyasChildren.add(asva);
		satyasChildren.add(vyas);
		satyasChildren.add(atya);
		satya.setChildren(satyasChildren);


		// ->-> LEVEL 4 <-<-

		// -> SEGMENT 1 <-
		Person yodhan = new Person("Yodhan", "male");
		yodhan.setMother(dritha);
		familyMembers.put("Yodhan", yodhan);


		List<Person> drithasChildren = new ArrayList<Person>();
		drithasChildren.add(yodhan);
		dritha.setChildren(drithasChildren);
		
		
		// -> SEGMENT 2 <-
		Person laki = new Person("Laki", "male");
		laki.setMother(jnki);
		familyMembers.put("Laki", laki);
		
		Person lavnya = new Person("Lavnya", "female");
		lavnya.setMother(jnki);
		familyMembers.put("Lavnya", lavnya);


		List<Person> jnkisChildren = new ArrayList<Person>();
		jnkisChildren.add(laki);
		jnkisChildren.add(lavnya);
		jnki.setChildren(jnkisChildren);
		
		
		// -> SEGMENT 3 <-
		Person vasa = new Person("Vasa", "male");
		vasa.setMother(satvy);
		familyMembers.put("Vasa", vasa);


		List<Person> satvysChildren = new ArrayList<Person>();
		satvysChildren.add(vasa);
		satvy.setChildren(satvysChildren);
		
		
		// -> SEGMENT 4 <-
		Person kriya = new Person("Kriya", "male");
		kriya.setMother(krpi);
		familyMembers.put("Kriya", kriya);
		
		Person krithi = new Person("Krithi", "female");
		krithi.setMother(krpi);
		familyMembers.put("Krithi", krithi);


		List<Person> krpisChildren = new ArrayList<Person>();
		krpisChildren.add(kriya);
		krpisChildren.add(krithi);
		krpi.setChildren(krpisChildren);
	}
}
