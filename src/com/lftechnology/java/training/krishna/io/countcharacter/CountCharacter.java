
package com.lftechnology.java.training.krishna.io.countcharacter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program count the no. of character occurrence on given file
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class CountCharacter {

	private static final Logger LOGGER =
		Logger.getLogger(CountCharacter.class.getName());

	private String filePath;
	private char inputCharacter;

	public CountCharacter(String filePath, char inputCharacter) {

		this.filePath = filePath;
		this.inputCharacter = inputCharacter;
	}

	public String getFilePath() {

		return filePath;
	}

	public void setFilePath(String filePath) {

		this.filePath = filePath;
	}

	public char getInputCharacter() {

		return inputCharacter;
	}

	public void setInputCharacter(char inputCharacter) {

		this.inputCharacter = inputCharacter;
	}

	@Override
	public String toString() {

		return "CountCharacter [filePath=" + filePath + ", inputCharacter=" +
			inputCharacter + "]";
	}

	/**
	 * This method computes the no. of character occurrence from given file.
	 * 
	 * @return count {@link int} no. of character occurrence
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public int countCharacterOccurance() {

		BufferedReader reader = null;
		int count = 0;
		try {
			Reader file = new FileReader(getFilePath());
			reader = new BufferedReader(file);
			count = readCharacter(reader);
		}
		catch (IOException ex) {
			LOGGER.log(Level.INFO, "IOException Information: {0}", ex);
		}
		finally {
			try {
				reader.close();
			}
			catch (IOException ex) {
				LOGGER.log(Level.INFO, "IOException Information: {0}", ex);
			}

		}

		return count;
	}
	/**
	 * This method reads the no. of character occurrence from buffer.
	 * 
	 * @param reader {@link BufferedReader}
	 * @return count {@link int} no. of character occurrence
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private int readCharacter(BufferedReader reader) throws IOException{
		int count = 0;
		String line = null;
		while ((line = reader.readLine()) != null) {
			for (int i = 0; i < line.length(); i++) {
				if (inputCharacter == line.charAt(i)) {
					count++;
				}
			}
		}
		return count;
	}

}