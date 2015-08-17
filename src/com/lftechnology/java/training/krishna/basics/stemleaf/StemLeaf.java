package com.lftechnology.java.training.krishna.basics.stemleaf;

/**
 *  StemLeaf.java
 *  
 * This program calculates steam leaf and mode of values in an array of integers
 * where the size of the array and elements of the array are provided as dataset
 * by the user.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class StemLeaf {
	/**
	 * This method computes the mean of the values in the dataset array.
	 * 
	 * @param dataset
	 *            {@link array} array of dataset
	 * @param datasetSize
	 *            {@link int} size of dataset
	 * @return mode - the mode of the dataset array
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static int[][] getMode(int[] dataset, int datasetSize) {

		dataset = bubbleSort(dataset, datasetSize);
		int[][] stemLeaf = getStemLeaf(dataset, datasetSize);

		// initialize 2D array storing numbers of occurrences, and values
		int[][] mode = new int[datasetSize][2];
		for (int i = 0; i < datasetSize; i++) {
			for (int j = 0; j < 2; j++) {
				mode[i][j] = 0;
			}
		}
		// calculate mode
		mode[0][0] = 1;
		int count = 1;
		for (int i = count - 1; i < datasetSize; i++) {
			for (int j = count - 1; j < datasetSize - 1; j++) {
				if (stemLeaf[i][0] == stemLeaf[j + 1][0]) {
					count++;
					mode[i][0]++;
					mode[i][1] = stemLeaf[i][0];
				} else if (i == 0)
					mode[i][1] = stemLeaf[i][0];
			}
		}
		return mode;
	}

	/**
	 * This method returns a sorted version of the input array.
	 * 
	 * @param dataset
	 *            {@link array} array of dataset
	 * @param datasetSize
	 *            {@link int} size of dataset
	 * @return dataset - sorted version of the dataset array
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static int[] bubbleSort(int[] dataset, int datasetSize) {

		int temp = 0;

		for (int i = 0; i < datasetSize; i++) {
			for (int j = 1; j < (datasetSize - i); j++) {

				if (dataset[j - 1] > dataset[j]) {
					// swap the elements!
					temp = dataset[j - 1];
					dataset[j - 1] = dataset[j];
					dataset[j] = temp;
				}
			}
		}
		return dataset;
	}

	/**
	 * This program returns stem and leaf.
	 * 
	 * @param dataset
	 *            {@link array} array of dataset
	 * @param datasetSize
	 *            {@link int} size of dataset
	 * @return - steam and leaf in 2D array
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static int[][] getStemLeaf(int[] dataset, int datasetSize) {

		// store stem and leaf in a 2D array
		int[][] stemLeaf = new int[datasetSize][2];
		for (int i = 0; i < datasetSize; i++) {
			stemLeaf[i][0] = dataset[i] / 10;
			stemLeaf[i][1] = dataset[i] % 10;
		}
		return stemLeaf;
	}
}
