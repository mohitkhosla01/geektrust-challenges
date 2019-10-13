package com.inputhandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFromConsole extends InputType {

	public List<String> input() {
		
		List<String> inputLines = new ArrayList<String>();
		
		System.out.print("Enter the input file path: ");
		Scanner sc = new Scanner(System.in);
		String fileSource = sc.nextLine();

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileSource));
			String line;
			
			while ((line = br.readLine()) != null) {
				inputLines.add(line);
			}

			br.close();
		} 
		catch(FileNotFoundException fne) {
			System.out.println("No file found at location: " + fileSource);
		}
		catch(IOException ioe) {
			System.out.println("IOException occured!");
			ioe.printStackTrace();
		}
		finally {
			sc.close();
		}
		
		return inputLines;
	}
}
