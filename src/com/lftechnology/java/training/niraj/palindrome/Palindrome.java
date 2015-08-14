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
	public boolean isPalindrome(long num) {
		long reverse = reverseNumber(num);
		return (num == reverse);
	}

	/**
	 * Reverses the number
	 * 
	 * @param num
	 *            {@link Long}
	 * @return {@link Long}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public long reverseNumber(long num) {
		long number = num;
		long temp;
		long reverse = 0;
		while (number > 0) {
			temp = number % 10;
			reverse = reverse * 10 + temp;
			number = number / 10;
		}
		return reverse;
	}

	/**
	 * Get the largest palindrome number from the product of two digits between
	 * min and max limit
	 * 
	 * @return{@link Integer} largest palindrome number from product of two
	 *               digits between min and max limit
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public long getLargestPalindrome() {
		long largestPalindrome = 0;
		long product;
		for (int i = maxLimit; i >= minLimit; i--) {
			for (int j = maxLimit; j >= minLimit; j--) {
				product = i * j;
				if (isPalindrome(product) && (product > largestPalindrome)) {
					largestPalindrome = product;
					break;
				}
			}
		}
		return largestPalindrome;
	}

}
