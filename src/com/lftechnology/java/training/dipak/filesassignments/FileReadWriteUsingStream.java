
package com.lftechnology.java.training.dipak.filesassignments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * This program reads byte data from a file from an InputStream and displays it in console and writes each byte to a file using OutputStream.
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 *
 */
public class FileReadWriteUsingStream {

	private static final Logger LOGGER =
		Logger.getLogger(FileReadWriteUsingStream.class.getName());
	private FileReadWriteUsingStream() {
		
	}
	
	/**
	 * This method reads byte from file using InputStream and writes into another file using OutputStream.
	 * @return true if the read write operation is successful else false
	 */
	public boolean readWriteFile() {

		try (FileInputStream ir = new FileInputStream("src/com/lftechnology/java/training/dipak/filesassignments/Files/file1.txt");
						FileOutputStream fo =
							new FileOutputStream("src/com/lftechnology/java/training/dipak/filesassignments/Files/file2.txt")) {
			int dataValue = ir.read();
			while (dataValue != -1) {
				fo.write(dataValue);
				LOGGER.log(Level.INFO,"{0}",(char)dataValue);
				dataValue=ir.read();
			}
		}
		catch (FileNotFoundException fne) {
			LOGGER.log(Level.INFO, "Exception ::", fne);
			return false;
		}
		catch (IOException ioe) {
			LOGGER.log(Level.INFO, "Exception ::", ioe);
			return false;
		}

		return true;
	}

	public static void main(String[] args) {

		FileReadWriteUsingStream frw = new FileReadWriteUsingStream();
		boolean check = frw.readWriteFile();
		LOGGER.log(Level.INFO, "File read write successful ? -->{0}", check);
	}

}
