package com.familytreetest;

import java.util.HashMap;
import java.util.Map;

import com.controller.FamilyTreeController;
import com.dto.Person;
import com.exception.FamilyTreeException;
import com.service.FamilyTreeAddPersonService;
import com.service.FamilyTreeAddPersonServiceImpl;
import com.service.FamilyTreeGetPersonService;
import com.service.FamilyTreeGetPersonServiceImpl;
import com.service.FamilyTreeValidateAddPersonService;
import com.service.FamilyTreeValidateAddPersonServiceImpl;
import com.service.FamilyTreeValidateGetPersonService;
import com.service.FamilyTreeValidateGetPersonServiceImpl;

import junit.framework.TestCase;

public class FamilyTreeTest extends TestCase
{
	private Map<String, Person> familyMembers;
	private FamilyTreeController controllerObject;
	private FamilyTreeValidateAddPersonService validateAddPersonServiceObject;
	private FamilyTreeValidateGetPersonService validateGetPersonServiceObject;
	private FamilyTreeAddPersonService addPersonServiceObject;
	private FamilyTreeGetPersonService getPersonServiceObject;
	
	public FamilyTreeTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		familyMembers = new HashMap<String, Person>();
		
		controllerObject = new FamilyTreeController();

		validateAddPersonServiceObject = new FamilyTreeValidateAddPersonServiceImpl();
		validateGetPersonServiceObject = new FamilyTreeValidateGetPersonServiceImpl();

		addPersonServiceObject = new FamilyTreeAddPersonServiceImpl();		
		addPersonServiceObject.constructInitialFamilyTree(familyMembers);

		getPersonServiceObject = new FamilyTreeGetPersonServiceImpl();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void testAddChild() throws FamilyTreeException {
		String[] addChildInput = {"ADD_CHILD", "Satya", "Ketu", "Male"};
		
		String addChildExpectedResponse = "CHILD_ADDITION_SUCCEEDED";
		String addChildActualResponse = controllerObject.callAddChild(validateAddPersonServiceObject, addPersonServiceObject, addChildInput, familyMembers);
		
		assertEquals(addChildExpectedResponse, addChildActualResponse);
	}
	
	public void testGetRelationship1() throws FamilyTreeException {
		String[] getRelationshipInput = {"GET_RELATIONSHIP", "Kriya", "Paternal-Uncle"};
		
		String getRelationshipExpectedResponse = "Asva";
		String getRelationshipActualResponse = controllerObject.callGetRelatives(validateGetPersonServiceObject, getPersonServiceObject, getRelationshipInput, familyMembers);
		
		assertEquals(getRelationshipExpectedResponse, getRelationshipActualResponse);
	}
	
	public void testGetRelationship2() throws FamilyTreeException {
		String[] getRelationshipInput = {"GET_RELATIONSHIP", "Satvy", "Brother-In-Law"};
		
		String getRelationshipExpectedResponse = "Vyas";
		String getRelationshipActualResponse = controllerObject.callGetRelatives(validateGetPersonServiceObject, getPersonServiceObject, getRelationshipInput, familyMembers);
		
		assertEquals(getRelationshipExpectedResponse, getRelationshipActualResponse);	  
	}
	
	public void testGetRelationship3() throws FamilyTreeException {
		String[] getRelationshipInput = {"GET_RELATIONSHIP", "Satvy", "Sister-In-Law"};
		
		String getRelationshipExpectedResponse = "Atya";
		String getRelationshipActualResponse = controllerObject.callGetRelatives(validateGetPersonServiceObject, getPersonServiceObject, getRelationshipInput, familyMembers);
		
		assertEquals(getRelationshipExpectedResponse, getRelationshipActualResponse);
	}
	
	public void testGetRelationship4() throws FamilyTreeException {
		String[] getRelationshipInput = {"GET_RELATIONSHIP", "Ish", "Son"};
		
		String getRelationshipExpectedResponse = "NONE";
		String getRelationshipActualResponse = controllerObject.callGetRelatives(validateGetPersonServiceObject, getPersonServiceObject, getRelationshipInput, familyMembers);
		
		assertEquals(getRelationshipExpectedResponse, getRelationshipActualResponse);	  
	}
	
	public void testGetRelationship5() throws FamilyTreeException {
		String[] getRelationshipInput = {"GET_RELATIONSHIP", "Misha", "Daughter"};
		
		String getRelationshipExpectedResponse = "PERSON_NOT_FOUND";
		String getRelationshipActualResponse = controllerObject.callGetRelatives(validateGetPersonServiceObject, getPersonServiceObject, getRelationshipInput, familyMembers);
		
		assertEquals(getRelationshipExpectedResponse, getRelationshipActualResponse);	  
	}
}