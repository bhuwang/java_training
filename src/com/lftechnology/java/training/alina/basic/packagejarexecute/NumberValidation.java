
package com.lftechnology.java.training.alina.basic.packagejarexecute;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * NumberValidation Class consists of validations related to numbers
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class NumberValidation {

	private static final Logger LOGGER =
		Logger.getLogger(NumberValidation.class.getName());

	/**
	 * Function used to validate the number
	 * 
	 * @param input
	 *            {@link Scanner}
	 * @param fieldLabel
	 *            {@link String} label given to a field
	 * @return fieldValue {@link Integer} input value by user
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public float numberValidation(Scanner input, String fieldLabel) {

		float fieldValue;
		do {
			LOGGER.log(Level.INFO, fieldLabel);
			while (!input.hasNextFloat()) {
				LOGGER.log(Level.INFO, "Please enter valid number : ");
				input.nextLine();
			}
			fieldValue = Float.parseFloat(input.nextLine());
		}
		while (fieldValue < 0);
		return fieldValue;
	}
}
