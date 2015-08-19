package com.lftechnology.java.training.dipak.palindrom;

import java.util.logging.Logger;

/*
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 � 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class PalindromProduct {
	private static final Logger LOGGER = Logger.getLogger(PalindromProduct.class.getName());
	private int greatest = 0;
	private int num1;
	private int num2;
	private int startIndex;
	private int endIndex;

	PalindromProduct(int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	/**
	 * <p>
	 * This method determines the product of all the 3 digit numbers.
	 * </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */

	public void getProduct() {
		for (int i = startIndex; i <= endIndex; i++) {
			for (int j = startIndex; j <= endIndex; j++) {
				int product = i * j;
				if (checkPalindrom(product) && greatest < product) {
					num1 = i;
					num2 = j;
					greatest = product;
				}
			}
		}
	}

	/**
	 * <p>
	 * This method reverses the number and checks whether its palindrom or not
	 * </p>
	 * 
	 * @param product
	 * @return true if number is palindrom else false
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */

	public boolean checkPalindrom(int product) {
		int b = product;
		int temp = 0;
		int num = 0;
		while (b > 0) {
			temp = b % 10;
			num = num * 10 + temp;
			b = b / 10;
		}
		if (num == product) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		PalindromProduct pp1 = new PalindromProduct(100, 999);

		pp1.getProduct();
		LOGGER.info("The numbers are::" + pp1.num1 + " and " + pp1.num2);
		LOGGER.info("The palindrom number is::" + pp1.greatest);

	}

}
