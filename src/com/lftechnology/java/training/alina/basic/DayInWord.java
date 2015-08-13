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
public class DayInWord {

	private static final Logger LOGGER = Logger.getLogger(DayInWord.class.getName());

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			displayDayName(scanner);
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
		} 
	}

	/**
	 * Function used to get name of day on the basis of input number
	 * 
	 * @param int number input number
	 * @return String day
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private String getDayName(int number) {
		String day = null;
		switch (number) {
		case 0:
			day = CommonConstants.SUNDAY;
			break;
		case 1:
			day = CommonConstants.MONDAY;
			break;
		case 2:
			day = CommonConstants.TUESDAY;
			break;
		case 3:
			day = CommonConstants.WEDNESDAY;
			break;
		case 4:
			day = CommonConstants.THURSDAY;
			break;
		case 5:
			day = CommonConstants.FRIDAY;
			break;
		case 6:
			day = CommonConstants.SATURDAY;
			break;
		default:
			day = CommonConstants.INVALID_DAY;
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
		DayInWord dayName = new DayInWord();
		while (number >= 0) {
			LOGGER.info("Day " + number + " is " + dayName.getDayName(number));
			LOGGER.info("Please enter another number > ");
			number++;
			number = scanner.nextInt();
		}
	}
}
