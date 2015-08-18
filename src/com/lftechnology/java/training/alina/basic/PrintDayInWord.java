package com.lftechnology.java.training.alina.basic;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Write a program called PrintDayInWord, which prints “Sunday”, “Monday”, ...
 * “Saturday” if the int variable "day" is 0, 1, ..., 6, respectively.
 * Otherwise, it shall print “Not a valid day”.
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 *
 */
public class PrintDayInWord {

	private static final Logger LOGGER = Logger.getLogger(PrintDayInWord.class.getName());

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			displayDayName(scanner);
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			if (scanner != null)
				scanner.close();
		}

	}

	/**
	 * Function used to get name of day on the basis of input number
	 * 
	 * @param int number input number
	 * @return String day
	 */
	private String getDayName(int number) {
		String day = null;
		switch (number) {
		case 0:
			day = BasicConstants.SUNDAY;
			break;
		case 1:
			day = BasicConstants.MONDAY;
			break;
		case 2:
			day = BasicConstants.TUESDAY;
			break;
		case 3:
			day = BasicConstants.WEDNESDAY;
			break;
		case 4:
			day = BasicConstants.THURSDAY;
			break;
		case 5:
			day = BasicConstants.FRIDAY;
			break;
		case 6:
			day = BasicConstants.SATURDAY;
			break;
		default:
			day = BasicConstants.INVALID_DAY;
			break;
		}
		return day;
	}

	/**
	 * Function used to display day name with number given
	 * 
	 * @param scanner
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static void displayDayName(Scanner scanner) {
		int number;
		LOGGER.info("Enter a number > ");
		number = scanner.nextInt();
		PrintDayInWord dayName = new PrintDayInWord();
		while (number >= 0) {
			LOGGER.info("Day " + number + " is " + dayName.getDayName(number));
			LOGGER.info("Please enter another number > ");
			number++;
			number = scanner.nextInt();
		}
	}
}
