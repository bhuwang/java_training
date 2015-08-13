package com.lftechnology.java.training.sanish.fibonacci;

/**
 * Provide functions to operate with fibonacci number
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class FibonacciNumber {
	/**
	 * Return sum 0f event fibonacci number with in given max limit
	 * 
	 * @param firstNum {@link Integer} first number of fibonacci number series 
	 * @param secondNum {@link Integer} second number of fibonacci number series 
	 * @param maxFibonacciNum {@link Integer} maximum fibonacci number
	 * @return {@link Integer}
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static int sumEventFibonacciNumber(int firstNum, int secondNum, int maxFibonacciNum){
		int nextNum = firstNum + secondNum;
		int eventFibonacciNumSum = 0;
		if(firstNum % 2 == 0){
			eventFibonacciNumSum +=firstNum;
		}
		
		if(secondNum % 2 == 0){
			eventFibonacciNumSum +=secondNum;
		}

		while(nextNum < maxFibonacciNum){
			if(nextNum % 2 == 0){
				eventFibonacciNumSum += nextNum;
			}
			
			firstNum = secondNum;
			secondNum = nextNum;
			nextNum = firstNum + secondNum;
		}
		
		return eventFibonacciNumSum;
	}
}
