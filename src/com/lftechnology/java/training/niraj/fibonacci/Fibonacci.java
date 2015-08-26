/**
 * 
 */

package com.lftechnology.java.training.niraj.fibonacci;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class related to fibonacci series
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 */
public class Fibonacci {

	/**
	 * Get Fibonacci series with certain limit
	 * 
	 * @param num1
	 *            {@link Integer}
	 * @param num2
	 *            {@link Integer}
	 * @param limit
	 *            {@link Integer}
	 * @return List {@link List} containing numbers in a fibonacci Series
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public List<Integer> getFibonacciSeries(int num1, int num2, int limit) {

		List<Integer> series = new ArrayList<Integer>();
		int sum = 0;
		int firstNum = num1;
		int secondNum = num2;
		series.add(num1);
		series.add(num2);
		while (sum < limit) {
			sum = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = sum;
			series.add(sum);
		}
		return series;
	}

	/**
	 * Get sum of odd/even number in a fibonacci series under certain limit
	 * 
	 * @param num1
	 *            {@link Integer}
	 * @param num2
	 *            {@link Integer}
	 * @param limit
	 *            {@link Integer}
	 * @param numType
	 *            {@link String}
	 * @return Sum of odd/even number in the series
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public int getSum(int num1, int num2, int limit, String numType) {

		int sum = 0;
		int remainder = (numType == Constant.ODD) ? 1 : 0;
		List<Integer> fibonacciSeries = getFibonacciSeries(num1, num2, limit);
		for (int num : fibonacciSeries) {
			if (num % 2 == remainder) {
				sum += num;
			}
		}
		return sum;
	}

}
