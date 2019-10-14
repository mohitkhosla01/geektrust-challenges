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
	
	
	// ** Add child test operations **
	public void testAddChildKetu() throws Exception {
		String inputLine = "ADD_CHILD Satya Ketu Male";
		
		String testAddChildExpectedResponse = "CHILD_ADDITION_SUCCEEDED";
		String testAddChildActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testAddChildExpectedResponse, testAddChildActualResponse);
	}
	
	public void testAddChildSila() throws Exception {
		String inputLine = "ADD_CHILD Lika Sila Female";
		
		String testAddChildExpectedResponse = "CHILD_ADDITION_SUCCEEDED";
		String testAddChildActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testAddChildExpectedResponse, testAddChildActualResponse);
	}
	
	public void testAddChildGritha() throws Exception {
		String inputLine = "ADD_CHILD Amba Gritha Male";
		
		String testAddChildExpectedResponse = "CHILD_ADDITION_SUCCEEDED";
		String testAddChildActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testAddChildExpectedResponse, testAddChildActualResponse);
	}
	
	public void testAddChildSaavna() throws Exception {
		String inputLine = "ADD_CHILD Champa Saavna Female";
		
		String testAddChildExpectedResponse = "CHILD_ADDITION_FAILED";
		String testAddChildActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testAddChildExpectedResponse, testAddChildActualResponse);
	}
	// ** Add child test operations **
	
	
	// ** Get relationship test operations **
	public void testGetRelationshipKriyaPaternalUncle() throws Exception {
		String inputLine = "GET_RELATIONSHIP Kriya Paternal-Uncle";
		
		String testGetRelationshipExpectedResponse = "Asva";
		String testGetRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testGetRelationshipExpectedResponse, testGetRelationshipActualResponse);
	}
	
	public void testGetRelationshipSatyaBrotherInLaw() throws Exception {
		String inputLine = "GET_RELATIONSHIP Satvy Brother-In-Law";
		
		String testGetRelationshipExpectedResponse = "Vyas";
		String testGetRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testGetRelationshipExpectedResponse, testGetRelationshipActualResponse);
	}
	
	public void testGetRelationshipSatvySisterInLaw() throws Exception {
		String inputLine = "GET_RELATIONSHIP Satvy Sister-In-Law";
		
		String testGetRelationshipExpectedResponse = "Atya";
		String testGetRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testGetRelationshipExpectedResponse, testGetRelationshipActualResponse);
	}
	
	public void testGetRelationshipIshSon() throws Exception {
		String inputLine = "GET_RELATIONSHIP Ish Son";
		
		String testGetRelationshipExpectedResponse = "NONE";
		String testGetRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testGetRelationshipExpectedResponse, testGetRelationshipActualResponse);	  
	}
	
	public void testGetRelationshipMishaDaughter() throws Exception {
		String inputLine = "GET_RELATIONSHIP Misha Daughter";
		
		String testGetRelationshipExpectedResponse = "PERSON_NOT_FOUND";
		String testGetRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testGetRelationshipExpectedResponse, testGetRelationshipActualResponse);	  
	}
	
	public void testGetRelationshipLikaDaughter() throws Exception {
		String inputLine = "GET_RELATIONSHIP Lika Daughter";
		
		String testGetRelationshipExpectedResponse = "Vila Chika";
		String testGetRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testGetRelationshipExpectedResponse, testGetRelationshipActualResponse);	  
	}
	
	public void testGetRelationshipAmbaSon() throws Exception {
		String inputLine = "GET_RELATIONSHIP Amba Son";
		
		String testGetRelationshipExpectedResponse = "Vritha";
		String testGetRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testGetRelationshipExpectedResponse, testGetRelationshipActualResponse);	  
	}
	
	public void testGetRelationshipJnkiSon() throws Exception {
		String inputLine = "GET_RELATIONSHIP Jnki Son";
		
		String testGetRelationshipExpectedResponse = "Laki";
		String testGetRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testGetRelationshipExpectedResponse, testGetRelationshipActualResponse);	  
	}
	
	public void testGetRelationshipJnkiDaughter() throws Exception {
		String inputLine = "GET_RELATIONSHIP Jnki Daughter";
		
		String testGetRelationshipExpectedResponse = "Lavnya";
		String testGetRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testGetRelationshipExpectedResponse, testGetRelationshipActualResponse);	  
	}
	
	public void testGetRelationshipLavnyaMaternalAunt() throws Exception {
		String inputLine = "GET_RELATIONSHIP Lavnya Maternal-Aunt";
		
		String testGetRelationshipExpectedResponse = "NONE";
		String testGetRelationshipActualResponse = inputOperationService.mapInputOperation(shan, inputLine);
		
		assertEquals(testGetRelationshipExpectedResponse, testGetRelationshipActualResponse);	  
	}
	// ** Get relationship test operations **
}