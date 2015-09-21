package com.lftechnology.java.training.srijan.basics.shufflenumber;

/**
 * <p>
 * Create an array list with 49 Integer objects containing the numbers 1 through
 * 49. It then randomly shuffles the list and selects the first 6 values from
 * the shuffled list. Finally, it sorts the selected values and prints them out.
 * Hint: Use ArrayList, Collections.shuffle(), ArrayList.subList(), and
 * Collection.sort().
 * </p>
 * 
 * @author srijan 
 *
 */
public class ShuffleNumbers {

	private ShuffleNumbers() {

	}

	public static void main(String[] args) {
		ShuffleNumbersDataHandler shuffleNumbersDataHandler = new ShuffleNumbersDataHandler();
		shuffleNumbersDataHandler.dataHandler();
	}
}
