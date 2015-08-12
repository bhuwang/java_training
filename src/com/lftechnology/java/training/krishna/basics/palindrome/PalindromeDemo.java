package com.lftechnology.java.training.krishna.basics.palindrome;

import java.util.logging.Logger;

/**
 * Log the output on the console.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */

public class PalindromeDemo {
	private final static Logger LOGGER = Logger.getLogger(PalindromeDemo.class
			.getName());

	/**
	 * This is the main method which makes use of findLargestPalindrome() method.
	 * 
	 * @param args Unused.
	 * @return Nothing.
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void main(String[] args) {
		int largestPalindrome = Palindrome.findLargestPalindrome();
		LOGGER.info("Largest Palindrome : " + largestPalindrome);
	}

}
