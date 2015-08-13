package com.lftechnology.java.training.krishna.basics.smallestmultiple;

import java.util.logging.Level;
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
	private final static Logger LOGGER = Logger.getLogger(SmallestMultipleDemo.class.getName());

	
	/**
	 * This is the main method which makes use of smallestPositiveNumber() method.
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void main(String[] args) {
		int number = 2520;
		SmallestMultiple smallestMultiple = new SmallestMultiple();
		Long positiveNumber = smallestMultiple.smallestPositiveNumber(number);
		LOGGER.log(Level.INFO, "Smallest positive number : {0}", positiveNumber.toString());
	}

}
