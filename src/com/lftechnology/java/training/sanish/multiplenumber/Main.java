package com.lftechnology.java.training.sanish.multiplenumber;

import java.util.logging.Logger;

/**
 * Class Main
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 *
 */
public class Main {
	public static void main(String args[]) {
		final Logger LOGGER = Logger.getLogger(Main.class.getName());
		try {
			LOGGER.info("The smallest positive number that is divisible by all of the numbers from 1 to 20 : "
					+ MultiplierNumber.getSmallerMultipleNum(1, 20));
		} catch (ArithmeticException e) {
			LOGGER.warning("Exception : " + e.getMessage());
		}
	}
}
