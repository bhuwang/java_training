/**
 * 
 */
package com.lftechnology.java.training.niraj.fibonacci;

import java.util.ArrayList;

/**
 * 
 * Helper class related to fibonacci series
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
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
	 * @return ArrayList containing numbers in a fibonacci Series
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public ArrayList<Integer> getFibonacciSeries(int num1, int num2, int limit) {
		ArrayList<Integer> series = new ArrayList<Integer>();
		int sum = 0;
		series.add(num1);
		series.add(num2);
		while (sum < limit) {
			sum = num1 + num2;
			num1 = num2;
			num2 = sum;
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
		int remainder = (numType == "odd") ? 1 : 0;
		ArrayList<Integer> fibonacciSeries = getFibonacciSeries(num1, num2,
				limit);
		for (int num : fibonacciSeries) {
			if (num % 2 == remainder) {
				sum += num;
			}
		}
		return sum;
	}

}
