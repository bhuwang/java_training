package com.lftechnology.java.training.srijan.basics;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * write a program called PrintDayInWord, which prints “Sunday”, “Monday”, ...
 * “Saturday” if the int variable "day" is 0, 1, ..., 6, respectively.
 * Otherwise, it shall print “Not a valid day”.
 */

public class PrintDayInWord {
	private String[] daysInWeek = new String[7];

	private static final Logger LOGGER = Logger.getLogger(PrintDayInWord.class.getName());

	public PrintDayInWord() {
		daysInWeek[0] = "Sunday";
		daysInWeek[1] = "Monday";
		daysInWeek[2] = "Tuesday";
		daysInWeek[3] = "Wednesday";
		daysInWeek[4] = "Thursday";
		daysInWeek[5] = "Friday";
		daysInWeek[6] = "Saturday";

	}

	public static void main(String[] args) {
		PrintDayInWord daysInWeek = new PrintDayInWord();
		int dayInNumber;

		Scanner input = null;

		
			input = new Scanner(System.in);
			
			LOGGER.info("Please Enter a Number to represent day in a week ");
			dayInNumber = input.nextInt();

			switch (dayInNumber) {

			case 0: {
				LOGGER.info("0 corresponds to" + " " + daysInWeek.daysInWeek[0]);
				break;
			}
			case 1: {
				LOGGER.info("1 corresponds to" + " " + daysInWeek.daysInWeek[1]);
				break;
			}
			case 2: {
				LOGGER.info("2 corresponds to" + " " + daysInWeek.daysInWeek[2]);
				break;
			}
			case 3: {
				LOGGER.info("3 corresponds to" + " " + daysInWeek.daysInWeek[3]);
				break;
			}

			case 4: {
				LOGGER.info("4 corresponds to" + " " + daysInWeek.daysInWeek[4]);
				break;
			}

			case 5: {
				LOGGER.info("5 corresponds to" + " " + daysInWeek.daysInWeek[5]);
				break;
			}

			case 6: {
				LOGGER.info("6 corresponds to" + " " + daysInWeek.daysInWeek[6]);
				break;
			}
			default:
			{
				LOGGER.info("Not a Valid Day");
				break; 
			}
			}

		input.close();

	}
}
