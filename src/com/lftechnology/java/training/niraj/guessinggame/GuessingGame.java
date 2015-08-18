package com.lftechnology.java.training.niraj.guessinggame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Helper class containing helper methods related to guessing number game
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class GuessingGame {
	private static final Logger LOGGER = Logger.getLogger(GuessingGame.class
			.getName());
	private int guessedNumber;
	private int noOfAttempts;

	public GuessingGame(int minNum, int maxNum) {
		int randomNumber = getRandomNumber(minNum, maxNum);
		setGuessedNumber(randomNumber);
	}

	public int getNumberOfAttempts() {
		return noOfAttempts;
	}

	public int getGuessedNumber() {
		return guessedNumber;
	}

	public void setGuessedNumber(int guessedNumber) {
		this.guessedNumber = guessedNumber;
	}

	/**
	 * Get a random number between min and max number
	 * 
	 * @param minNum
	 *            {@link Integer}
	 * @param maxNum
	 *            {@link Integer}
	 * @return {@link Integer} random number between min and max number
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	private static int getRandomNumber(int minNum, int maxNum) {
		Random random = new Random();
		return random.nextInt((maxNum - minNum) + 1) + minNum;
	}

	/**
	 * Check if the guessed number is correct
	 * 
	 * @param num
	 *            {@link Integer}
	 * @return {@link Boolean}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public boolean checkGuessedNumber(int num) {
		noOfAttempts++;
		return guessedNumber == num;
	}

	/**
	 * Start the game by getting the users input and checks if it is correct
	 * 
	 * @param scanner
	 *            {@link Scanner}
	 * @throws InputMismatchException
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public void startGame(Scanner scanner) throws InputMismatchException {
		int numberGuessed;
		while (true) {
			if (!scanner.hasNextInt()) {
				LOGGER.log(Level.WARNING,
						"It's not a number. Please try again: ");
				scanner.next();
			}
			numberGuessed = scanner.nextInt();
			if (this.checkGuessedNumber(numberGuessed)) {
				break;
			} else {
				LOGGER.log(Level.INFO,
						"Your guess is not correct. Please try again: ");
			}
		}
		LOGGER.log(
				Level.INFO,
				"Congratulations !!! You have guessed a correct number in : {0} attempts",
				this.getNumberOfAttempts());
	}

}
