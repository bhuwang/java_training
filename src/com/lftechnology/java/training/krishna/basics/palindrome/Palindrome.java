package com.lftechnology.java.training.krishna.basics.palindrome;

public class Palindrome {

	/**
	 * Function is used to largest palindrome that is a multiple of two 3 digit numbers
	 * 
	 * @return long 0|number largest palindrome number
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static int findLargestPalindrome() {
		final int MAX = 999;
		final int MIN = 100;
		int max = 0;

		for (int i = MAX; i >= MIN; i--) {
			for (int j = MAX; j >= MIN; j--) {
				int p = i * j;
				if ((isPalindrome(p)) && (p > max)) {
					max = p;
				}
			}
		}
		return max;
	}

	/**
	 * Check whether or not a given number is palindrome
	 * 
	 * @param int n number
	 * @return boolean
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static boolean isPalindrome(int number) {
		String s = String.valueOf(number);
		StringBuilder reverseString = new StringBuilder();

		// reverse the string
		for (int i = s.length() - 1; i > -1; i--) {
			reverseString.append(s.charAt(i));
		}

		return reverseString.toString().equals(s);
	}

}
