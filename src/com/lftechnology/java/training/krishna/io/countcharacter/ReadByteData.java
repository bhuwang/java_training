
package com.lftechnology.java.training.krishna.io.countcharacter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program reads the file using byte stream
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class ReadByteData {

	private static final Logger LOGGER =
		Logger.getLogger(ReadByteData.class.getName());

	//constructor
	private ReadByteData() {

	}

	/**
	 * This method read and write file using byte stream.
	 * 
	 * @param inputStream
	 *            {@link FileInputStream}
	 * @param outputStream
	 *            {@link FileOutputStream}
	 * @throws IOException
	 *             if an I/O error occurs
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void readByte(
		FileInputStream inputStream, FileOutputStream outputStream)
		throws IOException {

		int c;
		while ((c = inputStream.read()) != -1) {
			LOGGER.log(Level.INFO, "Read Byte: {0}", new Object[] {
				c
			});
			outputStream.write(c);
		}
	}

	/**
	 * This method release fileinputstream and fileoutputstream resource.
	 * 
	 * @param inputStream
	 *            {@link FileInputStream}
	 * @param outputStream
	 *            {@link FileOutputStream}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void closeResource(
		FileInputStream inputStream, FileOutputStream outputStream) {

		if (inputStream != null) {
			try {
				inputStream.close();
			}
			catch (IOException e) {
				LOGGER.log(Level.INFO, "IOException Information: {0}", e);
			}
		}
		if (outputStream != null) {
			try {
				outputStream.close();
			}
			catch (IOException e) {
				LOGGER.log(Level.INFO, "IOException Information: {0}", e);
			}

		}

	}
}
