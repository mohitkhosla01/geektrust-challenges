package com.dto;

import java.util.ArrayList;
import java.util.List;

import com.utilities.FamilyTreeEnum;
import com.getfamilymember.GetPersonHelper;
import com.exception.FamilyTreeException;

public class Person {

	private String name;
	private String gender;

	private Person mother;
	private Person spouse;
	private List<Person> children;

	public Person(String name, String gender, Person mother) {
		if(gender.equalsIgnoreCase(FamilyTreeEnum.MALE.getMessage()) || gender.equalsIgnoreCase(FamilyTreeEnum.FEMALE.getMessage())) {
			this.name = name;	
			this.gender = gender.toLowerCase();
			this.mother = mother;
		}
	}

	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}

	public Person getMother() {
		return mother;
	}

	public Person getSpouse() {
		return spouse;
	}
	private void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public List<Person> getChildren() {
		return children;
	}
	private void setChildren(List<Person> children) {
		this.children = children;
	}


	/* 
	 * Function to add all existing family members of the Shan family to the family tree.
	 * Details of these family members are predefined.
	 */
	public void constructInitialFamilyTree() {

		// ->-> LEVEL 1 <-<-
		Person anga = new Person("Anga", FamilyTreeEnum.FEMALE.getMessage(), null);
		this.setSpouse(anga);
		anga.setSpouse(this);

		// ->-> LEVEL 2 <-<-
		Person chit = new Person("Chit", FamilyTreeEnum.MALE.getMessage(), anga);
		Person amba = new Person("Amba", FamilyTreeEnum.FEMALE.getMessage(), null);
		chit.setSpouse(amba);
		amba.setSpouse(chit);

		Person ish = new Person("Ish", FamilyTreeEnum.MALE.getMessage(), anga);

		Person vich = new Person("Vich", FamilyTreeEnum.MALE.getMessage(), anga);
		Person lika = new Person("Lika", FamilyTreeEnum.FEMALE.getMessage(), null);
		vich.setSpouse(lika);
		lika.setSpouse(vich);

		Person aras = new Person("Aras", FamilyTreeEnum.MALE.getMessage(), anga);
		Person chitra = new Person("Chitra", FamilyTreeEnum.FEMALE.getMessage(), null);
		aras.setSpouse(chitra);
		chitra.setSpouse(aras);

		Person satya = new Person("Satya", FamilyTreeEnum.FEMALE.getMessage(), anga);
		Person vyan = new Person("Vyan", FamilyTreeEnum.MALE.getMessage(), null);
		satya.setSpouse(vyan);
		vyan.setSpouse(satya);

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

		Person tritha = new Person("Tritha", FamilyTreeEnum.FEMALE.getMessage(), amba);
		Person vritha = new Person("Vritha", FamilyTreeEnum.MALE.getMessage(), amba);

		List<Person> ambasChildren = new ArrayList<Person>();
		ambasChildren.add(dritha);
		ambasChildren.add(tritha);
		ambasChildren.add(vritha);
		amba.setChildren(ambasChildren);

		// -> SEGMENT 2 <-
		Person vila = new Person("Vila", FamilyTreeEnum.FEMALE.getMessage(), lika);
		Person chika = new Person("Chika", FamilyTreeEnum.FEMALE.getMessage(), lika);

		List<Person> likasChildren = new ArrayList<Person>();
		likasChildren.add(vila);
		likasChildren.add(chika);
		lika.setChildren(likasChildren);

		// -> SEGMENT 3 <-
		Person arit = new Person("Arit", FamilyTreeEnum.MALE.getMessage(), null);
		Person jnki = new Person("Jnki", FamilyTreeEnum.FEMALE.getMessage(), chitra);
		arit.setSpouse(jnki);
		jnki.setSpouse(arit);

		Person ahit = new Person("Ahit", FamilyTreeEnum.MALE.getMessage(), chitra);

		List<Person> chitrasChildren = new ArrayList<Person>();
		chitrasChildren.add(jnki);
		chitrasChildren.add(ahit);
		chitra.setChildren(chitrasChildren);

		// -> SEGMENT 4 <-
		Person satvy = new Person("Satvy", FamilyTreeEnum.FEMALE.getMessage(), null);
		Person asva = new Person("Asva", FamilyTreeEnum.MALE.getMessage(), satya);
		satvy.setSpouse(asva);
		asva.setSpouse(satvy);

		Person krpi = new Person("Krpi", FamilyTreeEnum.FEMALE.getMessage(), null);
		Person vyas = new Person("Vyas", FamilyTreeEnum.MALE.getMessage(), satya);
		krpi.setSpouse(vyas);
		vyas.setSpouse(krpi);

		Person atya = new Person("Atya", FamilyTreeEnum.FEMALE.getMessage(), satya);

		List<Person> satyasChildren = new ArrayList<Person>();
		satyasChildren.add(asva);
		satyasChildren.add(vyas);
		satyasChildren.add(atya);
		satya.setChildren(satyasChildren);


		// ->-> LEVEL 4 <-<-

		// -> SEGMENT 1 <-
		Person yodhan = new Person("Yodhan", FamilyTreeEnum.MALE.getMessage(), dritha);

		List<Person> drithasChildren = new ArrayList<Person>();
		drithasChildren.add(yodhan);
		dritha.setChildren(drithasChildren);

		// -> SEGMENT 2 <-
		Person laki = new Person("Laki", FamilyTreeEnum.MALE.getMessage(), jnki);
		Person lavnya = new Person("Lavnya", FamilyTreeEnum.FEMALE.getMessage(), jnki);

		List<Person> jnkisChildren = new ArrayList<Person>();
		jnkisChildren.add(laki);
		jnkisChildren.add(lavnya);
		jnki.setChildren(jnkisChildren);

		// -> SEGMENT 3 <-
		Person vasa = new Person("Vasa", FamilyTreeEnum.MALE.getMessage(), satvy);

		List<Person> satvysChildren = new ArrayList<Person>();
		satvysChildren.add(vasa);
		satvy.setChildren(satvysChildren);

		// -> SEGMENT 4 <-
		Person kriya = new Person("Kriya", FamilyTreeEnum.MALE.getMessage(), krpi);
		Person krithi = new Person("Krithi", FamilyTreeEnum.FEMALE.getMessage(), krpi);

		List<Person> krpisChildren = new ArrayList<Person>();
		krpisChildren.add(kriya);
		krpisChildren.add(krithi);
		krpi.setChildren(krpisChildren);
	}


	/*
	 *  Function to add a new member to the family tree.
	 *  Details of the new family member are received as input from the end user.
	 */
	public boolean addFamilyMember(String mothersName, String childsName, String childsGender) throws FamilyTreeException {

		try {
			Person mother = GetPersonHelper.getPerson(this, mothersName);
			if(mother == null) {
				return false;
			}
			
			Person child = new Person(childsName, childsGender, mother);

			List<Person> children = mother.getChildren();
			if(children == null) {
				children = new ArrayList<Person>();
			}
			children.add(child);
			
			return true;
		}
		catch(Exception e) {
			throw new FamilyTreeException(FamilyTreeEnum.CHILD_ADDITION_FAILED);
		}
	}
	
	/*
	 *  Function to obtain a family member & his/her details from the family tree.
	 *  Name of the family member is received as input from the end user.
	 */
	public Person getFamilyMember(String personName) throws FamilyTreeException {

		try {
			return GetPersonHelper.getPerson(this, personName);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new FamilyTreeException(FamilyTreeEnum.PERSON_NOT_FOUND);
		}
	}
}
