
package com.lftechnology.java.training.srijan.basics.inputstreamjavaio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>The first programming exercise is to write a simple program which reads
 * byte data from a file from an InputStream and display it in console and
 * writes each byte to a file using OutputStream.</p>
 * 
 * @author leapfrog
 */
public class ByteReader {

	private static final Logger LOGGER =
		Logger.getLogger(ByteReader.class.getName());

	private ByteReader() {

	}

	public static void main(String[] args) {

		Boolean writeStatus = false;
		writeStatus = readAndWriteByteInFile();
		if (writeStatus.equals(true)) {
			LOGGER.log(Level.INFO, "Successfully written in file");
		}
		else {
			LOGGER.log(Level.INFO, "Problem while writing in file");
		}
	}

	public static Boolean readAndWriteByteInFile() {

		Boolean fileWriteStatus = false;
		FileOutputStream outputStream = null;
		InputStream inputStream = null;
		File file;
		try {
			inputStream = new FileInputStream("byteInput.txt");
			file = new File("byteOutput.txt");
			outputStream = new FileOutputStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			int data = inputStream.read();
			while (data != -1) {
				outputStream.write((char) data);
				data = inputStream.read();
				if (data == -1) {
					fileWriteStatus = true;
				}
			}
		}
		catch (FileNotFoundException e) {
			LOGGER.log(Level.INFO, "Exception {0}", e);
		}
		catch (IOException ex) {
			LOGGER.log(Level.INFO, "Exception: {0}", ex);
		}
		finally {
			try {
				outputStream.flush();
				inputStream.close();
				outputStream.close();
			}
			catch (IOException e) {
				LOGGER.log(Level.INFO, "IOException {0}", e);
			}
		}
		return fileWriteStatus;
	}
}
