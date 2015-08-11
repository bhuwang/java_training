package com.lftechnology.java.training.sanish.palindrome;

import java.util.logging.Logger;

/**
 * Provide palindrome calculation functions
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Palindrome {
	/**
	 * Calculate and return largest palindrome number made from the product of two provided digit numbers
	 * 
	 * @param int digitLength digit length of two product from which have find largest palindrome number
	 * @return int largest palindrome number
	 * @throws Exception Digit length greater than 4 not supported
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static int getLargestPalindrome(int digitLength) throws Exception {
		final Logger LOGGER = Logger.getLogger(Main.class.getName());
		int maxNum = (int) Math.pow(10, digitLength) - 1;
		int minNum = (int) Math.pow(10, digitLength - 1);
		if (digitLength <= 4) {
			for (int i = maxNum; i > minNum; i--) {
				for (int j = maxNum; j > minNum; j--) {
					int multipleNum = j * i;
					if (isPalindromNum(multipleNum)) {
						LOGGER.info(i + " * " + j + " = " + multipleNum);
						return multipleNum;
					}
				}
			}
		} else {
			throw new Exception("Digit length greater than 4 not supported.");
		}

		return 0;
	}

	/**
	 * Check is supplied number is palindrom number or not
	 * 
	 * @param int number number that have to check is palindrom number
	 * @return boolean ture if supplied number is palindrom else false
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static boolean isPalindromNum(int number) {
		int preNumber = number;
		int reverse = 0;
		while (number != 0) {
			reverse = reverse * 10;
			reverse = reverse + number % 10;
			number = number / 10;
		}

		return preNumber == reverse;
	}
}
