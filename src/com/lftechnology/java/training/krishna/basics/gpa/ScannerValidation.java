package com.lftechnology.java.training.krishna.basics.gpa;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ScannerValidation.java
 * 
 * This program is used for validation.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class ScannerValidation {

	private static final Logger LOGGER = Logger
			.getLogger(ScannerValidation.class.getName());

	public static final int MIN_NUM = 0;
	public static final int MAX_NUM = 100;

	//constructor
	private ScannerValidation() {
		
	}

	/**
	 * Function is used to validate the user input using scanner
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @return number {@link Integer} input value
	 * 
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
		} while (!isValidNumber(number));
		return number;
	}

	/**
	 * Function is used to check if number is valid and within range
	 *
	 * @param number
	 *            {@link int} number
	 * @return {@link boolean}
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static boolean isValidNumber(int number) {
		if (number <= MIN_NUM) {
			LOGGER.log(Level.INFO, "Please enter number greater than 0 : ");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Function is used to validate the marks of student
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @return mark {@link int} input marks
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static int markValidation(Scanner scanner) {
		int mark;
		do {
			while (!scanner.hasNextInt()) {
				LOGGER.log(Level.INFO,
						"Please enter number valid positive number");
				scanner.nextLine();
			}
			mark = scanner.nextInt();
		} while (!isValidMark(mark));
		return mark;
	}

	/**
	 * Function is used to check if the marks is within the range 1-100
	 *
	 * @param mark
	 *            {@link int} input marks value
	 * @return {@link boolean}
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static boolean isValidMark(int mark) {
		if (mark < MIN_NUM || mark > MAX_NUM) {
			LOGGER.log(Level.INFO,
					"Please enter number within range (1-100) : ");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Function is used to validate the name of student
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @return name {@link String} name
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static String nameValidation(Scanner scanner) {
		String name;
		String pattern = "[a-zA-Z]+[a-z A-Z]*";
		while (!scanner.hasNext(pattern)) {
			LOGGER.log(Level.WARNING, "Please enter the valid name");
			scanner.next();
		}
		name = scanner.next();
		return name;
	}
}