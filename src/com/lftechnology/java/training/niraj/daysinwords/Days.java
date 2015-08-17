/**
 * 
 */
package com.lftechnology.java.training.niraj.daysinwords;


/**
 * Helper class that has helper methods to functionality related to days
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class Days {
	private static final String NOT_VALID = "Not a valid day";

	/**
	 * Get day in words as per the day in number provided
	 * @param day {@link Integer}
	 * @return dayInWords {@link String}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public static String getDayInWords(int day) {
		String dayInWord;
		switch (day) {
		case 0:
			dayInWord = Constants.SUNDAY;
			break;
		case 1:
			dayInWord = Constants.MONDAY;
			break;
		case 2:
			dayInWord = Constants.TUESDAY;
			break;
		case 3:
			dayInWord = Constants.WEDNESDAY;
			break;
		case 4:
			dayInWord = Constants.THURSDAY;
			break;
		case 5:
			dayInWord = Constants.FRIDAY;
			break;
		case 6:
			dayInWord = Constants.SATURDAY;
			break;		
		default:
			dayInWord = NOT_VALID;

		}
		return dayInWord;
	}
}
