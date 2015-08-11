package com.lftechnology.java.training.alina.basic;

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

	final static Logger LOGGER = Logger.getLogger(SumOfMultiples.class.getName());

	public static void main(String[] args) {
		try {
			SumOfMultiples sum = new SumOfMultiples();
			sum.getTotalSum();
			LOGGER.info("Sum of multiples of 3 & 5 is : " + sum.getTotalSum());
		} catch (ArithmeticException ex) {
			LOGGER.warning("Exception : " + ex.getMessage());
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
