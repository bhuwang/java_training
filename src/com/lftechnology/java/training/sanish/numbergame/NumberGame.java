package com.lftechnology.java.training.sanish.numbergame;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumberGame {
	private static final Logger LOGGER = Logger.getLogger(NumberGame.class
			.getName());

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			startGuessNumber(scanner);
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Exception Message : {0}",
					new Object[] { e.getMessage() });
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

	/**
	 * Start guess number game
	 * 
	 * @param scanner
	 *            {@link Scanner}
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static void startGuessNumber(Scanner scanner) {
		Guess guess = new Guess();
		int guessNumber;
		LOGGER.log(Level.INFO, "Enter a guess number (1-20):");
		for (;;) {
			guessNumber = scanner.nextInt();
			try {
				guess.setGuessNum(guessNumber);
				if (guess.isMatchGuessNum()) {
					guess.showCorrectGuessMsg();
					scanner.close();
					break;
				} else {
					guess.showIncorrectGuessMsg();
				}
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, e.getMessage());
			}
		}
	}
}
