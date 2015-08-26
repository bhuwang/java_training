/**
 * 
 */

package com.lftechnology.java.training.niraj.shuffle;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gets inputs from the user
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 */
public class UserInputImpl implements UserInput {

	private static final Logger LOGGER =
		Logger.getLogger(UserInputImpl.class.getName());

	@Override
	public int getInput(Scanner scanner, int min, int max) {

		int listLength;
		LOGGER.log(
			Level.INFO, "Please select number between {0} and {1}:",
			new Object[] {
				min, max
			});
		while (true) {
			listLength = getInputInt(scanner);
			if ((listLength < min) || (listLength > max)) {
				LOGGER.log(
					Level.WARNING,
					"Please provide a number between {0} and {1} : ",
					new Object[] {
						min, max
					});
			}
			else {
				break;
			}
		}
		return listLength;
	}

	@Override
	public int getInputMin(Scanner scanner, int min) {

		int listLength;
		LOGGER.log(Level.INFO, "Please enter a number greater than {0} : ", min);
		while (true) {
			listLength = getInputInt(scanner);
			if (listLength < min) {
				LOGGER.log(
					Level.WARNING, "Please enter a number greater than {0} : ",
					min);
			}
			else {
				break;
			}
		}

		return listLength;
	}

	@Override
	public int getInputMax(Scanner scanner, int max) {

		int listLength;
		LOGGER.log(Level.INFO, "Please enter a number less than {0} : ", max);
		while (true) {
			listLength = getInputInt(scanner);
			if (listLength > max) {
				LOGGER.log(
					Level.WARNING, "Please enter a number less than {0} : ",
					max);
			}
			else {
				break;
			}
		}
		return scanner.nextInt();
	}

	@Override
	public int getInput(Scanner scanner) {

		LOGGER.info("Please enter a number : ");
		int listLength = getInputInt(scanner);
		return listLength;

	}

	/**
	 * Gets input from the user
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param scanner
	 * @return int user input
	 */
	private int getInputInt(Scanner scanner) {

		while (!scanner.hasNextInt()) {
			LOGGER.warning("Please select a number : ");
		}
		return scanner.nextInt();
	}
}
