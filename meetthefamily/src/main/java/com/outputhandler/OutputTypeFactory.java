package com.outputhandler;

public class OutputTypeFactory {

	public static OutputType getOutputType(String outputTypeName) {

		switch (outputTypeName) {
			case "CONSOLE" 	: 	return new OutputToConsole();
			default 		: 	return null;
		}
	}
}
