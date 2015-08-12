package com.lftechnology.java.training.krishna.basics.print_day_in_word;

import java.util.logging.Logger;

public class PrintDayInWordDemo {
	private final static Logger LOGGER = Logger.getLogger(PrintDayInWord.class.getName());
	public static void main(String[] args) {
		int day = 5;
		PrintDayInWord printDayInWord = new PrintDayInWord();
		String dayName = printDayInWord.switchDay(day);
		LOGGER.info("Day: " + dayName);

	}

}
