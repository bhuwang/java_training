package com.lftechnology.java.training.sanish.fibonacci;

import java.util.logging.Logger;
/**
 * Get Even Fibonacci numbers sum
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 *
 */
public class Fibonacci {
	private static final Logger LOGGER = Logger.getLogger(Fibonacci.class.getName());
	public static void main(String args[]){
		LOGGER.info("The sum of the even-valued terms of Fibonacci number not exceed four million : " + FibonacciNumber.sumEventFibonacciNumber(1, 2, 400000));
	}
}
