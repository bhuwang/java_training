
package com.lftechnology.java.training.krishna.basics.guessingnumber;

import java.util.Random;

/**
 * GuessingNumber.java 
 * 
 * This program used to generate random integer.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class GuessingNumber {

	//constructor
	private GuessingNumber() {

	}

	/**
	 * Generate a random number between min and max number, inclusive
	 *
	 * @param min
	 *            {@link int}
	 * @param max
	 *            {@link int}
	 * @return {@link int} random integer between min and max number
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static int randomInteger(int min, int max) {

		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}

}
