package com.lftechnology.java.training.alina.basic;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Write a Guessing a number game application: application will generate a
 * random no between 1 and 20. user guess the value by entering from the console
 * Check if the guess value matched with random number or not, if matched show
 * the guessing value, random value and the no. of attempts.
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 *
 */
public class NumberGuessingGame {

	private static final Logger LOGGER = Logger.getLogger(NumberGuessingGame.class.getName());

	public static void main(String[] args) {
		int randomNumber;
		int guessNumber;
		int numberOfAttempts = 0;
		Scanner scanner = null;
		try {
			NumberGuessingGame number = new NumberGuessingGame();
			randomNumber = number.generateRandomNumber();
			scanner = new Scanner(System.in);
			do {
				LOGGER.info("Enter a guess number (1-20): ");
				guessNumber = scanner.nextInt();
				if (guessNumber != randomNumber) {
					numberOfAttempts++;
				}
				if (guessNumber == randomNumber) {
					LOGGER.info("Your Guess is Correct. Congratulations!");
					LOGGER.info("Random generated value is : " + randomNumber);
					LOGGER.info("Guessed value is : " + guessNumber);
					LOGGER.info("Number of attempts : " + numberOfAttempts);
				} else if (guessNumber < randomNumber) {
					LOGGER.info("Your Guess is incorrect. It should be greater.");
				} else {
					LOGGER.info("Your Guess is incorrect. It should be smaller.");
				}
			} while (guessNumber != randomNumber);
		} catch (Exception e) {
			LOGGER.warning("Exception Message : " + e.getMessage());
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

	/**
	 * Function that generates the random number
	 * 
	 * @return randomGeneratedNumber random number
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public int generateRandomNumber() {
		int randomGeneratedNumber = (int) (Math.random() * 20 + 1);
		return randomGeneratedNumber;
	}
}
