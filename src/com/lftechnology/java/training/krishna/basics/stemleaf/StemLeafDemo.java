package com.lftechnology.java.training.krishna.basics.stemleaf;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * StemLeafDemo.java
 * 
 * Log the output on the console.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class StemLeafDemo {
	private final static Logger LOGGER = Logger.getLogger(StemLeafDemo.class.getName());

	/**
	 * This is the main method which makes use of displayStemLeafData() method.
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void main(String[] args) {

		// declare an array to store integral data points
		int dataset[] = new int[] {44,46,47,49,63,64,66,68,68,72,72,75,76,81,84,88,106};
		int datasetLength = dataset.length;

		displayStemLeafData(dataset, datasetLength);
	}

	/**
	 * This method display the steam and leaf on console.
	 * 
	 * @param dataset
	 *            {@link array} array of dataset
	 * @param datasetLength
	 *            {@link int} length of dataset
	 *            
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void displayStemLeafData(int[] dataset, int datasetLength) {

		int[][] mode = StemLeaf.getMode(dataset, datasetLength);
		int[][] stemLeaf = StemLeaf.getStemLeaf(dataset, datasetLength);

		LOGGER.log(Level.INFO, "Stem and Leaf Display:");

		int c = 0;
		int leaf = 0;
		for (int i = 0; i < datasetLength; i++) {
			if (mode[i][1] != 0) {
				leaf += mode[i][0];
				List<Integer> numbers = new ArrayList<Integer>();
				for (int j = c; j < leaf; j++) {
					numbers.add(stemLeaf[j][1]);
					c = leaf;
				}
				// StringBuilder to store comma separated string
				StringBuilder commaSepLeaf = new StringBuilder();
				// iterate over list,append numbers and comma until last element
				for (int k = 0; k < numbers.size(); k++) {
					commaSepLeaf.append(numbers.get(k));
					if (k != numbers.size() - 1) {
						commaSepLeaf.append(", ");
					}
				}
				LOGGER.log(Level.INFO, "Frequency: {0} Steam: {1} Leaf: {2}",
						new Object[] { mode[i][0], mode[i][1], commaSepLeaf });
			}
		}
	}

}
