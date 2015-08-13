package com.lftechnology.java.training.sanish.palindrome;

import java.util.logging.Logger;
import java.util.logging.Level;
/**
 * Class Main
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	private static final int DIGIT_NUM = 3;
	
	public static void main(String args[]){
		try {
			LOGGER.log(Level.INFO, "Largest palindrome made from the product of two {0}-digit numbers: {1}", new Object[] {DIGIT_NUM, Palindrome.getLargestPalindrome(DIGIT_NUM)});
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Exception : {1}", new Object[] {e.getMessage()});
		}
	}
}
