package com.utilities;

public enum FamilyTreeEnum {
	
	ADD_CHILD("ADD_CHILD"),
	GET_RELATIONSHIP("GET_RELATIONSHIP"),
	NONE("NONE"),
	PERSON_NOT_FOUND("PERSON_NOT_FOUND"),
	INVALID_INPUT("INVALID_INPUT"),
	ADD_PERSON_POSSIBLE("ADD_PERSON_POSSIBLE"),
	GET_PERSON_POSSIBLE("GET_PERSON_POSSIBLE"),
	CHILD_ADDITION_FAILED("CHILD_ADDITION_FAILED"),
	CHILD_ADDITION_SUCCEEDED("CHILD_ADDITION_SUCCEEDED");
	
	private String message;
	
	private FamilyTreeEnum(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
