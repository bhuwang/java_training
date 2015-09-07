package com.lftechnology.java.training.dipak.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The program does the following:
 * 1.Creates linked list named one and two.
 * Adds some elements to both one (one, two, three, four, five) and two (six, seven, eight, nine, and ten).
 * Merges the words from two into one.
 * Removes every second word from two.
 * Removes all words in two from one.
 * Prints the value after each operation.
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 *
 */
public class LinkedListProgram {
	private static final Logger LOGGER=Logger.getLogger(LinkedListProgram.class.getName());
	
	
	private LinkedListProgram() {
	}
	/**
	 * This method merges the second list to the first list.
	 * @param listOne
	 * @param listTwo
	 * @return
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public List<String> mergeLists(List<String> listOne,List<String> listTwo){

		listOne.addAll(listTwo);
		return listOne;
	}
	/**
	 * This method removes every 2s element from the second list present in first list.
	 * @param list1
	 * @param sizeOfOtherList
	 * @return
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public List<String> removeNumbers(List<String> list1,int sizeOfOtherList) {
		int startIndex=list1.size()-sizeOfOtherList;
		for(int i=startIndex+1;i<list1.size();i++) {
				list1.remove(i);
		}
		return list1;
	}
	/**
	 * 
	 * @param list1
	 * @param l2
	 * @return l1
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public List<String> removeAll(List<String> list1,List<String> list2) {
		list1.removeAll(list2);
		return list1;
	}
	public static void main(String[] args) {
		LinkedListProgram lld=new LinkedListProgram();
		
		List<String> listOne=new LinkedList<>();
		listOne.add("one");
		listOne.add("two");
		listOne.add("three");
		listOne.add("four");
		listOne.add("five");
		
		LOGGER.log(Level.INFO,"List one::{0}",listOne);
		
		List<String> listTwo=new LinkedList<>();
		listTwo.add("six");
		listTwo.add("seven");
		listTwo.add("eight");
		listTwo.add("nine");
		listTwo.add("ten");
		
		LOGGER.log(Level.INFO,"List two::{0}",listTwo);
		
		LOGGER.info("After merging........");
		listOne=lld.mergeLists(listOne, listTwo);
		LOGGER.log(Level.INFO,"{0}",listOne);
		
		LOGGER.info("After removing the even numbers of list two in list one.....");
		listOne=lld.removeNumbers(listOne,listTwo.size());
		LOGGER.log(Level.INFO,"{0}",listOne);
		
		LOGGER.info("After removing two from one.............");
		listOne=lld.removeAll(listOne,listTwo);
		LOGGER.log(Level.INFO,"{0}",listOne);
	}

}
