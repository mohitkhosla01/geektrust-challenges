package com.outputhandler;

import java.util.List;

public class OutputToConsole extends OutputType {

	public void output(List<String> outputLines) {
		
		for(String line : outputLines) {
			
			System.out.println(line);
		}
	}
}
