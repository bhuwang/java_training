package com.lftechnology.java.training.srijan.basics.percentage;

import java.util.Scanner;
import java.util.logging.Logger;

public class CalculatorTest {
	private static final Logger LOGGER = Logger.getLogger(CalculatorTest.class.getName());
	
	private CalculatorTest(){
		
	}
	
	public static void main(String[] args) {

		Calculator student1 = new Calculator(0, 0, 0, 0, 0);
		Scanner input = new Scanner(System.in);
		float[] inputNumbers = new float[5];
		float enteredNumber = 0;
		String studentName = "";

		for (int j = 1; j <= 5; j++) {
			LOGGER.info("Name of Student:");
			studentName = input.next();
			for (int i = 1; i <= 5; i++) {
				LOGGER.info("Enter the marks of subject" + i);
				enteredNumber = input.nextFloat();
				inputNumbers[i - 1] = enteredNumber;
			}
			student1.showMarksEntered(studentName, inputNumbers);
		}

		student1.highestGPA();
		input.close();

	}

}
