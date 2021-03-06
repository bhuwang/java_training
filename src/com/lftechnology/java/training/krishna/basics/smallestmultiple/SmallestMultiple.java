package com.lftechnology.java.training.krishna.basics.smallestmultiple;

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

	//constructor
	public SmallestMultiple() {
		
	}

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
        int positiveNumber = number;
		while (!found) {
			positiveNumber++;
			found = true;
			for (int i = 2; i <= 20; i++) {
				if ((positiveNumber % i != 0) || ((positiveNumber % i) % 2) != 0) {
					found = false;
					break;
				}
			}
		}
		return positiveNumber;
	}

}
