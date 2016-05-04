
package com.lftechnology.java.training.dipak.filesassignments;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * This program gets the int piece of data from a file and displays it in the console.
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 */
public class GetAllIntValues {

	private static final Logger LOGGER =
		Logger.getLogger(GetAllIntValues.class.getName());
	private List<Integer> list = new ArrayList<>();
	
	private GetAllIntValues() {
		
	}
	/**
	 * This method checks whether a read character is integer or not.If it is integer value then its added to the list.
	 * @author Dipak Thapa <dipakthapa@lftechnology.com 
	 */
	public void getIntegerValues() {

		try (BufferedReader br =
			new BufferedReader(new FileReader("file1.txt"))) {
			int i = br.read();
			while (i != -1) {
				if (i >= 47 && i <= 57) {
					list.add(Integer.valueOf(String.valueOf((char)i)));
				}
				i = br.read();
			}
			
		}
		catch (FileNotFoundException fne) {
			LOGGER.log(Level.INFO, "Exception ::", fne);
			return;
		}
		catch (IOException ioe) {
			LOGGER.log(Level.INFO, "Exception ::", ioe);
			return;
		}

	}

	public static void main(String[] args) {

		GetAllIntValues gv = new GetAllIntValues();
		gv.getIntegerValues();

		LOGGER.log(
			Level.INFO, "The integer values present in the files are::{0}",
			gv.list);

	}

}
