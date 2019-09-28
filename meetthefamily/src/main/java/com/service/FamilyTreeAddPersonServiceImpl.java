package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dto.Person;
import com.exception.FamilyTreeException;
import com.utilities.FamilyTreeEnum;

public class FamilyTreeAddPersonServiceImpl implements FamilyTreeAddPersonService {

	/* 
	 * Function to add all family members of the Shan family to the 'familyMembers' data structure.
	 * Details of these family members are predefined.
	 */
	public void constructInitialFamilyTree(Map<String, Person> familyMembers) {

		// ->-> LEVEL 1 <-<-
		Person shan = new Person("Shan", FamilyTreeEnum.MALE.getMessage(), null);
		Person anga = new Person("Anga", FamilyTreeEnum.FEMALE.getMessage(), null);

		shan.setSpouse(anga);
		anga.setSpouse(shan);

		familyMembers.put("Shan", shan);
		familyMembers.put("Anga", anga);


		// ->-> LEVEL 2 <-<-
		Person chit = new Person("Chit", FamilyTreeEnum.MALE.getMessage(), anga);
		Person amba = new Person("Amba", FamilyTreeEnum.FEMALE.getMessage(), null);

		chit.setSpouse(amba);
		amba.setSpouse(chit);

		familyMembers.put("Chit", chit);
		familyMembers.put("Amba", amba);


		Person ish = new Person("Ish", FamilyTreeEnum.MALE.getMessage(), anga);
		familyMembers.put("Ish", ish);


		Person vich = new Person("Vich", FamilyTreeEnum.MALE.getMessage(), anga);
		Person lika = new Person("Lika", FamilyTreeEnum.FEMALE.getMessage(), null);

		vich.setSpouse(lika);
		lika.setSpouse(vich);

		familyMembers.put("Vich", vich);
		familyMembers.put("Lika", lika);


		Person aras = new Person("Aras", FamilyTreeEnum.MALE.getMessage(), anga);
		Person chitra = new Person("Chitra", FamilyTreeEnum.FEMALE.getMessage(), null);

		aras.setSpouse(chitra);
		chitra.setSpouse(aras);

		familyMembers.put("Aras", aras);
		familyMembers.put("Chitra", chitra);


		Person satya = new Person("Satya", FamilyTreeEnum.FEMALE.getMessage(), anga);
		Person vyan = new Person("Vyan", FamilyTreeEnum.MALE.getMessage(), null);

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
		Person dritha = new Person("Dritha", FamilyTreeEnum.FEMALE.getMessage(), amba);
		Person jaya = new Person("Jaya", FamilyTreeEnum.MALE.getMessage(), null);

		dritha.setSpouse(jaya);
		jaya.setSpouse(dritha);

		familyMembers.put("Dritha", dritha);
		familyMembers.put("Jaya", jaya);


		Person tritha = new Person("Tritha", FamilyTreeEnum.FEMALE.getMessage(), amba);
		familyMembers.put("Tritha", tritha);

		Person vritha = new Person("Vritha", FamilyTreeEnum.MALE.getMessage(), amba);
		familyMembers.put("Vritha", vritha);


		List<Person> ambasChildren = new ArrayList<Person>();
		ambasChildren.add(chit);
		ambasChildren.add(ish);
		ambasChildren.add(vich);
		amba.setChildren(ambasChildren);


		// -> SEGMENT 2 <-
		Person vila = new Person("Vila", FamilyTreeEnum.FEMALE.getMessage(), lika);
		familyMembers.put("Vila", vila);

		Person chika = new Person("Chika", FamilyTreeEnum.FEMALE.getMessage(), lika);
		familyMembers.put("Chika", chika);


		List<Person> likasChildren = new ArrayList<Person>();
		likasChildren.add(vila);
		likasChildren.add(chika);
		lika.setChildren(likasChildren);


		// -> SEGMENT 3 <-
		Person arit = new Person("Arit", FamilyTreeEnum.MALE.getMessage(), null);
		Person jnki = new Person("Jnki", FamilyTreeEnum.FEMALE.getMessage(), chitra);

		arit.setSpouse(jnki);
		jnki.setSpouse(arit);

		familyMembers.put("Arit", arit);
		familyMembers.put("Jnki", jnki);


		Person ahit = new Person("Ahit", FamilyTreeEnum.MALE.getMessage(), chitra);
		familyMembers.put("Ahit", ahit);


		List<Person> chitrasChildren = new ArrayList<Person>();
		chitrasChildren.add(jnki);
		chitrasChildren.add(ahit);
		chitra.setChildren(chitrasChildren);


		// -> SEGMENT 4 <-
		Person satvy = new Person("Satvy", FamilyTreeEnum.FEMALE.getMessage(), null);
		Person asva = new Person("Asva", FamilyTreeEnum.MALE.getMessage(), satya);

		satvy.setSpouse(asva);
		asva.setSpouse(satvy);

		familyMembers.put("Satvy", satvy);
		familyMembers.put("Asva", asva);


		Person krpi = new Person("Krpi", FamilyTreeEnum.FEMALE.getMessage(), null);
		Person vyas = new Person("Vyas", FamilyTreeEnum.MALE.getMessage(), satya);

		krpi.setSpouse(vyas);
		vyas.setSpouse(krpi);

		familyMembers.put("Krpi", krpi);
		familyMembers.put("Vyas", vyas);


		Person atya = new Person("Atya", FamilyTreeEnum.FEMALE.getMessage(), satya);
		familyMembers.put("Atya", atya);


		List<Person> satyasChildren = new ArrayList<Person>();
		satyasChildren.add(asva);
		satyasChildren.add(vyas);
		satyasChildren.add(atya);
		satya.setChildren(satyasChildren);


		// ->-> LEVEL 4 <-<-

		// -> SEGMENT 1 <-
		Person yodhan = new Person("Yodhan", FamilyTreeEnum.MALE.getMessage(), dritha);
		familyMembers.put("Yodhan", yodhan);


		List<Person> drithasChildren = new ArrayList<Person>();
		drithasChildren.add(yodhan);
		dritha.setChildren(drithasChildren);


		// -> SEGMENT 2 <-
		Person laki = new Person("Laki", FamilyTreeEnum.MALE.getMessage(), jnki);
		familyMembers.put("Laki", laki);

		Person lavnya = new Person("Lavnya", FamilyTreeEnum.FEMALE.getMessage(), jnki);
		familyMembers.put("Lavnya", lavnya);


		List<Person> jnkisChildren = new ArrayList<Person>();
		jnkisChildren.add(laki);
		jnkisChildren.add(lavnya);
		jnki.setChildren(jnkisChildren);


		// -> SEGMENT 3 <-
		Person vasa = new Person("Vasa", FamilyTreeEnum.MALE.getMessage(), satvy);
		familyMembers.put("Vasa", vasa);


		List<Person> satvysChildren = new ArrayList<Person>();
		satvysChildren.add(vasa);
		satvy.setChildren(satvysChildren);


		// -> SEGMENT 4 <-
		Person kriya = new Person("Kriya", FamilyTreeEnum.MALE.getMessage(), krpi);
		familyMembers.put("Kriya", kriya);

		Person krithi = new Person("Krithi", FamilyTreeEnum.FEMALE.getMessage(), krpi);
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
			String validationResult = new FamilyTreeValidateAddPersonServiceImpl().validateAddChild(familyMembers, mothersName, childsName, childsGender);
			
			if(validationResult.equals(FamilyTreeEnum.ADD_PERSON_POSSIBLE.getMessage())) {
				Person child = new Person(childsName, childsGender, familyMembers.get(mothersName));

				List<Person> mothersChildren = familyMembers.get(mothersName).getChildren();
				if(mothersChildren == null) {
					mothersChildren = new ArrayList<Person>();
				}
				mothersChildren.add(child);

				familyMembers.put(childsName, child);

				return FamilyTreeEnum.CHILD_ADDITION_SUCCEEDED.getMessage();
			}
			else {
				return validationResult;
			}
		}
		catch(Exception e) {
			throw new FamilyTreeException(FamilyTreeEnum.CHILD_ADDITION_FAILED);
		}
	}
}
