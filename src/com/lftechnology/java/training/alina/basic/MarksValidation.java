package com.lftechnology.java.training.alina.basic;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class MarksValidation contains different validations regarding marks
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class MarksValidation {

	private static final Logger LOGGER = Logger.getLogger(MarksValidation.class.getName());

	/**
	 * Function used to validate the number
	 * 
	 * @param input
	 *            {@link Scanner}
	 * @param fieldLabel
	 *            {@link String} label given to a field
	 * @return fieldName {@link Integer} input value by user
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public int numberValidation(Scanner input, String fieldLabel) {
		int fieldValue;
		int minValue = 1;
		do {
			LOGGER.log(Level.INFO, fieldLabel);
			while (!input.hasNextInt()) {
				LOGGER.log(Level.INFO, "Please enter valid number.");
				input.nextLine();
			}
			fieldValue = Integer.parseInt(input.nextLine());
		} while (!isValidNumber(fieldValue, minValue));
		return fieldValue;
	}

	/**
	 * Function used to check if a number is valid and within range
	 * 
	 * @param fieldValue
	 *            {@link Integer} value of input field
	 * @param minValue
	 *            {@link Integer} minimum value to compare
	 * @return {@link Boolean}
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static boolean isValidNumber(int fieldValue, int minValue) {
		if (fieldValue < minValue) {
			LOGGER.log(Level.INFO, "Please enter number greater than 0 : ");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Function used to validate the student's marks
	 * 
	 * @param input
	 *            {@link Scanner}
	 * @param fieldLabel
	 *            {@link String} label of the field
	 * @return fieldValue {@link Float} input marks
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public float marksValidation(Scanner input, String fieldLabel) {
		float fieldValue;
		int minValue = 1;
		int maxValue = 100;
		do {
			LOGGER.log(Level.INFO, fieldLabel);
			while (!input.hasNextInt()) {
				LOGGER.log(Level.INFO, "Please enter number within range (1-100) : ");
				input.nextLine();
			}
			fieldValue = Float.parseFloat(input.nextLine());
		} while (!isValidMarks(fieldValue, minValue, maxValue));
		return fieldValue;
	}

	/**
	 * Function used to check if the marks is valid & is within the range
	 * 
	 * @param fieldValue
	 *            {@link Float} input marks value
	 * @param minValue
	 *            {@link Integer} minimum value
	 * @param maxValue
	 *            {@link Integer} maximum value
	 * @return {@link Boolean}
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static boolean isValidMarks(float fieldValue, int minValue,
			int maxValue) {
		if (fieldValue < minValue || fieldValue > maxValue) {
			LOGGER.log(Level.INFO, "Please enter number within range (1-100) : ");
			return false;
		} else {
			return true;
		}
	}

}
