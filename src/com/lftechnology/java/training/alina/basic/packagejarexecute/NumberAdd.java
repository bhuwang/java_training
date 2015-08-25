
package com.lftechnology.java.training.alina.basic.packagejarexecute;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>NumberAdd Class is used to display the sum of two numbers</p>
 * 
 * <p>Steps : </p>
 * <ol type="a">
 * <li>Create a Java application AddNumber, which takes two number from User and prints sum.</li>
 * <li>Create Executable Jar</li>
 * <li>Run java application from command line which should take values from user.</li>
 * <li>Print sum</li>
 * <li>Create JavaDoc of Application</li>
 * </ol>
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class NumberAdd {

	private static final Logger LOGGER =
		Logger.getLogger(NumberAdd.class.getName());

	/**
	 * Main method used to calculate and display the sum of two numbers
	 * 
	 * @param args
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public static void main(String[] args) {

		NumberValidation numValidation = new NumberValidation();
		try (Scanner input = new Scanner(System.in)) {
			float firstNumber =
				numValidation.numberValidation(input, "Enter first number : ");
			float secondNumber =
				numValidation.numberValidation(input, "Enter second number : ");
			float sumOfTwoNumbers =
				calculateSumOfNumbers(firstNumber, secondNumber);
			LOGGER.log(
				Level.INFO, "Sum of two numbers is : {0}", sumOfTwoNumbers);
		}
		catch (Exception e) {
			LOGGER.log(Level.WARNING, "Number Invalid Exception.");
		}
	}

	/**
	 * Function used to calculate sum of two numbers
	 * 
	 * @param firstNumber
	 *            {@link Float}
	 * @param secondNumber
	 *            {@link Float}
	 * @return totalSum {@link Float} Sum of two numbers
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static float calculateSumOfNumbers(
		float firstNumber, float secondNumber) {

		float totalSum;
		totalSum = firstNumber + secondNumber;
		return totalSum;
	}
}
