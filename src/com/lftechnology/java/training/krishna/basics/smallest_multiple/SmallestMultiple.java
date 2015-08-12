package com.lftechnology.java.training.krishna.basics.smallest_multiple;

/**
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */

public class SmallestMultiple {

	/**
	 * <p>
	 * Function is used to generate smallest positive number
	 * </p>
	 * @param int number Number
	 * @return long number Positive Number
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public long smallestPositiveNumber(int number) {
		boolean found = false;

		while (!found) {
			number++;
			found = true;
			for (int i = 2; i <= 20; i++) {
				if ((number % i != 0) || ((number % i) % 2) != 0) {
					found = false;
					break;
				}
			}
		}
		return number;
	}

}
