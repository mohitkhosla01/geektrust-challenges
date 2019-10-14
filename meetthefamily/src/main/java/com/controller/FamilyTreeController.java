package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dto.Person;
import com.exception.FamilyTreeException;
import com.inputhandler.InputType;
import com.inputhandler.InputTypeFactory;
import com.inputtypemapper.InputOperationService;
import com.outputhandler.OutputType;
import com.outputhandler.OutputTypeFactory;
import com.utilities.FamilyTreeEnum;

public class FamilyTreeController {

	public static void main(String[] args) {

		try {
			// Creating Person object for 'Shan'
			Person shan = new Person("Shan", FamilyTreeEnum.MALE.getMessage(), null);
			shan.constructInitialFamilyTree();
			
			System.out.println("-> -> ->  Welcome to 'Meet the Family' Geektrust backend challenge  <- <- <-");
			
			InputType inputType = InputTypeFactory.getInputType("FILE");
			List<String> inputLines = inputType.input();
			
			OutputType outputType = OutputTypeFactory.getOutputType("CONSOLE");
			List<String> outputLines = new ArrayList<String>();
			
			for(String inputLine : inputLines) {
				outputLines.add(new InputOperationService().mapInputOperation(shan, inputLine));
			}
			
			outputType.output(outputLines);
		}
		catch(FamilyTreeException fte) {
			System.out.println(fte.getFamilyTreeEnum().getMessage());
		}
		catch(NullPointerException npe) {
			System.out.println("NullPointerException occured!");
			npe.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Exception occured!");
			e.printStackTrace();
		}
	}
}
