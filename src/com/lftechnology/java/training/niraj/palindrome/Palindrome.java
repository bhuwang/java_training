/**
 * 
 */
package com.lftechnology.java.training.niraj.palindrome;

/**
 * Helper class for functionality related to Palindrome
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class Palindrome {
	private int minLimit;
	private int maxLimit;

	public Palindrome(int minLimit, int maxLimit) {
		this.minLimit = minLimit;
		this.maxLimit = maxLimit;
	}

	/**
	 * Checks if the given number is palindrome
	 * 
	 * @param num
	 *            {@link Integer}
	 * @return {@link Boolean}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public boolean isPalindrome(Integer num) {
		String number = num.toString();
		StringBuilder reverseNumber = new StringBuilder();
		reverseNumber.append(number).reverse();
		return number.equals(reverseNumber.toString());
	}

	/**
	 * Get the largest palindrome number from the product of two digits between
	 * min and max limit
	 * 
	 * @return{@link {@link Integer} largest palindrome number from product of
	 *               two digits between min and max limit
	 *               
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>               
	 */
	public int getLargestPalindrome() {
		int largestPalindrome = 0;
		for (int i = minLimit; i <= maxLimit; i++) {
			for (int j = minLimit; j <= maxLimit; j++) {
				Integer product = i * j;
				if (isPalindrome(product) && product > largestPalindrome) {
					largestPalindrome = product;
				}
			}
		}
		return largestPalindrome;
	}

}
