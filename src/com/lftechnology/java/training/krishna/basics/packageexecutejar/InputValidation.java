
package com.lftechnology.java.training.krishna.basics.packageexecutejar;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program is used for validation.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class InputValidation {

	private static final Logger LOGGER =
		Logger.getLogger(InputValidation.class.getName());

	public static final int MIN_NUM = 0;

	// constructor
	private InputValidation() {

	}

	/**
	 * Function is used to validate the user input using scanner
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @return number {@link int} input value
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static int inputNumberValidation(Scanner scanner) {

		int number;
		do {
			while (!scanner.hasNextInt()) {
				LOGGER.log(Level.INFO, "Please enter valid positive number");
				scanner.next();
			}
			number = scanner.nextInt();
		}
		while (!isValidInputNumber(number));
		return number;
	}

	/**
	 * Function is used to check if number is valid and within range
	 *
	 * @param number
	 *            {@link int} number
	 * @return {@link boolean}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static boolean isValidInputNumber(int number) {

		if (number <= MIN_NUM) {
			LOGGER.log(Level.INFO, "Please enter number 0 or greater than 0 : ");
			return false;
		}
		else {
			return true;
		}
	}

}
