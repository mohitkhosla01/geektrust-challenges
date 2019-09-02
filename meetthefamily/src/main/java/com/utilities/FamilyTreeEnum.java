package com.utilities;

import java.util.ArrayList;
import java.util.List;

public enum FamilyTreeEnum {
	
	ADD_CHILD("ADD_CHILD"),
	GET_RELATIONSHIP("GET_RELATIONSHIP"),
	NONE("NONE"),
	CHILD_ADDITION_FAILED("CHILD_ADDITION_FAILED"),
	PERSON_NOT_FOUND("PERSON_NOT_FOUND"),
	INVALID_INPUT("INVALID_INPUT"),
	CHILD_ADDITION_SUCCEEDED("CHILD_ADDITION_SUCCEEDED");
	
	private String errorMessage;
	
	private FamilyTreeEnum(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getMessageAsString() {
		return errorMessage;
	}
	
	public List<String> getMessageAsList() {
		List<String> messageList = new ArrayList<String>();
		messageList.add(errorMessage);
		return messageList;
	}
}
