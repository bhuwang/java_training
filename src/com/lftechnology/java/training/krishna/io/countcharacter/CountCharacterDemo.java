
package com.lftechnology.java.training.krishna.io.countcharacter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write an example that counts the number of times a particular character, such as e, appears in a file. The character can be specified at the command line. 
 */

/**
 * This program count the no. of character occurrence on particular file
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class CountCharacterDemo {

	private static final Logger LOGGER =
		Logger.getLogger(CountCharacterDemo.class.getName());
	private static final String FILE_PATH =
		"/home/krishna/Projects/JAVA-PROJECT/java_training_aug_2015/main/resources/test.txt";

	// constructor
	private CountCharacterDemo() {

	}

	public static void main(String[] args) {

		if (args.length != 1 || args[0].length() != 1) {
			LOGGER.log(Level.INFO, "Please enter only one character.");
			return;
		}

		char inputCharacter = args[0].charAt(0);
		int count =
			new CountCharacter(FILE_PATH, inputCharacter).countCharacterOccurance();

		LOGGER.log(
			Level.INFO, "Input Character: {0}  Count: {1}", new Object[] {
				inputCharacter, count
			});
	}
}
