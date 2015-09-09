
package com.lftechnology.java.training.dipak.filesassignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program reads a file using scanner then converts all the texts present in it to upper
 * case.
 * 
 * @author Dipak Thapa <dipakthapa@lftechnology.com> *
 */
public class ConvertTextsFromFileToUpperCase {

	private static final Logger LOGGER =
		Logger.getLogger(ConvertTextsFromFileToUpperCase.class.getName());
	
	private ConvertTextsFromFileToUpperCase() {
		
	}
	/**
	 * This method reads file and converts it into upper case and displays in the console.
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void convertToUpperCase() {
		File file=new File("src/com/lftechnology/java/training/dipak/filesassignments/Files/file3.txt");
		try (Scanner sc=new Scanner(file)) {
			while(sc.hasNextLine()) {
				String str=sc.nextLine();
				LOGGER.log(Level.INFO,"{0}",str.toUpperCase());
								
			}
			
		}catch(NoSuchElementException ne) {
			LOGGER.log(Level.INFO,"{0}",ne);
		}
		catch (FileNotFoundException e) {
			LOGGER.log(Level.INFO,"{0}",e);
		}
	}

	public static void main(String[] args) {

		ConvertTextsFromFileToUpperCase cu =
			new ConvertTextsFromFileToUpperCase();
		
		cu.convertToUpperCase();
	}

}
