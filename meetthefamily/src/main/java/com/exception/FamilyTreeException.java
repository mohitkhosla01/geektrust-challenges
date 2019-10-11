package com.exception;

import com.utilities.FamilyTreeEnum;

/** 
 * Exception class to hold the error message.
 * This exception is intended to be thrown from the calling classes or methods within the FamilyTree project and printing the appropriate error message on the console.
 * 
 * @author Mohit Khosla
 */

public class FamilyTreeException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private FamilyTreeEnum familyTreeEnum;
	
	public FamilyTreeException(FamilyTreeEnum familyTreeEnum) {
		this.familyTreeEnum = familyTreeEnum;
	}
	
	public FamilyTreeEnum getFamilyTreeEnum() {
		return familyTreeEnum;
	}
}
