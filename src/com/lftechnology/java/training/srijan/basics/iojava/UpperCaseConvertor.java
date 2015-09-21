
package com.lftechnology.java.training.srijan.basics.iojava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 * <p>Write a program which reads input one line at a time using a Scanner and
 * prints it out converted to upper case.</p>
 * 
 * @author Srijan
 */
public class UpperCaseConvertor {
	
	private UpperCaseConvertor(){
		
	}
	
	private static final Logger LOGGER =
		Logger.getLogger(UpperCaseConvertor.class.getName());

	public static void main(String[] args){
		String line = "";
		File file = new File("inputfile.txt");
		Scanner input = null;
		PrintWriter printWriter = null;
		try {
			input = new Scanner(file);
			printWriter = new PrintWriter("outputfile.txt");
			while(input.hasNextLine()){
				line = input.nextLine();
				LOGGER.log(Level.INFO, line.toUpperCase());
				printWriter.println(line.toUpperCase());
			}
		}
		catch (FileNotFoundException e) {
			LOGGER.log(Level.INFO, "Exception {0}", e);
		}finally{
			printWriter.close();
			input.close();
		}
		LOGGER.log(Level.INFO, "All lines have been Successfully changed into uppercase");
	}
}
