package com.lftechnology.java.training.alina.basic.guessnumber;

import java.util.Scanner;
import java.util.logging.Level;
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
		int maxLimit = 20;
		int minLimit = 1;
		try (Scanner scanner = new Scanner(System.in)) {
			NumberGuessingGame number = new NumberGuessingGame();
			randomNumber = Randomize.generateRandomNumber(minLimit,maxLimit);
			number.checkForGuessNumber(scanner, randomNumber);
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Exception Message : {0}", new Object[] {e});
		}
	}

	/**
	 * Function to check for guessed and random number Displays the output when
	 * guess is matched
	 * 
	 * @param scanner
	 * @param randomNumber
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private void checkForGuessNumber(Scanner scanner, int randomNumber) {
		int guessNumber;
		int numberOfAttempts = 0;
		do {
			LOGGER.info("Enter a guess number (1-20): ");
			guessNumber = scanner.nextInt();
			numberOfAttempts++;
			if (guessNumber == randomNumber) {
				LOGGER.info("Your Guess is Correct. Congratulations!");
				LOGGER.log(Level.INFO, "Random generated value is : {0}", new Object[] { randomNumber });
				LOGGER.log(Level.INFO, "Guessed value is : {0}", new Object[] { guessNumber });
				LOGGER.log(Level.INFO, "Number of attempts : {0}", new Object[] { numberOfAttempts });
			} else if (guessNumber < randomNumber) {
				LOGGER.info("Your Guess is incorrect. It should be greater.");
			} else {
				LOGGER.info("Your Guess is incorrect. It should be smaller.");
			}
		} while (guessNumber != randomNumber);
	}

	
}
