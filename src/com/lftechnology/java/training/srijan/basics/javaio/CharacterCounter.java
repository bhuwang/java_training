package com.lftechnology.java.training.srijan.basics.javaio;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Write an example that counts the number of times a particular character, such
 * as e, appears in a file. The character can be specified at the command line.
 * 
 * @author srijan
 *
 */
public class CharacterCounter {
	private static final Logger LOGGER = Logger.getLogger(CharacterCounter.class.getName());

	private CharacterCounter() {

	}

	public static void main(String[] args) {
		Scanner input = null;
		String inputString = "";
		String inputCharacter = "";
		try {
			input = new Scanner(System.in);
			LOGGER.info("Input a String:");
			inputString = input.nextLine();
			LOGGER.info("input character to check in a file");
			inputCharacter = input.nextLine();
			CharacterDataHandler characterHandler = new CharacterDataHandler(inputString, inputCharacter);
			characterHandler.dataHandler();
		} catch (Exception ex) {
			LOGGER.info("Exception is" + ex);
		} finally {
			input.close();
		}
	}
}
