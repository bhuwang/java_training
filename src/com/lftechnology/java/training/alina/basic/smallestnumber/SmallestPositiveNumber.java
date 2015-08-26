package com.lftechnology.java.training.alina.basic.smallestnumber;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder. What is the smallest positive number that is
 * evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 *
 */
public class SmallestPositiveNumber {

	private static final Logger LOGGER = Logger
			.getLogger(SmallestPositiveNumber.class.getName());

<<<<<<< HEAD
	
	private SmallestPositiveNumber() {
	}
	
=======
>>>>>>> 34_dipak
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int rangeLimit;
			LOGGER.info("Enter the maximum range number > ");
			rangeLimit = scanner.nextInt();
			Long smallestNumber = displaySmallestNumber(rangeLimit);
			LOGGER.log(
					Level.INFO,
					"The smallest positive number that is evenly divisible by all of the numbers from 1 to {0} is : {1}",
					new Object[] { rangeLimit, smallestNumber.toString() });
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Exception Message : {0}",
					new Object[] { e });
		}
	}

	/**
	 * Function used to display smallest positive number
	 * 
	 * @param rangeLimit
	 *            {@link Integer} maximum range
	 * @return number {@link Long} smallest positive number
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static Long displaySmallestNumber(int rangeLimit) {
		long number = rangeLimit;
		int i = 2;
		while (i < rangeLimit) {
			number = leastCommonMultiple(number, i);
			i++;
		}
		return number;
	}

	/**
	 * Function to find the LCM of numbers
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return firstNumber
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public static Long leastCommonMultiple(long firstNumber, long secondNumber) {
		long num1, num2;
		if (firstNumber > secondNumber) {
			num1 = firstNumber;
			num2 = secondNumber;
		} else {
			num1 = secondNumber;
			num2 = firstNumber;
		}
		for (int i = 1; i <= num2; i++) {
			if ((num1 * i) % num2 == 0) {
				return (long) (i * num1);
			}
		}
<<<<<<< HEAD
		return num2;
=======
		throw new Error("Error");
>>>>>>> 34_dipak
	}
}
