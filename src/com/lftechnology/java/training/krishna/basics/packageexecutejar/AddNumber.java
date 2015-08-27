
package com.lftechnology.java.training.krishna.basics.packageexecutejar;

/**
 * This program used to sum two integer numbers
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class AddNumber {

	private int firstDigit;
	private int secondDigit;

	public AddNumber(int firstDigit, int secondDigit) {

		this.firstDigit = firstDigit;
		this.secondDigit = secondDigit;
	}

	public int getFirstDigit() {

		return firstDigit;
	}

	public void setFirstDigit(int firstDigit) {

		this.firstDigit = firstDigit;
	}

	public int getSecondDigit() {

		return secondDigit;
	}

	public void setSecondDigit(int secondDigit) {

		this.secondDigit = secondDigit;
	}

	@Override
	public String toString() {

		return "AddNumber [firstDigit=" + firstDigit + ", secondDigit=" +
			secondDigit + "]";
	}

	/**
	 * Calculate sum between two integer numbers
	 *
	 * @return sum {@link int}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public int sum() {

		int sum = this.firstDigit + this.secondDigit;
		return sum;
	}

}
