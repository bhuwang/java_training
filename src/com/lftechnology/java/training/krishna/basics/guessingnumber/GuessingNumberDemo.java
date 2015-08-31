
package com.lftechnology.java.training.krishna.basics.guessingnumber;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * GuessingNumberDemo.java 
 * 
 * Log the output on the console.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class GuessingNumberDemo {

	private static final Logger LOGGER =
		Logger.getLogger(GuessingNumberDemo.class.getName());
	private static final int MIN = 1;
	private static final int MAX = 20;

	//constructor
	private GuessingNumberDemo() {

	}
	/**
	 * This is the main method.
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void main(String[] args) {

		try {
			Scanner scanner = new Scanner(System.in);

			int secretNumber = GuessingNumber.randomInteger(MIN, MAX);
			guessNumber(scanner, secretNumber);
			scanner.close();
		}
		catch (NumberFormatException e) {
			LOGGER.log(
				Level.WARNING, "NumberFormatException Message : {0}",
				e.getMessage());
		}
	}

	/**
	 * This method is used to set guess number from user
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @param secretNumber
	 *            {@link int}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void guessNumber(Scanner scanner, int secretNumber) {

		int guess;
		int noOfAttempts = 0;

		do {
			LOGGER.log(Level.INFO, "Please enter a guess number: ");
			while (!scanner.hasNextInt()) {
				LOGGER.log(Level.WARNING, "It is not a number. Please try again.");
				scanner.next();
			}
			guess = scanner.nextInt();
			noOfAttempts++;
			if (guess == secretNumber) {
				LOGGER.log(
					Level.INFO, "Your guess is correct. Congratulations!");
				LOGGER.log(
					Level.INFO,
					"Secret Number: {0} Guess Number: {1} No. of attempts: {2}",
					new Object[] {
						secretNumber, guess, noOfAttempts
					});
			}
			else if (guess < secretNumber) {
				LOGGER.log(
					Level.INFO, "Your guess is smaller than the secret number.");

			}
			else if (guess > secretNumber) {
				LOGGER.log(
					Level.INFO, "Your guess is greater than the secret number.");

			}
		}
		while (guess != secretNumber);
	}

}
