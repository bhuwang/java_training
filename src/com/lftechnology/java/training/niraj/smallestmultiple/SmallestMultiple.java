/**
 * 
 */
package com.lftechnology.java.training.niraj.smallestmultiple;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Get the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 */
public class SmallestMultiple {

	private static Logger LOGGER = Logger.getLogger(SmallestMultiple.class
			.getName());

	private SmallestMultiple() {

	}

	public static void main(String[] args) {
		int minNum = 1;
		int maxNum = 20;
		Multiples multiplesHelper = new Multiples(minNum, maxNum);
		int smallestMultiple = multiplesHelper.smallestMultiple();
		LOGGER.log(Level.INFO,"The smallest positive number that is evenly divisible by all of the numbers from {0} to {1} is {2}",new Object[] { minNum, maxNum, smallestMultiple });

	}
}
