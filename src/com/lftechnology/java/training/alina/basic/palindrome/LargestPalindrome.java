package com.lftechnology.java.training.alina.basic.palindrome;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99. Find the largest
 * palindrome made from the product of two 3-digit numbers.
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 *
 */
public class LargestPalindrome {

	private static final Logger LOGGER = Logger
			.getLogger(LargestPalindrome.class.getName());

	public static void main(String[] args) {
		try {
			getLargestPalindrome();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Exception Message : {0}",
					new Object[] { e });
		}

	}

	/**
	 * Function used to get the largest palindrome number
	 * 
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static void getLargestPalindrome() {
		int highestPalindrome = 0;
		for (int left = 999; left > 2; left--) {
			for (int right = 999; right > 2; right--) {
				int total = left * right;
				if (isPalindrome(total) && total > highestPalindrome) {
					highestPalindrome = total;
				}
			}
		}
		LOGGER.log(Level.INFO, "Highest palindrome is : {0}",
				new Object[] { highestPalindrome });
	}

	/**
	 * Function used to check if the given number is palindrome
	 * 
	 * @param palindrome
	 * @return {@link Boolean}
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public static boolean isPalindrome(int palindrome) {
		String palindromeString = Integer.toString(palindrome);
		String reversed = new StringBuilder(palindromeString).reverse()
				.toString();
		return palindromeString.equals(reversed);
	}
}
