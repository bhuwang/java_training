package com.lftechnology.java.training.dipak.filesassignments;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * This program counts the number of times a particular character, such as e, appears in a file. 
 * The character can be specified at the command line.
 * 
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 *
 */
public class SearchACharacterInFile {
	private static final Logger LOGGER=Logger.getLogger(SearchACharacterInFile.class.getName());
	private String characterToBeSearched="";  
	private int count=0;
	
	private SearchACharacterInFile() {
		
	}
	/**
	 * This method searches the character and counts the number of appearances.
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void searchCharacter(){		
		int i=-1;
		try(BufferedReader br=new BufferedReader(new FileReader("src/com/lftechnology/java/training/dipak/filesassignments/Files/testfile.txt"))){
				
			i=br.read();
			while(i!=-1) {				
				if(String.valueOf((char)i).equalsIgnoreCase(characterToBeSearched)) {
					count++;
				}
				i=br.read();
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
		SearchACharacterInFile cs=new SearchACharacterInFile();
		cs.characterToBeSearched=args[0];	
		
		cs.searchCharacter();
		
		LOGGER.log(Level.INFO,"The count is::{0}",cs.count);
	
	}

}
