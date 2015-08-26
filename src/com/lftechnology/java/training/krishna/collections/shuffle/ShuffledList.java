
package com.lftechnology.java.training.krishna.collections.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Create an array list with 49 Integer objects containing the numbers 1 through 49. 
 * It then randomly shuffles the list and selects the first 6 values from the shuffled list. 
 * Finally, it sorts the selected values and prints them out. 
 * Hint: Use ArrayList, Collections.shuffle(), ArrayList.subList(), and Collection.sort().
 * 
 */

/**
 * ShuffledList.java This program shuffled the given list, sublist and finally
 * sort the list
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class ShuffledList {

	private static final Logger LOGGER =
		Logger.getLogger(ShuffledList.class.getName());

	// constructor
	private ShuffledList() {

	}

	/**
	 * This is the main method
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void main(String[] args) {

		List<Integer> arrayList = new ArrayList<>();
		List<Integer> sortedList = new ArrayList<>();
		for (int i = 1; i <= 49; i++) {
			arrayList.add(i);
		}
		LOGGER.log(Level.INFO, "Values of list: {0}", arrayList);

		Collections.shuffle(arrayList);
		LOGGER.log(Level.INFO, "Values of list after shuffling: {0}", arrayList);

		sortedList = arrayList.subList(0, 6);
		LOGGER.log(Level.INFO, "Values of list after sublist : {0}", sortedList);

		Collections.sort(sortedList);
		LOGGER.log(Level.INFO, "Values of list after sorting : {0}", sortedList);
	}
}
