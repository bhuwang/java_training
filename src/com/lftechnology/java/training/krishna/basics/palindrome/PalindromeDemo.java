package com.lftechnology.java.training.krishna.basics.palindrome;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * PalindromeDemo.java
 * 
 * Log the output on the console.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */

public class PalindromeDemo {
	private static final Logger LOGGER = Logger.getLogger(PalindromeDemo.class.getName());

	// constructor
	private PalindromeDemo() {
		
	}


	/**
	 * This is the main method which makes use of findLargestPalindrome() method.
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void main(String[] args) {
		Integer largestPalindrome = Palindrome.findLargestPalindrome();
		LOGGER.log(Level.INFO, "Largest Palindrome : {0}", new Object[]{largestPalindrome.toString()});
	}

}
