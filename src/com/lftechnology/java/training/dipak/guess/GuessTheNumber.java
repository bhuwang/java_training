
package com.lftechnology.java.training.dipak.guess;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Guessing a number game application: application will generate a random no
 * between 1 and 20. user guess the value by entering from the console Check if
 * the guess value matched with random number or not, if matched show the
 * guessing value, random value and the no. of attempts.
 * 
 * @author Dipak Thapa <dipakathapa@lftechnology.com>
 */

public class GuessTheNumber {

	private static final Logger LOGGER =
		Logger.getLogger(GuessTheNumber.class.getName());
	private int theRandomNumber;
	private int attempts = 0;
	private int lowerBound = 0;
	private int upperBound = 0;

	GuessTheNumber(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	/**
	 * <p> Generates the random number to be guessed. </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void generateNumber() {

		Random random = new Random();
		theRandomNumber = random.nextInt(upperBound) + lowerBound;
	}

	/**
	 * <p> This method generates the random number to be guessed. </p>
	 * 
	 * @param num
	 * @return true if guessed number matches the random number else false
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public boolean checkGuess(int num) {

		attempts++;
		return num == theRandomNumber;

	}

	public static void main(String[] args) {

		LOGGER.info("Welcome to Guessing game");
		int upperBound = 20;
		int lowerBound = 1;
		GuessTheNumber gtn1 = new GuessTheNumber(lowerBound, upperBound);
		gtn1.generateNumber();
		int guessedNumber;
		Scanner sc = new Scanner(System.in);
		boolean closeResource = false;
		for (;;) {
			LOGGER.info(
				"Make the guess(1-20) or Press 0 or any number(< 0) to quit::");
			try {
				guessedNumber = Integer.parseInt(sc.nextLine());
				boolean result = gtn1.checkGuess(guessedNumber);
				if (guessedNumber <= 0 ) {
					LOGGER.log(Level.INFO, "So you quit...");
					LOGGER.log(
						Level.INFO, "The number was:: {0} ",
						gtn1.theRandomNumber);
					LOGGER.log(
						Level.INFO, "Number of Attempts made:: {0} ",
						gtn1.attempts);
					closeResource = true;
				}else if (result) {
					LOGGER.log(
						Level.INFO, "The number was:: {0} ",
						gtn1.theRandomNumber);
					LOGGER.log(
						Level.INFO, "Number of Attempts made:: {0} ",
						gtn1.attempts);
					closeResource = true;
				}
				else {
					LOGGER.log(Level.INFO, "Oops... Missed. Try again");
				}

			}
			catch (NumberFormatException nfe) {
				gtn1.attempts++;
				LOGGER.info("Oops.. Characters entered.Re-enter the values.");
			}
			finally {
				if (closeResource) {
					sc.close();
					break;
				}
			}
		}
	}
}
