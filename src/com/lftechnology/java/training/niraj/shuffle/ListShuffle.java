
package com.lftechnology.java.training.niraj.shuffle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creates an array list with 49 Integer objects containing the numbers 1
 * through 49. It then randomly shuffles the list and selects the first 6 values
 * from the shuffled list. Finally, it sorts the selected values and prints them
 * out.
 * 
 * @author Niraj Rajbhandari
 */
public class ListShuffle {

	private static final Logger LOGGER =
		Logger.getLogger(ListShuffle.class.getName());
	private UserNumInputImpl userInput;

	private ListShuffle() {

		userInput = new UserNumInputImpl();
	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			ListShuffle listShuffle = new ListShuffle();
			int subListLength = listShuffle.getSubListLength(scanner);
			List<Integer> numberList =
				listShuffle.getNumberList(scanner, subListLength);
			List<Integer> sortedList =
				listShuffle.getSortedSubList(numberList, subListLength);
			LOGGER.log(Level.INFO, "Sorted List : {0}", sortedList);
		}
		catch (InputMismatchException e) {
			LOGGER.warning(e.getMessage());
		}

	}

	/**
	 * Get number list to be shuffled
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param scanner
	 *            {@link Scanner}
	 * @param subListLength
	 *            int length of sub list
	 * @return {@link List} of number to be shuffled
	 */
	public List<Integer> getNumberList(Scanner scanner, int subListLength)
		throws InputMismatchException {

		int listLength = getListLength(scanner, subListLength);
		List<Integer> numberList = new ArrayList<Integer>();
		for (int i = 0; i < listLength; i++) {
			numberList.add(i);
		}
		return numberList;
	}

	/**
	 * Get sub list length from user
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param scanner
	 *            {@link Scanner}
	 * @return int sub list length
	 */
	private int getSubListLength(Scanner scanner) {

		int min = 3;
		return userInput.getInputMin(scanner, min);
	}

	/**
	 * Get list of the length
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param scanner
	 *            {@link Scanner}
	 * @param subListLength
	 *            int length of sub list
	 * @return
	 */
	private int getListLength(Scanner scanner, int subListLength) {

		int max = 50;
		return userInput.getInput(scanner, subListLength, max);

	}

	/**
	 * Get sorted sublist
	 * 
	 * @param itemList
	 *            {@link List} of items
	 * @param subListLength
	 *            int
	 * @return sorted sub {@link List} of defined length
	 */
	public List<Integer> getSortedSubList(
		List<Integer> itemList, int subListLength) {

		ShuffleIntListImpl shuffleList = new ShuffleIntListImpl();
		List<Integer> shuffledList = shuffleList.shuffleList(itemList);
		List<Integer> subList =
			shuffleList.getSubList(shuffledList, subListLength);
		List<Integer> sortedSubList = shuffleList.sortList(subList);

		return sortedSubList;

	}
}
