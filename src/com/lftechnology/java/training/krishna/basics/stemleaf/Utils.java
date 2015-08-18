package com.lftechnology.java.training.krishna.basics.stemleaf;

import java.util.List;

/**
 * Utils.java
 * 
 * This program works for String Utilities.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class Utils {
	
	//constructor
	private Utils() {
	
	}

	/**
	 * This method implode the input array with separater.
	 * 
	 * @param array
	 *            {@link array} input array
	 * @param separator
	 *            {@link String} separator like "-"
	 *            
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static StringBuilder implode(List<Integer> array, String separator){

		int arraySize = array.size();
		// StringBuilder to store separator separated string
		StringBuilder output = new StringBuilder();
		// iterate over list,append numbers and separator until last element
		for (int k = 0; k < arraySize; k++) {
			output.append(array.get(k));
			if (k != arraySize - 1) {
				output.append(separator);
			}
		}
		return output;
	}

}
