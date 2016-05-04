package com.lftechnology.java.training.dipak.filesassignments;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * This program reads a line from a file and then reverses it and prints it on the console.
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 *
 */
public class ReverseLineOfFile {
	private static final Logger LOGGER=Logger.getLogger(ReverseLineOfFile.class.getName());
	
	private ReverseLineOfFile() {
		
	}
	/**
	 * This method reverse the line read from the file then prints it to the console.
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void reverseLine(){		
		try(BufferedReader br=new BufferedReader(new FileReader("src/com/lftechnology/java/training/dipak/filesassignments/Files/testfile.txt"))){
			String str=br.readLine();
			StringBuilder sbr=new StringBuilder();
			while(str!=null) {				
				sbr.append(str);
				LOGGER.log(Level.INFO,"{0}",sbr.reverse());
				str=br.readLine();
				sbr.replace(0,sbr.length(),"");
			}
			
		}catch(FileNotFoundException fne) {
			LOGGER.log(Level.INFO,"Exception ::",fne);
			return;
		}catch(IOException ioe) {
			LOGGER.log(Level.INFO,"Exception ::",ioe);
			return;
		}	
					
	}
	public static void main(String[] args) {
		ReverseLineOfFile rf=new ReverseLineOfFile();
		
		rf.reverseLine();
		
	
	}

}
