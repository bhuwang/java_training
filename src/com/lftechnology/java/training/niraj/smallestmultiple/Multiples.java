package com.lftechnology.java.training.niraj.smallestmultiple;

/**
 * Helper class that consists of helper functions related to multiples
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 */
public class Multiples {

	private int minNum;
	private int maxNum;

	public Multiples(int minNum, int maxNum) {
		this.minNum = minNum;
		this.maxNum = maxNum;
	}

	/**
	 * Gets the smallest multiple that divisible evenly
	 * 
	 * @return {@link Integer} smallest number evenly divisible by numbers in
	 *         certain range
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public int smallestMultiple() {
		int smallestMultiple = 0;
		int num = maxNum;
		for (;;) {
			if (isMultiple(num)) {
				smallestMultiple = num;
				break;
			}
			num++;
		}
		return smallestMultiple;
	}

	/**
	 * Checks if a number is evenly divisible by number in certain range
	 * 
	 * @param num
	 *            {@link Integer}
	 * @return {@link Boolean}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public boolean isMultiple(int num) {
		for (int i = minNum; i <= maxNum; i++) {
			if (num % i != 0) {
				return false;
			}
		}
		return true;
	}

}
