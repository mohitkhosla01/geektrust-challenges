package com.outputhandler;

import java.util.List;

public class OutputToConsole implements OutputHandler {

	public void output(List<String> outputLines) {
		
		for(String line : outputLines) {
			
			System.out.println(line);
		}
	}
}
