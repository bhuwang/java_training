package com.lftechnology.java.training.sanish.sumnumber;

/**
 * Provide functions to sum multiplies
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class SumMultiples {
	/**
	 * Return sum of multiples of number within given limit
	 * 
	 * @param int num number 
	 * @param int limit below which have to found sum of multiples of number
	 * @return int sum of multiples
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static int getMultiples(int num, int limit) {
		int maxMultipleNum = limit / num;
		return (maxMultipleNum * (maxMultipleNum + 1) / 2) * num;
	}
}
