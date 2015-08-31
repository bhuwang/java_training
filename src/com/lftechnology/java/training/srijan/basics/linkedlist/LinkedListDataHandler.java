package com.lftechnology.java.training.srijan.basics.linkedlist;

import java.util.List;
import java.util.LinkedList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class LinkedListDataHandler {
	
	List<String> linkedListOne = new LinkedList<String>();
	List<String> linkedListTwo = new LinkedList<String>();
	private static final Logger LOGGER = Logger.getLogger(LinkedListDataHandler.class.getName());
	
	/**
	 * <p>Handles all the functionality</p>
	 * @author srijan
	 */
	public void dataHandler(){
		inputsLinkedListOne();
		inputsLinkedListTwo();
		mergeLinkedListTwoToOne();
		removeEverySecondWordFromLinkedListTwo();
		removeAllWordsInLinkedListTwo();
	}
	
	/**
	 * <p>Inputs words in linked list one and displays words</p>
	 * @author srijan
	 */
	public void inputsLinkedListOne(){
		linkedListOne.add("One");
		linkedListOne.add("Two");
		linkedListOne.add("Three");
		linkedListOne.add("Four");
		linkedListOne.add("Five");
		LOGGER.log(Level.INFO, "Elements in linkedListOne are: {0}", linkedListOne);
	}
	
	/**
	 * <p>Inputs words in linked list two and displays words</p>
	 * @author srijan
	 */
	public void inputsLinkedListTwo(){
		linkedListTwo.add("Six");
		linkedListTwo.add("Seven");
		linkedListTwo.add("Eight");
		linkedListTwo.add("Nine");
		linkedListTwo.add("Ten");
		LOGGER.log(Level.INFO,"Elements in linkedListTwo are: {0}", linkedListTwo);
	}
	
	/**
	 * <p>Merge linked list two to one and displays result </p>
	 * @author srijan
	 */
	public void mergeLinkedListTwoToOne(){
		linkedListOne.addAll(linkedListTwo);
		LOGGER.log(Level.INFO, "Elements in linkedListOne after linkedListTwo merged to linkedListOne: {0}", linkedListOne);
	}
	
	/**
	 * <p>Removes every second word from linked list two and displays linked list two</p>
	 * @author srijan
	 */
	public void removeEverySecondWordFromLinkedListTwo(){
		for(int i=0;i<linkedListTwo.size();i+=2){
			linkedListTwo.remove(i);
		}
		LOGGER.log(Level.INFO, "Elements in linkedListTwo after every second Word removal {0}", linkedListTwo);
	}
	
	/**
	 * <p>Removes all words present in linked list two</p>
	 * <p>linked list one contains merged linked list one and two words</p>
	 * @author srijan
	 */
	public void removeAllWordsInLinkedListTwo(){
		linkedListOne.removeAll(linkedListTwo);
		LOGGER.log(Level.INFO, "Elements in linkedListOne after removal of linkedListTwo words: {0}", linkedListOne);
	}
}
