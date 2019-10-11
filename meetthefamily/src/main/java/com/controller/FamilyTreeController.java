package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dto.Person;
import com.exception.FamilyTreeException;
import com.inputhandler.InputHandler;
import com.inputhandler.InputHandlerFromFile;
import com.inputtypemapper.InputTypeMapperService;
import com.outputhandler.OutputHandler;
import com.outputhandler.OutputHandlerToConsole;
import com.utilities.FamilyTreeEnum;

public class FamilyTreeController {

	public static void main(String[] args) {

		try {
			// Creating Person object for 'Shan'
			Person shan = new Person("Shan", FamilyTreeEnum.MALE.getMessage(), null);
			shan.constructInitialFamilyTree();
			
			System.out.println("-> -> ->  Welcome to 'Meet the Family' Geektrust backend challenge  <- <- <-");
			
			InputHandler inputHandler = new InputHandlerFromFile();
			List<String> inputLines = inputHandler.input();
			
			OutputHandler outputHandler = new OutputHandlerToConsole();
			List<String> outputLines = new ArrayList<String>();
			
			for(String line : inputLines) {
				String[] inputParameters = line.split(" ");
				outputLines.add(new InputTypeMapperService().mapInputType(shan, inputParameters));
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
