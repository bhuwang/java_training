package com.lftechnology.java.training.krishna.basics.smallest_multiple;

import java.util.logging.Logger;

/**
 * SmallestMultipleDemo.java
 * 
 * Log the output on the console.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class SmallestMultipleDemo {
	private final static Logger LOGGER = Logger.getLogger(SmallestMultiple.class.getName());
	
	/**
	 * This is the main method which makes use of smallestPositiveNumber() method.
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */

	public static void main(String[] args) {
		int number = 2520;
		SmallestMultiple smallestMultiple = new SmallestMultiple();
		long positiveNumber = smallestMultiple.smallestPositiveNumber(number);
		LOGGER.info("smallest positive number : " + positiveNumber);
	}

}
