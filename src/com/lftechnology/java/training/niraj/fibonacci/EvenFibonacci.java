/**
 * 
 */
package com.lftechnology.java.training.niraj.fibonacci;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * find the sum of the even-valued terms in a fibonaci series under certain
 * limit
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com> 
 */
public class EvenFibonacci {

	private static final Logger LOGGER = Logger.getLogger(EvenFibonacci.class
			.getName());

	public static void main(String[] args) {
		Fibonacci fibonacciHelper = new Fibonacci();
		int limit = 10;
		int num1=1;
		int num2=2;
		int sum=fibonacciHelper.getSum(num1,num2,limit, "even");
		LOGGER.log(Level.INFO, "The sum of even numbers in fibonacci series below {0} is {1}",
				new Object[] { limit, sum });

	}

}
