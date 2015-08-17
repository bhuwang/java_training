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
		int n = 17;
		// declare an array of n size to store integral data points
		int dataset[] = new int[n];
		dataset[0] = 44;
		dataset[1] = 46;
		dataset[2] = 47;
		dataset[3] = 49;
		dataset[4] = 63;
		dataset[5] = 64;
		dataset[6] = 66;
		dataset[7] = 68;
		dataset[8] = 68;
		dataset[9] = 72;
		dataset[10] = 72;
		dataset[11] = 75;
		dataset[12] = 76;
		dataset[13] = 81;
		dataset[14] = 84;
		dataset[15] = 88;
		dataset[16] = 106;
		int datasetSize = dataset.length;

		displayStemLeafData(dataset, datasetSize);
	}

	/**
	 * This method display the steam and leaf on console.
	 * 
	 * @param dataset
	 *            {@link array} array of dataset
	 * @param datasetSize
	 *            {@link int} size of dataset
	 *            
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void displayStemLeafData(int[] dataset, int datasetSize) {

		int[][] mode = StemLeaf.getMode(dataset, datasetSize);
		int[][] stemLeaf = StemLeaf.getStemLeaf(dataset, datasetSize);

		LOGGER.log(Level.INFO, "Stem and Leaf Display:");

		int c = 0;
		int leaf = 0;
		for (int i = 0; i < datasetSize; i++) {
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
