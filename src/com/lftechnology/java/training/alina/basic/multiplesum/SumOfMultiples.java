package com.lftechnology.java.training.alina.basic.multiplesum;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the
 * multiples of 3 or 5 below 1000.
 *
 * @author Alina Shakya<alinashakya@lftechnology.com>
 */
public class SumOfMultiples {
	private static final Logger LOGGER =
		Logger.getLogger(SumOfMultiples.class.getName());

	private SumOfMultiples() {

	}

	public static void main(String[] args) {

		int maxNum = 1000;
		int num1 = 3;
		int num2 = 5;
		try {
			getTotalSum(maxNum, num1, num2);
			int totalSumOfMultiples = getTotalSum(maxNum, num1, num2);
			LOGGER.log(
				Level.INFO, "Sum of multiples of {0} and {1} is : {2}",
				new Object[] {
					num1, num2, totalSumOfMultiples
				});
		}
		catch (ArithmeticException ex) {
			LOGGER.log(Level.WARNING, "Exception Message : {0}", new Object[] {
				ex
			});
		}
	}

	/**
	 * Function used to get the total sum of multiples
	 *
	 * @param maxNum
	 *            {@link Integer} maximum number
	 * @param num1
	 *            {@link Integer} first number
	 * @param num2
	 *            {@link Integer} second number
	 * @return totalSum {@link Integer} total sum of multiples
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static int getTotalSum(int maxNum, int num1, int num2) {
		int totalSum = 0;
		for (int i = 1; i < maxNum; i++) {
			if (i % num1 == 0 || i % num2 == 0) {
				totalSum += i;
			}
		}
		return totalSum;
	}
}
