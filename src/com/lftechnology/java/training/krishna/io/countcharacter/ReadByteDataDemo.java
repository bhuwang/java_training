
package com.lftechnology.java.training.krishna.io.countcharacter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * write a simple program which reads byte data from a file from an InputStream and display it in console and writes each byte to a file using OutputStream
 */
/**
 * This program read particular file using byte stream
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class ReadByteDataDemo {

	private static final Logger LOGGER =
		Logger.getLogger(ReadByteData.class.getName());
	private static final String FILE_IN_PATH =
		"/home/krishna/Projects/JAVA-PROJECT/java_training_aug_2015/main/resources/bytein.txt";
	private static final String FILE_OUT_PATH =
		"/home/krishna/Projects/JAVA-PROJECT/java_training_aug_2015/main/resources/byteout.txt";

	// constructor
	private ReadByteDataDemo() {

	}

	public static void main(String[] args) {

		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(FILE_IN_PATH);
			outputStream = new FileOutputStream(FILE_OUT_PATH);
			ReadByteData.readByte(inputStream, outputStream);
		}
		catch (IOException e) {
			LOGGER.log(Level.INFO, "IOException Information: {0}", e);
		}
		finally {
			ReadByteData.closeResource(inputStream, outputStream);
		}
	}
}
