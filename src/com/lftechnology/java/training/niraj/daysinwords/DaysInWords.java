
package com.lftechnology.java.training.niraj.daysinwords;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Get days in words
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 */
public class DaysInWords {

	private static final Logger LOGGER =
		Logger.getLogger(DaysInWords.class.getName());

	private DaysInWords() {

	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			LOGGER.log(Level.INFO, "Please provide a day in number (0-6) :");
			while (!scanner.hasNextInt()) {
				LOGGER.log(Level.INFO, "It's not a number. Please try again :");
				scanner.next();
			}
			int day = scanner.nextInt();
			String dayInWords = Days.getDayInWords(day);
			LOGGER.log(
				Level.INFO, "The day you have selected is : {0}", dayInWords);

		}
		catch (InputMismatchException ie) {
			LOGGER.log(Level.WARNING, "Exception:{0}", ie);
		}

	}

}
