package com.lftechnology.java.training.krishna.basics.print_day_in_word;

/**
 * The PrintDayInWord program implements an application that simply display the day
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class PrintDayInWord {
	/**
	 * <p>
	 * Function is used to display day with number
	 * </p>
	 * 
	 * @param int day
	 * @return String dayName name of day
	 * @author Krishna Timilsina<krishnatimilsina@lftechnology.com>
	 */
	public String switchDay(int day) {
		String dayName = null;
		switch (day) {
		case 1:
			dayName = "Sunday";
			break;
		case 2:
			dayName = "Monday";
			break;
		case 3:
			dayName = "Tuesday";
			break;
		case 4:
			dayName = "Wednesday";
			break;
		case 5:
			dayName = "Thursday";
			break;
		case 6:
			dayName = "Friday";
			break;
		case 7:
			dayName = "Saturday";
			break;
		default:
			dayName = "Not a valid day";
			break;
		}
		return dayName;
	}
}
