package com.lftechnology.java.training.dipak.fibonacci;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be:
 * 
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 
 * By considering the terms in the Fibonacci sequence whose values do not exceed
 * four million, find the sum of the even-valued terms.
 * 
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 */

public class EvenFibonacci {
	private static final Logger LOGGER = Logger.getLogger(EvenFibonacci.class.getName());
	private int series[];
	private int index = 0;

	public EvenFibonacci(int range) {
		series = new int[range];
	}

	/**
	 * <p>
	 * This method generates the fibonacci series for the given range.
	 * </p>
	 * 
	 * @param range
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void generateSeries(int range) {
		int num1 = 0;
		int num2 = 1;
		for (int sum = 0; sum < range;) {
			sum = num1 + num2;
			series[index++] = sum;
			num1 = num2;
			num2 = sum;
		}
	}

	public boolean checkEven(int number) {
		return (number % 2 == 0);
	}

	/**
	 * <p>
	 * This method calculates the sum of all the even integers present in the
	 * array holding the fibonacci series
	 * </p>
	 * return sum
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public int getEvenNumberSum() {
		int sum = 0;
		for (int i = 0; i < index; i++) {
			if (checkEven(series[i])) {
				sum += series[i];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			for (;;) {
				LOGGER.info("Enter the range upto which the sum even numbers of fibonacci series is to be calculated");

				try {
					int range = Math.abs(Integer.parseInt(scanner.nextLine()));
					EvenFibonacci ef1 = new EvenFibonacci(range);
					ef1.generateSeries(range);
					int sum = ef1.getEvenNumberSum();
					LOGGER.log(Level.INFO,
							"The sum of even numbers of fibonacci series whose values do not exceed {0} = {1}",
							new Object[] { range, sum });
					break;
				} catch (NumberFormatException nfe) {
					LOGGER.info("Characters entered or value out of integer out of bound.Re-enter the values.");
				}
			}
		} catch (Exception e) {
			LOGGER.info("Exception occurred");
		}

	}

}
