package com.lftechnology.java.training.srijan.basics.javadoc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * a. Create a Java application PrintNumber which prints number from 1-10. b.
 * Create Executable Jar c. Run java application from command line. d. Print
 * numbers e. Create JavaDoc of Application
 * </p>
 * 
 * @author srijan
 *
 */
public class PrintNumbers {
	private int numbersToPrint;
	private static final Logger LOGGER = Logger.getLogger(PrintNumbers.class.getName());

	public PrintNumbers() {
		this.numbersToPrint = 10;
	}

	/**
	 * <p>
	 * Displays numbers from 1 to user input number
	 * </p>
	 * 
	 * @author srijan
	 */
	public void displayNumber() {
		for (int i = 1; i <= this.numbersToPrint; i++) {
			LOGGER.log(Level.INFO, "The numbers are: {0}", new Object[] { i });
		}
	}

	public static void main(String[] args) {
		PrintNumbers numbers = new PrintNumbers();
		numbers.displayNumber();
	}
}
