package com.lftechnology.java.training.sanish.multiplenumber;
/**
 * Provide functions to get multiples of number
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class MultiplierNumber {
	/**
	 * Return smaller multiple number form given range
	 * @param int form first number that have to find multiple
	 * @param int to last number that have to find multiple
	 * @return int smaller multiple number
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static int getSmallerMultipleNum(int form, int to) {
		int smallerMultipleNum = form;
		for (int i = form; i <= to; i++) {
			int sumNumber = smallerMultipleNum;
			while (sumNumber % i != 0) {
				sumNumber += smallerMultipleNum;
			}
			
			smallerMultipleNum = sumNumber;
		}
		return smallerMultipleNum;
	}
}
