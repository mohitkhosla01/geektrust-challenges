package com.getfamilymember;

import java.util.List;

import com.dto.Person;

public abstract class RelationshipMapper {
	
	/*
	 *  Function to map different relationships to their corresponding functions.
	 *  Relationship type is received as input from the end user.
	 */
	public List<String> mapRelationships(Person person, String personName, String relationship) throws Exception {

		switch(relationship) {
			case "Paternal-Uncle" : return getPaternalUncle(person, personName, relationship);
			case "Maternal-Uncle" : return getMaternalUncle(person, personName, relationship);
			case "Paternal-Aunt" : 	return getPaternalAunt(person, personName, relationship);
			case "Maternal-Aunt" : 	return getMaternalAunt(person, personName, relationship);
			case "Sister-In-Law" : 	return getSistersInLaw(person, personName, relationship);
			case "Brother-In-Law" : return getBrothersInLaw(person, personName, relationship);
			case "Son" : 			return getSons(person, personName, relationship);
			case "Daughter" : 		return getDaughters(person, personName, relationship);
			case "Siblings" : 		return getSiblings(person, personName, relationship);
			default : 				return null;
		}
	}
	
	// Abstract function to get paternal uncles of a person.
	public abstract List<String> getPaternalUncle(Person person, String personName, String relationship) throws Exception;

	// Abstract function to get maternal uncles of a person.
	public abstract List<String> getMaternalUncle(Person person, String personName, String relationship) throws Exception;

	// Abstract function to get paternal aunts of a person.
	public abstract List<String> getPaternalAunt(Person person, String personName, String relationship) throws Exception;

	// Abstract function to get maternal aunts of a person.
	public abstract List<String> getMaternalAunt(Person person, String personName, String relationship) throws Exception;

	// Abstract function to get sisters-in-law of a person.
	public abstract List<String> getSistersInLaw(Person person, String personName, String relationship) throws Exception;

	// Abstract function to get brothers-in-law of a person.
	public abstract List<String> getBrothersInLaw(Person person, String personName, String relationship) throws Exception;

	// Abstract function to get sons of a person.
	public abstract List<String> getSons(Person person, String personName, String relationship) throws Exception;

	// Abstract function to get daughters of a person.
	public abstract List<String> getDaughters(Person person, String personName, String relationship) throws Exception;

	// Abstract function to get siblings of a person.
	public abstract List<String> getSiblings(Person person, String personName, String relationship) throws Exception;
}
