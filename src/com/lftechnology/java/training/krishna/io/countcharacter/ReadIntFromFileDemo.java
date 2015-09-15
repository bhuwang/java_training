
package com.lftechnology.java.training.krishna.io.countcharacter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A file which has some int value among with other string value . Write a program that gets the int piece of data. What is the int data?
 */

/**
 * This program display integer data from file
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class ReadIntFromFileDemo {

	private static final Logger LOGGER =
		Logger.getLogger(ReadIntFromFileDemo.class.getName());
	private static final String INT_FILE_PATH =
		"/home/krishna/Projects/JAVA-PROJECT/java_training_aug_2015/main/resources/stringwithint.txt";

	// constructor
	private ReadIntFromFileDemo() {

	}

	public static void main(String[] args) {

		try {
			BufferedReader myReader = ReadIntFromFile.openFile(INT_FILE_PATH);
			List<Integer> intList = ReadIntFromFile.readLine(myReader);
			String content = ReadIntFromFile.readFile(INT_FILE_PATH);
			LOGGER.log(Level.INFO, "File Content: {0}", new Object[] {
				content
			});
			LOGGER.log(Level.INFO, "Integer List: {0}", new Object[] {
				intList
			});
			ReadIntFromFile.closeFile(myReader);
		}
		catch (FileNotFoundException ex) {
			LOGGER.log(Level.INFO, "FileNotFoundException Information: {0}", ex);
		}
		catch (IOException ex) {
			LOGGER.log(Level.INFO, "IOException Information: {0}", ex);
		}
	}

}
