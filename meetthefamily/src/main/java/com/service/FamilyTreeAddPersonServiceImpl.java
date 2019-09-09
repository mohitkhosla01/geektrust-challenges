package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dto.Person;
import com.exception.FamilyTreeException;
import com.utilities.FamilyTreeConstants;
import com.utilities.FamilyTreeEnum;

public class FamilyTreeAddPersonServiceImpl implements FamilyTreeAddPersonService {

	/* 
	 * Function to add all family members of the Shan family to the 'familyMembers' data structure.
	 * Details of these family members are predefined.
	 */
	public void constructInitialFamilyTree(Map<String, Person> familyMembers) {

		// ->-> LEVEL 1 <-<-
		Person shan = new Person("Shan", FamilyTreeConstants.MALE, null);
		Person anga = new Person("Anga", FamilyTreeConstants.FEMALE, null);

		shan.setSpouse(anga);
		anga.setSpouse(shan);

		familyMembers.put("Shan", shan);
		familyMembers.put("Anga", anga);


		// ->-> LEVEL 2 <-<-
		Person chit = new Person("Chit", FamilyTreeConstants.MALE, anga);
		Person amba = new Person("Amba", FamilyTreeConstants.FEMALE, null);

		chit.setSpouse(amba);
		amba.setSpouse(chit);

		familyMembers.put("Chit", chit);
		familyMembers.put("Amba", amba);


		Person ish = new Person("Ish", FamilyTreeConstants.MALE, anga);
		familyMembers.put("Ish", ish);


		Person vich = new Person("Vich", FamilyTreeConstants.MALE, anga);
		Person lika = new Person("Lika", FamilyTreeConstants.FEMALE, null);

		vich.setSpouse(lika);
		lika.setSpouse(vich);

		familyMembers.put("Vich", vich);
		familyMembers.put("Lika", lika);


		Person aras = new Person("Aras", FamilyTreeConstants.MALE, anga);
		Person chitra = new Person("Chitra", FamilyTreeConstants.FEMALE, null);

		aras.setSpouse(chitra);
		chitra.setSpouse(aras);

		familyMembers.put("Aras", aras);
		familyMembers.put("Chitra", chitra);


		Person satya = new Person("Satya", FamilyTreeConstants.FEMALE, anga);
		Person vyan = new Person("Vyan", FamilyTreeConstants.MALE, null);

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
		anga.setChildren(angasChildren);


		// ->-> LEVEL 3 <-<-

		// -> SEGMENT 1 <-
		Person dritha = new Person("Dritha", FamilyTreeConstants.FEMALE, amba);
		Person jaya = new Person("Jaya", FamilyTreeConstants.MALE, null);

		dritha.setSpouse(jaya);
		jaya.setSpouse(dritha);

		familyMembers.put("Dritha", dritha);
		familyMembers.put("Jaya", jaya);


		Person tritha = new Person("Tritha", FamilyTreeConstants.FEMALE, amba);
		familyMembers.put("Tritha", tritha);

		Person vritha = new Person("Vritha", FamilyTreeConstants.MALE, amba);
		familyMembers.put("Vritha", vritha);


		List<Person> ambasChildren = new ArrayList<Person>();
		ambasChildren.add(chit);
		ambasChildren.add(ish);
		ambasChildren.add(vich);
		amba.setChildren(ambasChildren);


		// -> SEGMENT 2 <-
		Person vila = new Person("Vila", FamilyTreeConstants.FEMALE, lika);
		familyMembers.put("Vila", vila);

		Person chika = new Person("Chika", FamilyTreeConstants.FEMALE, lika);
		familyMembers.put("Chika", chika);


		List<Person> likasChildren = new ArrayList<Person>();
		likasChildren.add(vila);
		likasChildren.add(chika);
		lika.setChildren(likasChildren);


		// -> SEGMENT 3 <-
		Person arit = new Person("Arit", FamilyTreeConstants.MALE, null);
		Person jnki = new Person("Jnki", FamilyTreeConstants.FEMALE, chitra);

		arit.setSpouse(jnki);
		jnki.setSpouse(arit);

		familyMembers.put("Arit", arit);
		familyMembers.put("Jnki", jnki);


		Person ahit = new Person("Ahit", FamilyTreeConstants.MALE, chitra);
		familyMembers.put("Ahit", ahit);


		List<Person> chitrasChildren = new ArrayList<Person>();
		chitrasChildren.add(jnki);
		chitrasChildren.add(ahit);
		chitra.setChildren(chitrasChildren);


		// -> SEGMENT 4 <-
		Person satvy = new Person("Satvy", FamilyTreeConstants.FEMALE, null);
		Person asva = new Person("Asva", FamilyTreeConstants.MALE, satya);

		satvy.setSpouse(asva);
		asva.setSpouse(satvy);

		familyMembers.put("Satvy", satvy);
		familyMembers.put("Asva", asva);


		Person krpi = new Person("Krpi", FamilyTreeConstants.FEMALE, null);
		Person vyas = new Person("Vyas", FamilyTreeConstants.MALE, satya);

		krpi.setSpouse(vyas);
		vyas.setSpouse(krpi);

		familyMembers.put("Krpi", krpi);
		familyMembers.put("Vyas", vyas);


		Person atya = new Person("Atya", FamilyTreeConstants.FEMALE, satya);
		familyMembers.put("Atya", atya);


		List<Person> satyasChildren = new ArrayList<Person>();
		satyasChildren.add(asva);
		satyasChildren.add(vyas);
		satyasChildren.add(atya);
		satya.setChildren(satyasChildren);


		// ->-> LEVEL 4 <-<-

		// -> SEGMENT 1 <-
		Person yodhan = new Person("Yodhan", FamilyTreeConstants.MALE, dritha);
		familyMembers.put("Yodhan", yodhan);


		List<Person> drithasChildren = new ArrayList<Person>();
		drithasChildren.add(yodhan);
		dritha.setChildren(drithasChildren);


		// -> SEGMENT 2 <-
		Person laki = new Person("Laki", FamilyTreeConstants.MALE, jnki);
		familyMembers.put("Laki", laki);

		Person lavnya = new Person("Lavnya", FamilyTreeConstants.FEMALE, jnki);
		familyMembers.put("Lavnya", lavnya);


		List<Person> jnkisChildren = new ArrayList<Person>();
		jnkisChildren.add(laki);
		jnkisChildren.add(lavnya);
		jnki.setChildren(jnkisChildren);


		// -> SEGMENT 3 <-
		Person vasa = new Person("Vasa", FamilyTreeConstants.MALE, satvy);
		familyMembers.put("Vasa", vasa);


		List<Person> satvysChildren = new ArrayList<Person>();
		satvysChildren.add(vasa);
		satvy.setChildren(satvysChildren);


		// -> SEGMENT 4 <-
		Person kriya = new Person("Kriya", FamilyTreeConstants.MALE, krpi);
		familyMembers.put("Kriya", kriya);

		Person krithi = new Person("Krithi", FamilyTreeConstants.FEMALE, krpi);
		familyMembers.put("Krithi", krithi);


		List<Person> krpisChildren = new ArrayList<Person>();
		krpisChildren.add(kriya);
		krpisChildren.add(krithi);
		krpi.setChildren(krpisChildren);
	}

	/*
	 *  Function to add a new member to the 'familyMembers' data structure.
	 *  Details of the new family member are received as input from the end user.
	 */
	public String addChild(Map<String, Person> familyMembers, String mothersName, String childsName, String childsGender) throws FamilyTreeException {

		try {
			Person child = new Person(childsName, childsGender, familyMembers.get(mothersName));

			List<Person> mothersChildren = familyMembers.get(mothersName).getChildren();
			if(mothersChildren == null) {
				mothersChildren = new ArrayList<Person>();
			}
			mothersChildren.add(child);

			familyMembers.put(childsName, child);

			return FamilyTreeEnum.CHILD_ADDITION_SUCCEEDED.getMessage();
		}
		catch(Exception e) {
			throw new FamilyTreeException(FamilyTreeEnum.CHILD_ADDITION_FAILED);
		}
	}
}
