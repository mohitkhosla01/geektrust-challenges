package com.getfamilymember;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import com.dto.Person;
import com.utilities.FamilyTreeEnum;

public class GetPersonHelper {
	
	public static Person getPerson(Person shan, String personName) {
		
		Queue<Person> people = new LinkedList<Person>();
		people.add(shan);
		
		return helper(people, personName);
	}
	
	private static Person helper(Queue<Person> people, String personName) {
		
		Person person = people.poll();
		if(person != null) {
			
			if(person.getName().equals(personName)) {
				return person;
			}
			else if(person.getSpouse() != null && person.getSpouse().getName().equals(personName)) {
				return person.getSpouse();
			}
			else {
				List<Person> children = person.getGender().equals(FamilyTreeEnum.FEMALE.getMessage()) ? 
						person.getChildren() : person.getSpouse() != null ? person.getSpouse().getChildren() : null;
						
				if(children != null) {
					for(Person child : children) {
						people.add(child);
					}
				}
				
				return helper(people, personName);
			}
		}
		
		return null;
	}
}
