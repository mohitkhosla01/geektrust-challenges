package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dto.Person;
import com.exception.FamilyTreeException;
import com.inputhandler.InputFromFile;
import com.inputhandler.InputType;
import com.inputtypemapper.InputOperationService;
import com.outputhandler.OutputHandler;
import com.outputhandler.OutputToConsole;
import com.utilities.FamilyTreeEnum;

public class FamilyTreeController {

	public static void main(String[] args) {

		try {
			// Creating Person object for 'Shan'
			Person shan = new Person("Shan", FamilyTreeEnum.MALE.getMessage(), null);
			shan.constructInitialFamilyTree();
			
			System.out.println("-> -> ->  Welcome to 'Meet the Family' Geektrust backend challenge  <- <- <-");
			
			InputType input = new InputFromFile();
			List<String> inputLines = input.input();
			
			OutputHandler outputHandler = new OutputToConsole();
			List<String> outputLines = new ArrayList<String>();
			
			for(String line : inputLines) {
				String[] inputParameters = line.split(" ");
				outputLines.add(new InputOperationService().mapInputOperation(shan, inputParameters));
			}
			
			outputHandler.output(outputLines);
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
