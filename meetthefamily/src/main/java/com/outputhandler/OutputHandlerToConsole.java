package com.outputhandler;

import java.util.List;

public class OutputHandlerToConsole implements OutputHandler {

	public void output(List<String> outputLines) {
		
		for(String line : outputLines) {
			
			System.out.println(line);
		}
	}
}
