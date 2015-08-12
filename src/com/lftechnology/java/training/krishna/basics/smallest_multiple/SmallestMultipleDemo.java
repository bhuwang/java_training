package com.lftechnology.java.training.krishna.basics.smallest_multiple;

import java.util.logging.Logger;

public class SmallestMultipleDemo {
	private final static Logger LOGGER = Logger.getLogger(SmallestMultiple.class.getName());

	public static void main(String[] args) {

		SmallestMultiple smallestMultiple = new SmallestMultiple();
		long number = smallestMultiple.smallestPositiveNumber();
		LOGGER.info("smallest positive number : " + number);

	}

}
