package com.lftechnology.java.training.srijan.basics.javaio1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * A file which has some int value among with other string value . Write a
 * program that gets the int piece of data. What is the int data?
 * 
 * @author srijan
 *
 */
public class IntegerReader {

	private static final Logger LOGGER = Logger.getLogger(IntegerReader.class.getName());

	private IntegerReader() {

	}

	public static void main(String[] args) {
		readFile();

	}

	/**
	 * <p>
	 * Reads file inputfile.txt one character at a time
	 * </p>
	 * 
	 * @author srijan
	 */
	public static void readFile() {
		try {
			FileReader readFromFile = new FileReader("inputfile.txt");
			readIntegerFromFile(readFromFile);
		} catch (FileNotFoundException e) {
			LOGGER.info("File not found exception: " + e);
		}
	}

	/**
	 * <p>
	 * Displays integer present in file
	 * </p>
	 * 
	 * @param readFromFile
	 */
	public static void readIntegerFromFile(FileReader readFromFile) {
		int integerInFile = 0;
		try {
			integerInFile = readFromFile.read();
			LOGGER.info("Integer present in file");
			while (integerInFile != -1) {
				if (integerInFile >= 48 && integerInFile <= 57) {
					LOGGER.info(" " + (char) integerInFile);
				}
				integerInFile = readFromFile.read();
			}
			readFromFile.close();
		} catch (IOException e) {
			LOGGER.info("exception" + e);
		}
	}
}
