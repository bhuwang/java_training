package com.lftechnology.java.training.alina.basic;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23. 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author Alina Shakya<alinashakya@lftechnology.com>
 * 
 */
public class SumOfMultiples {

	private static final Logger LOGGER = Logger.getLogger(SumOfMultiples.class.getName());

	public static void main(String[] args) {
		try {
			SumOfMultiples sum = new SumOfMultiples();
			int getTotalSum = sum.getTotalSum();
			LOGGER.log(Level.INFO, "Sum of multiples of 3 & 5 is : {0}", new Object[] {getTotalSum});
		} catch (ArithmeticException ex) {
			LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] {ex.getMessage()});
		}
	}
	
	/**
	 * Function used to get the sum of multiples i.e 3 or 5
	 * 
	 * @return int totalSum Sum of multiples
	 * @author Alina Shakya<alinashakya@lftechnology.com>
	 */
	public int getTotalSum(){
		int totalSum = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				totalSum += i;
			}
		}
		return totalSum;
	}

}
