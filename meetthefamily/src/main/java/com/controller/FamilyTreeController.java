package com.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.dto.Person;
import com.exception.FamilyTreeException;
import com.service.InputTypeMapper;
import com.utilities.FamilyTreeEnum;

public class FamilyTreeController {

	public static void main(String[] args) {

		// Creating Person object for 'Shan'
		Person shan = new Person("Shan", FamilyTreeEnum.MALE.getMessage(), null);
		shan.constructInitialFamilyTree();

		
		System.out.println("-> -> ->  Welcome to 'Meet the Family' Geektrust backend challenge  <- <- <-");
		System.out.print("Enter the input file path: ");
		Scanner sc = new Scanner(System.in);
		String fileSource = sc.nextLine();

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileSource));

			String line;
			while ((line = br.readLine()) != null) {

				String[] inputParameters = line.split(" ");

				System.out.println(new InputTypeMapper().mapInputType(shan, inputParameters[0], inputParameters));
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

		sc.close();
	}
}
