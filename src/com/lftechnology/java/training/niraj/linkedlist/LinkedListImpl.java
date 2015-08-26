/**
 * 
 */

package com.lftechnology.java.training.niraj.linkedlist;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.niraj.shuffle.UserNumInputImpl;

/**
 * Process the linked list
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 */
public class LinkedListImpl {

	private static final Logger LOGGER =
		Logger.getLogger(LinkedListImpl.class.getName());
	private static UserNumInputImpl userNumInput = new UserNumInputImpl();
	private static UserStringInputImpl userStringInput =
		new UserStringInputImpl();
	private static int listLength;

	private LinkedListImpl() {

	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			LinkedListImpl linkedList = new LinkedListImpl();
			linkedList.setListLength(scanner);
			LOGGER.info("First List Items: \n");
			List<String> firstLinkedList = linkedList.setList(scanner);
			LOGGER.log(Level.INFO, "First linked List:{0}", firstLinkedList);
			LOGGER.info("Second List Items:\n");
			List<String> secondLinkedList = linkedList.setList(scanner);
			LOGGER.log(Level.INFO, "Second linked List:{0}", secondLinkedList);
			linkedList.processLists(firstLinkedList, secondLinkedList);

		}
		catch (InputMismatchException e) {
			LOGGER.log(Level.WARNING, "Exception:{0}", e);
		}
	}

	/**
	 * Sets the linked list
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param scanner
	 *            {@link Scanner} to scan the user's input
	 * @return {@link List} of user's input
	 */
	private List<String> setList(Scanner scanner) {

		List<String> stringList = new LinkedList<String>();
		String item;
		for (int i = 0; i < listLength; i++) {
			item = userStringInput.getInput(scanner);
			stringList.add(item);
		}
		return stringList;
	}

	/**
	 * Sets the length of the list
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param scanner
	 *            {@link Scanner} to scan user's input
	 */
	private void setListLength(Scanner scanner) {

		int min = 3;
		listLength = userNumInput.getInputMin(scanner, min);
	}

	/**
	 * Process the two linked list to get result
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param firstList
	 *            {@link List}
	 * @param secondList
	 *            {@link List}
	 */
	private void processLists(List<String> firstList, List<String> secondList) {

		ListServiceImpl listService = new ListServiceImpl();

		listService.merge(firstList, secondList);
		LOGGER.log(Level.INFO, "The merged list is:{0}", firstList);

		listService.remove(secondList, Parity.ODD);
		LOGGER.log(
			Level.INFO, "Second list with every other element removed:{0}",
			secondList);

		listService.remove(firstList, secondList);
		LOGGER.log(
			Level.INFO, "First list without items from second list:{0}",
			firstList);

	}

}
