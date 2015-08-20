package com.lftechnology.java.training.sanish.student;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Provide methods to get inputs form console
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class UserInput {
	private final static Logger LOGGER = Logger.getLogger(UserInput.class
			.getName());

	/**
	 * Scan number from console and return number
	 * 
	 * @param scanner
	 *            {@link Scanner}
	 * @param min
	 *            {@link Integer} Minimum value acceptable
	 * @param max
	 *            {@link Integer} Maximum value acceptable
	 * @return {@link Integer}
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static int getNumber(Scanner scanner, int min, int max) {
		int num;
		for (;;) {
			while (!scanner.hasNextInt()) {
				LOGGER.log(Level.WARNING, "Please enter valid number : ");
				scanner.next();
			}
			num = scanner.nextInt();
			if (num < min || num > max) {
				LOGGER.log(Level.WARNING,
						"Please enter number within range ({0}-{1}) : ",
						new Object[] { min, max });
			} else {
				break;
			}
		}

		return num;
	}

	/**
	 * Scan string form console and return string
	 * 
	 * @param scanner
	 *            {@link Scanner}
	 * @return {@link Scanner}
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static String getName(Scanner scanner) {
		String name;
		String pattern = "[a-zA-Z]+[a-z A-Z]*";
		for (;;) {
			if (!scanner.hasNextLine()) {
				scanner.nextLine();
			} else {
				name = scanner.nextLine();
				if (name.isEmpty()) {
					continue;
				} else if (!name.matches(pattern)) {
					LOGGER.log(Level.WARNING,
							"Invalid name, Please type again : ");
				} else {
					break;
				}
			}
		}

		return name;
	}

}
