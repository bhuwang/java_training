package com.lftechnology.java.training.dipak.guess;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Guessing a number game application: 
*application will generate a random no between 1 and 20. 
*user guess the value by entering from the console
*Check if the guess value matched with random number or not, if matched show the guessing value, random value and the no. of attempts.
*@author Dipak Thapa <dipakathapa@lftechnology.com> 
 */

public class GuessTheNumber {
	private final static Logger LOGGER = Logger.getLogger(GuessTheNumber.class.getName());
	private int theNumber;
	private int attempts = 0;
	private int lowerBound=0;
	private int upperBound=0;

	GuessTheNumber(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	/**
	 * <p>
	 * Generates the random number to be guessed.
	 * </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void generateNumber() {
		theNumber = (int) (Math.random() * upperBound + lowerBound);
	}

	/**
	 * <p>
	 * This method generates the random number to be guessed.
	 * </p>
	 * 
	 * @param num
	 * @return true if guessed number matches the random number else false
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public boolean checkGuess(int num) {
		attempts++;
		if (num == theNumber) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		LOGGER.info("Welcome to Guessing game");
		int upperBound = 20;
		int lowerBound = 1;
		GuessTheNumber gtn1 = new GuessTheNumber(lowerBound, upperBound);
		gtn1.generateNumber();
		Scanner sc = new Scanner(System.in);
		int guessedNumber;
		try {
			for (;;) {
				for (;;) {
					LOGGER.info("Make the guess(1-20) or Press 0 or any number(< 0) to quit::");
					try {
						guessedNumber = Integer.parseInt(sc.nextLine());
						break ;
					} catch (NumberFormatException nfe) {
						gtn1.attempts++;
						LOGGER.info("Characters entered.Re-enter the values.");
					}
				}
				if (guessedNumber <= 0) {
					LOGGER.log(Level.INFO,"So you quit...");
					LOGGER.log(Level.INFO,"The number was:: {0} ", gtn1.theNumber);
					LOGGER.log(Level.INFO,"Number of Attempts made:: {0} ", gtn1.attempts);
					break;
				}
				boolean result = gtn1.checkGuess(guessedNumber);
				if (result) {
					LOGGER.log(Level.INFO,"The number was:: {0} ", gtn1.theNumber);
					LOGGER.log(Level.INFO,"Number of Attempts made:: {0} ", gtn1.attempts);
					break;
				}else{
					LOGGER.log(Level.INFO,"Oops... Missed. Try again");
				}

			}
		} catch (Exception e) {
			LOGGER.info("Exception occurred");
		} finally {
			sc.close();
		}

	}
}
