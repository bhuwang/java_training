package com.lftechnology.java.training.srijan.basics.javaio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CharacterDataHandler {
	private String inputString;
	private String inputCharacter;
	private int count;
	private static final Logger LOGGER = Logger.getLogger(CharacterDataHandler.class.getName());

	public CharacterDataHandler(String inputString, String inputCharacter) {
		this.inputString = inputString;
		this.inputCharacter = inputCharacter;
		this.count = 0;
	}
/**
 * <p>Handles all the operation of the application</p>
 * @author srijan
 */
	public void dataHandler() {
		try {
			displayInputString();
			writeInFile();
			readFromFile();
		} catch (FileNotFoundException e) {
			LOGGER.info("FileNotFoundException:" + e);
		}catch(Exception ex){
			LOGGER.info("Exception:" + ex);
		}
	}
	
	/**
	 * <p>Displays the user input string and character</p>
	 * @author srijan
	 */
	public void displayInputString() {
		LOGGER.info("string:" + this.inputString);
		LOGGER.info("Character:" + this.inputCharacter);
	}
	
	/**
	 * <p>Writes user input string to the file</p>
	 * @throws FileNotFoundException
	 * @author srijan
	 */
	public void writeInFile() throws FileNotFoundException {
		PrintWriter fileWrite = new PrintWriter("file.txt");
		fileWrite.println(inputString);
		fileWrite.flush();
		fileWrite.close();
	}
	
	/**
	 * <p>
	 * Reads from file and compare each character of file with user input
	 * character
	 * </p>
	 * 
	 * @throws FileNotFoundException
	 * @author srijan
	 */
	public void readFromFile() throws FileNotFoundException {
		FileReader fileRead = new FileReader("file.txt");
		int fileString;
		try {
			fileString = fileRead.read();
			while (fileString != -1) {
				if (inputCharacter.equals(String.valueOf((char) (fileString)))) {
					count++;
				}
				fileString = fileRead.read();
			}
			fileRead.close();
		} catch (IOException e) {
			LOGGER.info("IOException" + e);
		}
		LOGGER.log(Level.INFO, "The character {0} is repeated {1} times", new Object[] { inputCharacter, count });
	}
}
