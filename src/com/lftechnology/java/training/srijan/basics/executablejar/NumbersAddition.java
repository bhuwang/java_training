package com.lftechnology.java.training.srijan.basics.executablejar;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * a. Create a Java application AddNumber, which takes two number from User as a
 * argument and prints sum. (you should supply two values while running jar) b.
 * Create Executable Jar c. Run java application from command line which should
 * take values from user. d. Print sum e. Create JavaDoc of Application
 * </p>
 * 
 * @author srijan
 *
 */
public class NumbersAddition {
	private int sum;
	private int firstNumber;
	private int secondNumber;
	private static final Logger LOGGER = Logger.getLogger(NumbersAddition.class.getName());

	public NumbersAddition(int firstNumber, int secondNumber) {
		this.sum = 0;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public static void main(String[] args) {
		NumbersAddition add = new NumbersAddition(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		add.addNumbers();
		add.displayNumbers();
	}

	/**
	 * <p>
	 * Calculates sum of two numbers
	 * </p>
	 * 
	 * @author srijan
	 */
	public void addNumbers() {
		this.sum = this.firstNumber + this.secondNumber;
	}

	/**
	 * <p>
	 * Displays sum of two input integer numbers
	 * </p>
	 * 
	 * @author srijan
	 */
	public void displayNumbers() {
		LOGGER.log(Level.INFO, "The sum of {0} and {1} = {2}",
				new Object[] { this.firstNumber, this.secondNumber, this.sum });
	}
}
