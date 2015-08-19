package com.lftechnology.java.training.krishna.basics.palindrome;


/**
 * Palindrome.java
 * 
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 * 99. Find the largest
 * palindrome made from the product of two 3-digit numbers.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class Palindrome {
	
	//constructor
	private Palindrome() {
		
	}

	/**
	 * Function is used to largest palindrome that is a multiple of two 3 digit
	 * numbers
	 * 
	 * @return long 0|number largest palindrome number
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static int findLargestPalindrome() {
		final int max = 999;
		final int min = 100;
		int maxVal = 0;

		for (int i = max; i >= min; i--) {
			for (int j = max; j >= min; j--) {
				int p = i * j;
				if ((isPalindrome(p)) && (p > maxVal)) {
					maxVal = p;
				}
			}
		}
		return maxVal;
	}

	/**
	 * Check whether or not a given number is palindrome
	 * 
	 * @param int n number
	 * @return boolean
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static boolean isPalindrome(int number) {
		String originalString = String.valueOf(number);
		StringBuilder reverseString = new StringBuilder(originalString);
		return reverseString.reverse().toString().equals(originalString);
	}

}
