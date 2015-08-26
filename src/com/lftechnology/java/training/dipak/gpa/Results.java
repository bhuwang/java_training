package com.lftechnology.java.training.dipak.gpa;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Results {
	private static final Logger LOGGER = Logger.getLogger(Results.class.getName());
	private Results(){
		
	}
	/**
	 * This method displays the students along with their name and respective GPAs.
	 * @param gp
	 */
	public static void displayResults(GPA[] gp){
		for (int i = 0; i < gp.length; i++) {
			LOGGER.log(Level.INFO,"Name:{0} 	Roll:{1} 	class:{2}	 GPA:{3}",new Object[]{gp[i].studentName,gp[i].studentRoll,gp[i].studentClass,gp[i].studentGpa});
		}
	}
}
