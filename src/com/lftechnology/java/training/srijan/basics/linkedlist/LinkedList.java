package com.lftechnology.java.training.srijan.basics.linkedlist;

/**
 * a. Create a linked list named one and two. 
 * b. Add some elements to both one (one, two, three, four, five) and two (six, seven, eight, nine, and ten). 
 * c. Merge the words from two into one.
 * d. Remove every second word from two.
 * e. Remove all words in two from one.
 * f. Print the value after each operation.
 * @author srijan
 *
 */
public class LinkedList {
	
	private LinkedList(){
		
	}
	
	public static void main(String[] args){
		LinkedListDataHandler linkedListHandler = new LinkedListDataHandler();
		linkedListHandler.dataHandler();
	}
}
