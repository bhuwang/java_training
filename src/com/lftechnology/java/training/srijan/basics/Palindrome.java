package com.lftechnology.java.training.srijan.basics;

import java.util.logging.Logger;

/**
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99. Find the largest
 * palindrome made from the product of two 3-digit numbers.
 * 
 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
 */

public class Palindrome {
	private int number1;
	private int number2;

	private static final Logger LOGGER = Logger.getLogger(Palindrome.class.getName());

	public Palindrome(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}

	public void setRange(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}

	public int getFirstNumber() {
		return number1;
	}

	public int getLastNumber() {
		return number2;
	}

	/**
	 * <p>
	 * Calculates product of all 3 digit numbers and sends result for palindrome
	 * check
	 * </p>
	 * @param number1 {@link Integer}
	 * @param number2 {@link Integer}        
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */

	public void calculatePalindrome(int number1, int number2) {
		int product;
		int count = 0;
		int[] palindromeStorage = new int[10000];
		for (int i = number1; i <= number2; i++) {
			for (int j = number1; j <= number2; j++) {
				product = i * j;
				boolean result = checkPalindrome(product);

				if (result) {

					LOGGER.info("The Palindrome numbers are:" + product);
					palindromeStorage[count++] = product;
				}
			}
		}
		int largestPalindrome = calculateLargestPalindrome(palindromeStorage, count);

		LOGGER.info("The Largest Palindrome =" + largestPalindrome);
	}
	

	/**
	 * <p>
	 * Palindrome numbers are checked and boolean result is returned
	 * </p>
	 * 
	 * @param product {@link Integer}
	 *            
	 * @return boolean {@link Boolean}
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	

	public boolean checkPalindrome(int product) {
		int number;
		int temp;
		int sum = 0;
		number = product;
		do {
			temp = product % 10;
			sum = sum * 10 + temp;
			product = product / 10;
		} while (product > 0);

		if (number == sum)
			return true;
		else
			return false;
	}

	/**
	 * <p>
	 * Calculates largest palindrome
	 * </p>
	 * @param product[] {@link Array}          
	 * @param count {@link Integer}            
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */

	public int calculateLargestPalindrome(int[] product, int count) {
		int largestPalindrome = 0;
		for (int i = 0; i < count; i++) {
			if (largestPalindrome < product[i]) {
				largestPalindrome = product[i];
			}
		}
		return largestPalindrome;
	}
}
