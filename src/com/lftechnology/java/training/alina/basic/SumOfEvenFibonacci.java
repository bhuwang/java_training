package com.lftechnology.java.training.alina.basic;

/**
 * The SumOfEvenFibonacci program implements an application that simply
 * generates the sum of even fibonacci terms
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class SumOfEvenFibonacci {
	private final static int MAX_LIMIT = 4000000;
	private int firstNumber;
	private int secondNumber;

	/**
	 * Function used to set first and second numbers
	 * @param int firstNumber
	 * @param int secondNumber
	 */
	public SumOfEvenFibonacci(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	/**
	 * Function used to set first number 
	 * @param int firstNumber
	 */
	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	/**
	 * Function used to get first number
	 * @return int firstNumber
	 */
	public int getFirstNumber() {
		return firstNumber;
	}

	/**
	 * Function used to set second number
	 * @param int secondNumber
	 */
	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	/**
	 * Function used to get second number
	 * @return secondNumber
	 */
	public int getSecondNumber() {
		return secondNumber;
	}

	/**
	 * Function used to get sum of even fibonacci terms
	 * 
	 * @return int totalSum sum of even fibonacci
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public int getSumOfEvenFibonacci() {
		int totalEvenSum = 0;
		boolean exceed = false;

		if(this.firstNumber % 2 == 0){
			totalEvenSum +=firstNumber;
		}
		if(this.secondNumber % 2 == 0){
			totalEvenSum +=secondNumber;
		}
		
		while (!exceed) {
			int newNumber = this.firstNumber + this.secondNumber;
			this.firstNumber = this.secondNumber;
			this.secondNumber = newNumber;
		
			if (newNumber > MAX_LIMIT) {
				exceed = true;
				break;
			}
			if (newNumber % 2 == 0) {
				totalEvenSum += newNumber;
			}
		}
		return totalEvenSum;
	}
}
