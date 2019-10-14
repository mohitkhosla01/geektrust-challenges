package com.test;

import com.dto.Person;
import com.inputtypemapper.InputOperationService;
import com.utilities.FamilyTreeEnum;

import junit.framework.TestCase;

public class FamilyTreeTest extends TestCase {

	private Person shan;
	private InputOperationService inputOperationService;
	
	public FamilyTreeTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		shan = new Person("Shan", FamilyTreeEnum.MALE.getMessage(), null);
		shan.constructInitialFamilyTree();

		inputOperationService = new InputOperationService();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void testAddChild() throws Exception {
		String inputLine = "ADD_CHILD Satya Ketu Male";
		
		String addChildExpectedResponse = "CHILD_ADDITION_SUCCEEDED";
		String addChildActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(addChildExpectedResponse, addChildActualResponse);
	}
	
	public void testGetRelationship1() throws Exception {
		String inputLine = "GET_RELATIONSHIP Kriya Paternal-Uncle";
		
		String getRelationshipExpectedResponse = "Asva";
		String getRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(getRelationshipExpectedResponse, getRelationshipActualResponse);
	}
	
	public void testGetRelationship2() throws Exception {
		String inputLine = "GET_RELATIONSHIP Satvy Brother-In-Law";
		
		String getRelationshipExpectedResponse = "Vyas";
		String getRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(getRelationshipExpectedResponse, getRelationshipActualResponse);
	}
	
	public void testGetRelationship3() throws Exception {
		String inputLine = "GET_RELATIONSHIP Satvy Sister-In-Law";
		
		String getRelationshipExpectedResponse = "Atya";
		String getRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(getRelationshipExpectedResponse, getRelationshipActualResponse);
	}
	
	public void testGetRelationship4() throws Exception {
		String inputLine = "GET_RELATIONSHIP Ish Son";
		
		String getRelationshipExpectedResponse = "NONE";
		String getRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(getRelationshipExpectedResponse, getRelationshipActualResponse);	  
	}
	
	public void testGetRelationship5() throws Exception {
		String inputLine = "GET_RELATIONSHIP Misha Daughter";
		
		String getRelationshipExpectedResponse = "PERSON_NOT_FOUND";
		String getRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(getRelationshipExpectedResponse, getRelationshipActualResponse);	  
	}
}