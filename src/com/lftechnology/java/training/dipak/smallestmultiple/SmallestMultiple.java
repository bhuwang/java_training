
package com.lftechnology.java.training.dipak.smallestmultiple;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder. What is the smallest positive number that is
 * evenly divisible by all of the numbers from 1 to 20
 * 
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 */
public class SmallestMultiple {

	private static final Logger LOGGER =
		Logger.getLogger(SmallestMultiple.class.getName());
	private int smallest = 1;
	private int startingPoint = 0;
	private int endingPoint = 0;

	SmallestMultiple(int start, int end) {
		startingPoint = start;
		endingPoint = end;
	}

	/**
	 * <p> This method checks all numbers.The method doesn't terminate until a
	 * number if found </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void getMultiples() {
		int i = smallest;
		while (i >= smallest) {
			if (checkMultiples(i)) {
				smallest = i;
				break;
			}
			i = i + smallest;
		}
	}

	/**
	 * <p> This method checks whether the number is multiple of numbers from
	 * 1-20 or not. </p>
	 * 
	 * @param number
	 * @return true if the number is a multiple of all the numbers in the given
	 *         range else false
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */

	private boolean checkMultiples(int number) {

		int count = 0;
		for (int i = startingPoint; i <= endingPoint; i++) {
			if (number % i == 0) {
				count++;
			}
			else {
				break;
			}
		}
		return count == endingPoint;

	}

	public static void main(String[] args) {

		SmallestMultiple sm1 = new SmallestMultiple(1, 20);

		sm1.getMultiples();

		LOGGER.log(
			Level.INFO,
			"The smallest multiple that can be divided evenly by all nos. from 1-20 is {0}",
			sm1.smallest);
	}

}
