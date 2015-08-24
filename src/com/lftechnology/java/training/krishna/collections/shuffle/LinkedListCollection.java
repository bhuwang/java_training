package com.lftechnology.java.training.krishna.collections.shuffle;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * a. Create a linked list named one and two. 
 * b. Add some elements to both one (one, two, three, four, five) and two (six, seven, eight, nine, and ten). 
 * c. Merge the words from two into one.
 * d. Remove every second word from two. 
 * e. Remove all words in two from one. 
 * f. Print the value after each operation.
 */

/**
 * This program creates two different lists and perform merge, remove and remove
 * all operation in that list.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class LinkedListCollection {

	private static final Logger LOGGER = Logger
			.getLogger(LinkedListCollection.class.getName());

	// constructor
	private LinkedListCollection() {

	}

	public static void main(String[] arg) {
		List<String> one = new LinkedList<String>();
		List<String> two = new LinkedList<String>();
		one.add("one");
		one.add("two");
		one.add("three");
		one.add("four");
		one.add("five");

		two.add("six");
		two.add("seven");
		two.add("eight");
		two.add("nine");
		two.add("ten");

		LOGGER.log(Level.INFO, "One list: {0}", one);
		LOGGER.log(Level.INFO, "Two list: {0}", two);

		one.addAll(two);
		LOGGER.log(Level.INFO, "Merge the words from two into one: {0}", one);

		two.remove(1);
		LOGGER.log(Level.INFO, "Remove every second word from two: {0}", two);

		one.removeAll(two);
		LOGGER.log(Level.INFO, "Remove all words in two from one: {0}", one);

	}
}