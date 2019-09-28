package com.dto;

import java.util.List;

import com.utilities.FamilyTreeEnum;

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
	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public List<Person> getChildren() {
		return children;
	}
	public void setChildren(List<Person> children) {
		this.children = children;
	}
}
