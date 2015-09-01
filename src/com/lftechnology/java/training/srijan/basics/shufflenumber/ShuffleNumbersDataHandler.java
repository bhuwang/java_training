package com.lftechnology.java.training.srijan.basics.shufflenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShuffleNumbersDataHandler {
	
	private static final Logger LOGGER = Logger.getLogger(ShuffleNumbersDataHandler.class.getName());
	List<Integer> listOfNumbers = new ArrayList<>();
	List<Integer> firstSixNumbersFromShuffledInput = new ArrayList<>();
	
	public ShuffleNumbersDataHandler(){
		
	}
	
	/**
	 * <p>Handles all the functionality of this application</p>
	 * @author srijan
	 */
	public void dataHandler(){
		inputNumbers();
		displayInputNumbers();
		getShuffledList();
		subListOfShuffledList();
		sortedList();
	}
	
	/**
	 * <p>Inputs Numbers in Arraylist</p>
	 * @author srijan
	 */
	public void inputNumbers(){
		for(int i=0;i<50;i++){
			listOfNumbers.add(i);
		}
	}
	
	/**
	 * <p>Displays contents of input Arraylist</p>
	 * @author srijan
	 */
	public void displayInputNumbers(){
		for(Integer inputNumbers : listOfNumbers){
			LOGGER.log(Level.INFO, "Numbers in arraylist are: {0}",inputNumbers);
		}
	}
	
	/**
	 * <p>Shuffles input array list</[>
	 * @author srijan
	 */
	public void getShuffledList(){
		Collections.shuffle(listOfNumbers);
		LOGGER.log(Level.INFO, "Shuffled array list of numbers: {0}", listOfNumbers);
	}
	
	/**
	 * <p>Selects first six numbers from an array list and place in new array list</p>
	 * @author srijan
	 */
	public void subListOfShuffledList(){
		firstSixNumbersFromShuffledInput = listOfNumbers.subList(0, 6);
		LOGGER.log(Level.INFO,"First Six Numbers From shuffled list: {0}", firstSixNumbersFromShuffledInput);
	}
	
	/**
	 * <p>
	 * Sort the new arraylist in ascending order
	 * </p>
	 * 
	 * @author srijan
	 */
	public void sortedList(){
		Collections.sort(firstSixNumbersFromShuffledInput);
		LOGGER.log(Level.INFO,"Sorted shuffled list: {0}", firstSixNumbersFromShuffledInput);
	}
}
