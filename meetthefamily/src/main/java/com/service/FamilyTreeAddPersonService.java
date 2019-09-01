package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dto.Person;
import com.utilities.FamilyTreeEnum;

public class FamilyTreeAddPersonService {

	public static void constructInitialFamilyTree(Map<String, Person> familyMembers) {

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
	
	
	public static String addChild(Map<String, Person> familyMembers, String mothersName, String childsName, String childsGender) {

		if(familyMembers.containsKey(childsName)) {
			return FamilyTreeEnum.CHILD_ADDITION_FAILED.getMessageAsString();
		}
		if(!familyMembers.containsKey(mothersName)) {
			return FamilyTreeEnum.PERSON_NOT_FOUND.getMessageAsString();
		}
		if(familyMembers.containsKey(mothersName) && !familyMembers.get(mothersName).getGender().equals("female")) {
			return FamilyTreeEnum.CHILD_ADDITION_FAILED.getMessageAsString();
		}

		childsGender = childsGender.toLowerCase();
		if(!(childsGender.equals("male") || childsGender.equals("female"))) {
			return FamilyTreeEnum.CHILD_ADDITION_FAILED.getMessageAsString();
		}

		Person child = new Person(childsName, childsGender);
		child.setMother(familyMembers.get(mothersName));

		List<Person> mothersChildren = familyMembers.get(mothersName).getChildren();
		if(mothersChildren == null) {
			mothersChildren = new ArrayList<Person>();
		}
		mothersChildren.add(child);

		familyMembers.put(childsName, child);

		return FamilyTreeEnum.CHILD_ADDITION_SUCCEEDED.getMessageAsString();
	}
}
