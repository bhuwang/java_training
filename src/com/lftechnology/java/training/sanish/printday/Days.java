package com.lftechnology.java.training.sanish.printday;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Print days as give day index
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 *
 */
public class Days {
	private static final Logger LOGGER = Logger.getLogger(Days.class.getName());
	private static final String[] DAY_NAMES = { Constants.SUNDAY,
			Constants.MONDAY, Constants.TUESDAY, Constants.WEDNESDAY,
			Constants.THURSDAY, Constants.FRIDAY, Constants.SATURDAY };

	private Days() {

	}

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			LOGGER.log(Level.INFO, "Enter day index to find day :");
			int dayIndex = scanner.nextInt();
			LOGGER.log(Level.INFO, "Day at index {0}: {1}", new Object[] {
					dayIndex, printDayInWord(dayIndex) });
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Exception : {1}",
					new Object[] { e.getMessage() });
		} finally {
			if (scanner != null)
				scanner.close();
		}

	}

	/**
	 * Return day as provided day index value
	 * 
	 * @param dayIndex
	 *            {@link Integer} Day index
	 * @return {@link String}
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static String printDayInWord(int dayIndex) {
		if (dayIndex < DAY_NAMES.length) {
			return DAY_NAMES[dayIndex];
		} else {
			return Constants.INVALID_DAY;
		}
	}
}
