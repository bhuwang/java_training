package com.lftechnology.java.training.krishna.basics.palindrome;

import java.util.logging.Logger;


public class PalindromeDemo {
	private final static Logger LOGGER = Logger.getLogger(Palindrome.class.getName());
	public static void main(String[] args) {
		int largestPalindrome = Palindrome.findLargestPalindrome();
		LOGGER.info("Largest Palindrome : "  + largestPalindrome);
	}

}
