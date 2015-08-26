
package com.lftechnology.java.training.krishna.basics.packageexecutejar;

/**
 * This program used to sum two integer numbers
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class AddNumber {

	private int firstNumber;
	private int secondNumber;

	public AddNumber(int firstNumber, int secondNumber) {

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

	@Override
	public String toString() {

		return "AddNumber [firstNumber=" + firstNumber + ", secondNumber=" +
			secondNumber + "]";
	}

	/**
	 * Calculate sum between two integer numbers
	 *
	 * @return sum {@link int}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public int sum() {

		int sum = this.firstNumber + this.secondNumber;
		return sum;
	}

}
