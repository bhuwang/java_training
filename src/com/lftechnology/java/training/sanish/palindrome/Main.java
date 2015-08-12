package com.lftechnology.java.training.sanish.palindrome;

import java.util.logging.Logger;
/**
 * Class Main
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Main {
	public static void main(String args[]){
		final Logger LOGGER = Logger.getLogger(Main.class.getName());
		try {
			LOGGER.info("Largest palindrome made from the product of two 3-digit numbers: "+ Palindrome.getLargestPalindrome(6));
		} catch (Exception e) {
			LOGGER.warning("Exception : " + e.getMessage());
		}
	}
}
