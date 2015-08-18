package com.lftechnology.java.training.sanish.sumnumber;

import java.util.logging.Logger;

/**
 * Main class
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 *
 */
public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	private Main() {

	}

	public static void main(String[] args) {
		try {
			LOGGER.info("Sum sum multiples of 3 or 5 below 1000 : "
					+ (SumMultiples.getMultiples(3, 999) + SumMultiples
							.getMultiples(5, 999)));
		} catch (ArithmeticException e) {
			LOGGER.warning("Exception : " + e.getMessage());
		}
	}
}