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
	private static final int FIRST_NUM = 0;
	private static final int SECOND_NUM = 1;
	private static final int MAX_NUM = 4000000;
	public static void main(String args[]){
		LOGGER.log(Level.INFO, "The sum of the even-valued terms of Fibonacci number not exceed four million : {0}", new Object[] {FibonacciNumber.sumEventFibonacciNumber(FIRST_NUM, SECOND_NUM, MAX_NUM) });
	}
}
