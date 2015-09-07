package com.lftechnology.java.training.srijan.basics.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandlerExample {
	private static final Logger LOGGER  = Logger.getLogger(HandlerExample.class.getName());
	
	public static void main(String[] args) {
		Handler consoleHandler = null;
		Handler fileHandler = null;
		
		try{
			consoleHandler = new ConsoleHandler();
			fileHandler = new FileHandler("./javacodegeeks.log");
			
			LOGGER.addHandler(consoleHandler);
			LOGGER.addHandler(fileHandler);
			
			consoleHandler.setLevel(Level.ALL);
			fileHandler.setLevel(Level.ALL);
			LOGGER.setLevel(Level.ALL);
			
			LOGGER.config("Configuration done");
			
			LOGGER.removeHandler(consoleHandler);
			LOGGER.log(Level.FINE, "fine logged");
		}catch(IOException ex){
			LOGGER.log(Level.SEVERE, "Error occured in FileHandler", ex);
		}
		
		LOGGER.finer("Finest example on LOGGER handler completed.");

	}
}
