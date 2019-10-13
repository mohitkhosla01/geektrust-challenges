package com.inputhandler;

public class InputTypeFactory {

	public static InputType getInputType(String inputTypeName) {

		switch (inputTypeName) {
			case "CONSOLE" 	: 	return new InputFromConsole();
			case "FILE" 	: 	return new InputFromFile();
			default 		: 	return null;
		}
	}
}
