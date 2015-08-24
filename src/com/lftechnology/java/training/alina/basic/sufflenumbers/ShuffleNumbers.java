
package com.lftechnology.java.training.alina.basic.sufflenumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>ShuffleNumbers Class creates an array list with 49 Integer objects from 1
 * to 49 </p> <p>Randomly shuffles the list </p> <p>selects the first 6 values
 * from the shuffled list </p> <p> sorts the selected values and prints them out
 * </p> <p>Use ArrayList, Collections.shuffle(), ArrayList.subList(), and
 * Collection.sort() </p>
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class ShuffleNumbers {

	private static final Logger LOGGER =
		Logger.getLogger(ShuffleNumbers.class.getName());

	public static void main(String[] args) {

		List<Integer> arrayList = new ArrayList<Integer>();

		getArrayList(arrayList);
		getShuffledList(arrayList);
		getSortedArrayList(arrayList);
	}

	/**
	 * Function used to get array list with 49 Integer objects from 1 to 49
	 * 
	 * @param arrayList
	 *            {@link List} list of array with 49 integers
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public static void getArrayList(List<Integer> arrayList) {

		for (int i = 1; i < 50; i++) {
			arrayList.add(i);
		}
		LOGGER.log(
			Level.INFO, "Array List with 49 Integer Objects : {0}",
			new Object[] {
				arrayList
			});
	}

	/**
	 * Function that randomly shuffles the list
	 * 
	 * @param arrayList
	 *            {@link List} list of array with 49 integers
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public static void getShuffledList(List<Integer> arrayList) {

		Collections.shuffle(arrayList);
		LOGGER.log(Level.INFO, "Shuffled list : {0}", new Object[] {
			arrayList
		});
	}

	/**
	 * Function that selects the first 6 values from the shuffled list Displays
	 * 6 values from shuffled list in sorted form
	 * 
	 * @param arrayList
	 *            {@link List} list of shuffled array
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public static void getSortedArrayList(List<Integer> arrayList) {

		List<Integer> sortedList = new ArrayList<Integer>();
		sortedList = arrayList.subList(0, 6);
		LOGGER.log(
			Level.INFO, "First 6 SubList stored in List : {0}", new Object[] {
				sortedList
			});
		Collections.sort(sortedList);
		LOGGER.log(Level.INFO, "Sorted Array List: : {0}", new Object[] {
			sortedList
		});
	}
}
