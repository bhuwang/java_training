
package com.lftechnology.java.training.dipak.shufflenumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p> Creates an array list with Integer objects containing the numbers of the
 * range provided by the user. It then shuffles the list and selects the values
 * of certain range provided by user. Finally, it sorts the selected values and
 * prints them out. </p>
 * 
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 */

public class ShuffleNumbers {

	private static final Logger LOGGER =
		Logger.getLogger(ShuffleNumbers.class.getName());
	private List<Integer> integerArray = new ArrayList<Integer>();
	private List<Integer> sortedSubArray = new ArrayList<Integer>();

	/**
	 * <p>This function fills the arraylist with the numbers from the
	 * lowerRange(inclusive) to upperRange(inclusive)</p>
	 * 
	 * @param sc
	 * @param lowerRange
	 * @param upperRange
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void getNumbers(int lowerRange, int upperRange) {

		for (int i = lowerRange; i <= upperRange; i++) {
			integerArray.add(i);
		}
		LOGGER.log(
			Level.INFO, "An array list of integer from {0} to {1} is created",
			new Object[] {
				lowerRange, upperRange
		});
	}

	/**
	 * <p>This function shuffles the arraylist.</p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void shuffleArray() {

		Collections.shuffle(integerArray);
	}

	/**
	 * <p>This function selects the numbers from the shuffled list with the help
	 * of the indexes provided by user</p>
	 * 
	 * @param startIndex
	 * @param endIndex
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void getSubArray(int startIndex, int endIndex) {

		sortedSubArray = integerArray.subList(startIndex, endIndex);

		LOGGER.log(
			Level.INFO,
			"Ann array of selected values from index {0} to index {1} is created",
			new Object[] {
				startIndex, endIndex
		});

	}

	/**
	 * <p>This function sorts the sub array obtained from the shuffled</p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void sortArray() {

		Collections.sort(sortedSubArray);
	}

	/**
	 * <p>Displays the sorted array obtained from the shuffled array.</p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void displaySortedSubArray() {

		LOGGER.info("The sorted array is -->");
		LOGGER.log(Level.INFO, "{0}", sortedSubArray);
	}

	public static void main(String[] args) {

		ShuffleNumbers sn = new ShuffleNumbers();
		try (Scanner sc = new Scanner(System.in)) {
			LOGGER.info("Enter the lower range:: (Lower Range inclusive)");
			int lowerRange = Math.abs(Integer.parseInt(sc.nextLine()));
			LOGGER.info("Enter the upper range:: (Upper Range Inclusive)");
			int upperRange = Math.abs(Integer.parseInt(sc.nextLine()));
			sn.getNumbers(lowerRange, upperRange);

			sn.shuffleArray();

			LOGGER.info("Enter the lower index ::");
			int startIndex = Math.abs(Integer.parseInt(sc.nextLine()));
			LOGGER.info("Enter the upper index::");
			int endIndex = Math.abs(Integer.parseInt(sc.nextLine()));
			sn.getSubArray(startIndex, endIndex);

			sn.sortArray();
			sn.displaySortedSubArray();
		}
		catch (NumberFormatException nfe) {
			LOGGER.log(Level.INFO, "Exception occurred. {0}", nfe);
			System.exit(0);
		}

	}

}
