package com.lftechnology.java.training.srijan.basics;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
   Find the sum of all the multiples of 3 or 5 below 1000.
 */

import java.util.logging.Logger;

public class Multiples {
	private int num = 1000;
	private int sum = 0;
	
	private static final Logger LOGGER = Logger.getLogger(Fabonacci.class.getName());

	public static void main(String[] args) {
		calculateDivisibles(3, 5);
	}

	/**
	 * <p>
	 * Prints numbers between 1 and 1000 divisible by 3 and 5
	 * </p>
	 * <p>
	 * Calculates sum of numbers exactly divisible by 3 and 5 and shows result
	 * </p>
	 * 
	 * @param num1
	 * @param num2
	 * @return sum
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */

	public static void calculateDivisibles(int num1, int num2) {
		Multiples multiple = new Multiples();
		for (int i = 1; i < multiple.num; i++) {
			if (i % num1 == 0 || i % num2 == 0) {
				LOGGER.info(i + " ");
				multiple.sum = multiple.sum + i;
			}
		}
		LOGGER.info("\n");
		LOGGER.info("Sum of Multiples are=" + multiple);
	}
	@Override
	public String toString() {
		return "sum of multiples are=" + sum;
	}

}
