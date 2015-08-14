package com.lftechnology.java.training.krishna.basics.evenfibonacci;

/**
 * EvenFibonacci.java
 * 
 * The EvenFibonacci program implements an application that simply sum of the even-valued terms
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class EvenFibonacci {
	private int firstNumber;
	private int secondNumber;
	private final static int MAX_LIMIT = 4000000;

	public EvenFibonacci(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public int getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	/**
	 * <p>
	 * Function is used to generate even fibonacci with sum upto 4 million
	 * </p>
	 * 
	 * @return int sum sum of even number
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public int sumEvenFibonacci() {

		int sum = 0;
		while (sum < MAX_LIMIT) {
			sum += this.firstNumber;
			this.firstNumber = this.secondNumber;
			this.secondNumber = sum;

			if (sum % 2 == 0) {
				sum += sum;
			}
		}
		return sum;

	}
}
