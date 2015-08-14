package com.lftechnology.java.training.krishna.basics.evenfibonacci;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * EvenFibonacciDemo.java
 * 
 * Log the output on the console.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */

public class EvenFibonacciDemo {
	private final static Logger LOGGER = Logger.getLogger(EvenFibonacciDemo.class.getName());
	
	/**
	 * This is the main method which makes use of sumEvenFibonacci() method.
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void main(String[] args) {
		EvenFibonacci evenFibonacci = new EvenFibonacci(0, 1);
		Integer sumFibonacci = evenFibonacci.sumEvenFibonacci();
		LOGGER.log(Level.INFO, "Sum of even fibonacci number : {0}", new Object[]{sumFibonacci.toString()});
	}

}
