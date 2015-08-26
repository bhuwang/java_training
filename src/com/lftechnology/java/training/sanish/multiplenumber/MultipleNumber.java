package com.lftechnology.java.training.sanish.multiplenumber;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Class Main
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 *
 */
public class MultipleNumber {
	private static final Logger LOGGER = Logger.getLogger(MultipleNumber.class
			.getName());
	private static final int FROM_NUM = 1;
	private static final int TO_NUM = 20;

	private MultipleNumber() {

	}

	public static void main(String[] args) {
		try {
			LOGGER.log(
					Level.INFO,
					"The smallest positive number that is divisible by all of the numbers from {0} to {1} : {2}",
					new Object[] { FROM_NUM, TO_NUM,
							Multiplier.getSmallerMultipleNum(FROM_NUM, TO_NUM) });
		} catch (ArithmeticException e) {
			LOGGER.log(Level.WARNING, "Exception : {1}",
					new Object[] { e.getMessage() });
		}
	}
}
