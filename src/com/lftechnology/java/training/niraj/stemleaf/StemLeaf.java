/**
 * 
 */
package com.lftechnology.java.training.niraj.stemleaf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 * Helper class for data representation with stem and leaf plot
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class StemLeaf {
	private static final Logger LOGGER = Logger.getLogger(StemLeaf.class
			.getName());
	private static final int DIVIDER = 10;
	private int[] dataPoints;
	private Map<Integer, List<Integer>> stemLeafInfo;

	public StemLeaf(int[] dataPoints) {
		stemLeafInfo = new HashMap<Integer, List<Integer>>();
		setDataPoints(dataPoints);
	}

	public int[] getDataPoints() {
		return dataPoints;
	}

	public void setDataPoints(int[] dataPoints) {
		this.dataPoints = dataPoints;
		Arrays.sort(this.dataPoints);
	}

	/**
	 * Plots stem and leaf for the given data points
	 * 
	 * @author Niraj Rajbhandari<nirajrajbhandari@lftechnology.com>
	 */
	public void plotStemLeaf() {
		setStemLeafInfo(dataPoints);
		displayStemLeafPlot();
	}

	/**
	 * Set all the information related to stem and leaf plotting
	 * 
	 * @param dataPoints
	 *            {@link Integer[]}
	 * @author Niraj Rajbhandari <nirajrajbahndari@lftechnology.com>
	 */
	public void setStemLeafInfo(int[] dataPoints) {
		int quotient;
		int remainder;
		float divisionResult;
		for (int i = 0; i < dataPoints.length; i++) {
			remainder = dataPoints[i] % DIVIDER;
			divisionResult = dataPoints[i] / DIVIDER;
			quotient = (int) Math.floor(divisionResult);
			setSpecificStemLeafPlot(quotient, remainder);
		}
	}

	/**
	 * Set stem and leaf for specific data point
	 * 
	 * @param quotient
	 *            {@link Integer}
	 * @param remainder
	 *            {@link Integer}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	private void setSpecificStemLeafPlot(int quotient, int remainder) {
		List<Integer> leafList;
		if (stemLeafInfo.containsKey(quotient)) {
			leafList = stemLeafInfo.get(quotient);
			leafList.add(remainder);
		} else {
			leafList = new ArrayList<Integer>();
			leafList.add(remainder);
		}
		stemLeafInfo.put(quotient, leafList);
	}

	/**
	 * Display the stem and leaf plot
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	private void displayStemLeafPlot() {
		List<Integer> leafList;

		String eachEntry;
		StringBuilder stemLeafPlot = new StringBuilder();
		stemLeafPlot.append("\n\n\nSorted Array: \n\t");
		stemLeafPlot.append(Arrays.toString(dataPoints) + "\n");
		stemLeafPlot.append("-------------------------------------\n\n");
		stemLeafPlot.append("Stem and leaf Display: \n\n");
		stemLeafPlot.append("Frequency \t\t Stem \t\t Leaf\n");
		stemLeafPlot
				.append("====================================================\n");
		for (Entry<Integer, List<Integer>> entry : stemLeafInfo.entrySet()) {
			leafList = entry.getValue();
			eachEntry = leafList.size() + "\t\t\t  " + entry.getKey()
					+ "\t\t  " + getLeafListString(leafList) + "\n";
			stemLeafPlot.append(eachEntry);
		}
		LOGGER.info(stemLeafPlot.toString());
	}

	/**
	 * Get string of leaf list
	 * 
	 * @param leafList
	 *            {@link List}
	 * @return {@link String}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	private String getLeafListString(List<Integer> leafList) {
		String leafListString = "";
		for (int leaf : leafList) {
			leafListString += leaf + " ";
		}
		return leafListString;
	}
}
