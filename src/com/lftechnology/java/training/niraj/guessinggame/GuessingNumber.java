package com.lftechnology.java.training.niraj.guessinggame;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Game of guessing number
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class GuessingNumber {
	private static final Logger LOGGER = Logger.getLogger(GuessingNumber.class
			.getName());

	private GuessingNumber() {

	}

	public static void main(String[] args) {
		int minNum = 1;
		int maxNum = 20;
		try (Scanner scanner = new Scanner(System.in)) {
			LOGGER.log(Level.INFO, "Please guess a number between {0} and {1}",
					new Object[] { minNum, maxNum });
			GuessingGame game = new GuessingGame(minNum, maxNum);
			game.startGame(scanner);
		} catch (InputMismatchException e) {
			LOGGER.log(Level.WARNING, "Please provide a valid input");
		}

	}

}
