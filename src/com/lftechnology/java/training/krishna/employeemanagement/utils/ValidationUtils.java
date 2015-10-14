
package com.lftechnology.java.training.krishna.employeemanagement.utils;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program is used for validation.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class ValidationUtils {

	private static final Logger LOGGER =
		Logger.getLogger(ValidationUtils.class.getName());

	public static final int MIN_NUM = 0;
	public static final int MAX_NUM = 4;

	// constructor
	private ValidationUtils() {

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
				LOGGER.log(Level.SEVERE, "Please enter valid positive number");
				scanner.next();
			}
			number = scanner.nextInt();
		}
		while (!isValidNumber(number));
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
	private static boolean isValidNumber(int number) {

		if (number <= MIN_NUM && number >= MAX_NUM) {
			LOGGER.log(Level.SEVERE, "Please enter number greater than 0: ");
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * Function is used to validate the name of student
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @return name {@link String} name
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static String nameValidation(Scanner scanner) {

		String name;
		String pattern = "[a-zA-Z]+[a-z A-Z]*";
		while (!scanner.hasNext(pattern)) {
			LOGGER.log(Level.SEVERE, "Please enter the valid name: ");
			scanner.next();
		}
		name = scanner.next();
		return name;
	}

	/**
	 * Function is used to check whether or not empty using scanner
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @param field
	 *            {@link String}
	 * @return username {@link String} input value
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static String emptyValidation(Scanner scanner, String field) {

		String username = "";
		boolean isNextInput = true;
		while (isNextInput) {
			if (!scanner.hasNextLine()) {
				scanner.nextLine();
			}
			else {
				username = scanner.nextLine();
				if (username.isEmpty()) {
					LOGGER.log(Level.WARNING, field + " can't be empty : ");
					continue;
				}
				else {
					isNextInput = false;
				}
			}
		}
		return username;
	}

	/**
	 * Function is used to check whether or not empty search key
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @return username {@link String} input value
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static String keyValidation(Scanner scanner) {

		String key = scanner.nextLine();
		while (true) {
			if (scanner.hasNextLine()) {
				key = scanner.nextLine();
			}
			else {
				key = null;
			}
			return key;
		}

	}
}
