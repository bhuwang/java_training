
package com.lftechnology.java.training.krishna.basics.packageexecutejar;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * a. Create a Java application AddNumber, which takes two number from User and prints sum. 
 * b. Create Executable Jar 
 * c. Run java application from command line which should take values from user.
 * d. Print sum 
 * e. Create JavaDoc of Application
 */

/**
 * This program used to sum two integer numbers
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
+*/
public class PackageDemo {

	private static final Logger LOGGER =
		Logger.getLogger(PackageDemo.class.getName());

	//constructor
	private PackageDemo() {

	}

	public static void main(String[] args) {

		try {
			Scanner scanner = new Scanner(System.in);
			LOGGER.log(Level.INFO, "Please enter the first number: ");
			int firstNumber = InputValidation.inputNumberValidation(scanner);
			LOGGER.log(Level.INFO, "Please enter the second number: ");
			int secondNumber = InputValidation.inputNumberValidation(scanner);
			AddNumber addNumber = new AddNumber(firstNumber, secondNumber);
			int sum = addNumber.sum();
			LOGGER.log(Level.INFO, "Sum: {0}", sum);
			scanner.close();
		}
		catch (NumberFormatException e) {
			LOGGER.log(
				Level.WARNING, "NumberFormatException Message : {0}",
				e.getMessage());
		}

	}

}