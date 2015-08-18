package com.lftechnology.java.training.sanish.fibonacci;

import java.util.logging.Logger;
import java.util.logging.Level;
/**
 * Get Even Fibonacci numbers sum
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 *
 */
public class Fibonacci {
	private static final Logger LOGGER = Logger.getLogger(Fibonacci.class.getName());
	public static void main(String[] args){
		LOGGER.log(Level.INFO, "The sum of the even-valued terms of Fibonacci number not exceed four million : {0}", new Object[] {FibonacciNumber.sumEventFibonacciNumber(Constants.FIRST_NUM, Constants.SECOND_NUM, Constants.MAX_NUM) });
	}
}
