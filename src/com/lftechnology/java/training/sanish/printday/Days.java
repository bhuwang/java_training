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
	private static final String SUNDAY = "Sunday";
	private static final String MONDAY = "Monday";
	private static final String TUESDAY = "Tuesday";
	private static final String WEDNESDAY = "Wednesday";
	private static final String THURSDAY = "Thusday";
	private static final String FRIDAY = "Friday";
	private static final String SATURDAY = "Saturday";
	private static final String INVALID_DAY = "Not a valid day";
	private static final String[] DAYS = { SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
			THURSDAY, FRIDAY, SATURDAY };

	public static void main(String args[]) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			LOGGER.log(Level.INFO, "Enter day index to find day :");
			int dayIndex = scanner.nextInt();
			LOGGER.log(Level.INFO, "Day at index {0}: {1}", new Object[] {
					dayIndex, PrintDayInWord(dayIndex) });
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
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
	public static String PrintDayInWord(int dayIndex) {
		if (dayIndex < DAYS.length) {
			return DAYS[dayIndex];
		} else {
			return INVALID_DAY;
		}
	}
}
