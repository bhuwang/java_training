package com.lftechnology.java.training.dipak.days;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * program called PrintDayInWord, which prints "Sunday", "Monday", ...
 * "Saturday" if the int variable "day" is 0, 1, ..., 6, respectively.
 * Otherwise, it shall print "Not a valid day"
 * 
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 */
public class PrintDay {
	private static final Logger LOGGER = Logger.getLogger(PrintDay.class.getName());

	/**
	 * <p>
	 * This method checks whether the day number matches to the day or not
	 * </p>
	 * 
	 * @param dayNumber
	 * @return day
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	String getDay(int dayNumber) {
		String day;
		switch (dayNumber) {
		case 1:
			day = CommonConstantsDayNames.SUNDAY;
			break;
		case 2:
			day = CommonConstantsDayNames.MONDAY;
			break;
		case 3:
			day = CommonConstantsDayNames.TUESDAY;
			break;
		case 4:
			day = CommonConstantsDayNames.WEDNESDAY;
			break;
		case 5:
			day = CommonConstantsDayNames.THURSDAY;
			break;
		case 6:
			day = CommonConstantsDayNames.FRIDAY;
			break;
		case 7:
			day = CommonConstantsDayNames.SATURDAY;
			break;
		default:
			day = CommonConstantsDayNames.INVALID_DAY;
			break;
		}
		return day;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean closeResource=false;
		for (;;) {
			LOGGER.info("Enter a number(1-7) or press any number (<=0) to terminate::");
			int day;
			try {
				day = Integer.parseInt(sc.nextLine());
				if (day <= 0) {
					closeResource=true;
					break;
				}
				PrintDay pd1 = new PrintDay();
				String displayText = pd1.getDay(day);
				LOGGER.info(displayText);
			} catch (NumberFormatException nfe) {
				LOGGER.info("Characters entered.Re-enter the values.");
			}finally{
				if(closeResource){
					sc.close();
				}
			}
		}
	}

}
