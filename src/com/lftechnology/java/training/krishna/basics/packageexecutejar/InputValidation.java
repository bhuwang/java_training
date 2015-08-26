
package com.lftechnology.java.training.krishna.basics.packageexecutejar;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ScannerValidation.java This program is used for validation.
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
	 * @return number {@link Integer} input value
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static int numberValidation(Scanner scanner) {

		int number;
		do {
			while (!scanner.hasNextInt()) {
				LOGGER.log(Level.INFO, "Please enter valid positive number");
				scanner.next();
			}
			number = scanner.nextInt();
		}
		while (number < MIN_NUM);
		return number;
	}

}
