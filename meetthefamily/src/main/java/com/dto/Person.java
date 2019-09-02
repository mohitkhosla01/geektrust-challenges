package com.dto;

import java.util.List;

public class Person {
	
	private String name;
	private String gender;
	private Person spouse;
	private Person mother;
	private List<Person> children;
	
	public Person(String name, String gender) {
		if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
			this.name = name;
			this.gender = gender;
		}
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public Person getSpouse() {
		return spouse;
	}
	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public Person getMother() {
		return mother;
	}
	public void setMother(Person mother) {
		this.mother = mother;
	}

	public List<Person> getChildren() {
		return children;
	}
	public void setChildren(List<Person> children) {
		this.children = children;
	}
}
