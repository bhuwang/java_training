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
	 * @param scanner {@link Scanner}
	 * @param min {@link Integer} Minimum value acceptable
	 * @param max {@link Integer} Maximum value acceptable
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
				scanner.next();
			} else {
				break;
			}
		}

		return num;
	}

	/**
	 * Scan string form console and return string
	 * 
	 * @param scanner {@link Scanner}
	 * @return {@link Scanner}
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static String getName(Scanner scanner) {
		String name;
		Pattern pattern = Pattern.compile("[a-z A-Z]*");
		while (!scanner.hasNext(pattern)) {
			LOGGER.log(Level.WARNING, "Only characters are allowed : ");
			scanner.next();
		}
		name = scanner.next();
		return name;
	}

}
