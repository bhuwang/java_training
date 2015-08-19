package com.lftechnology.java.training.sanish.stemleaf;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StemLeafDemo {
	private static final Logger LOGGER = Logger.getLogger(StemLeafDemo.class
			.getName());
	private static ArrayList<Integer> numberPoints = new ArrayList<Integer>();
	private static ArrayList<StemLeaf> stemLeafs = new ArrayList<StemLeaf>();

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			getDataPoints(scanner);
			generateStemLeafs();
			displayStemLepfs();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Exception : {0}",
					new Object[] { e.getMessage() });
		}
	}

	/**
	 * Get data points for console
	 * 
	 * @param scanner
	 *            {@link Scanner}
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static void getDataPoints(Scanner scanner) {
		LOGGER.log(Level.INFO, "Enter number of data points :");
		int dataPoints = UserInput.getNumber(scanner, Constants.NUM_ZERO,
				Constants.MAX_NUM);
		int userInputNum;
		for (int i = 0; i < dataPoints; i++) {
			LOGGER.log(Level.INFO, "[{0}]", new Object[] { i });
			userInputNum = UserInput.getNumber(scanner, Constants.MIN_NUM,
					Constants.MAX_NUM);
			numberPoints.add(userInputNum);
		}
	}

	/**
	 * Generate stem & leafs form data points
	 * 
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static void generateStemLeafs() {
		int stem, leaf, firstNum, secondNum, leafCount, index;
		int dataPointLength = numberPoints.size();
		StemLeaf stemLeaf;
		while (dataPointLength != 0) {
			stem = numberPoints.get(0) / 10;
			leafCount = leaf = index = 0;
			while (index < dataPointLength) {
				firstNum = numberPoints.get(index) / 10;
				if (firstNum == stem) {
					secondNum = numberPoints.get(index) % 10;
					leaf = leaf * 10 + secondNum;
					numberPoints.remove(index);
					leafCount++;
					dataPointLength--;
				} else {
					index++;
				}
			}

			// add stemLeaf in stemLeafs ArrayList
			stemLeaf = new StemLeaf(leafCount, stem, leaf);
			stemLeafs.add(stemLeaf);
		}
	}

	/**
	 * Display generated stemLeapfs
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public static void displayStemLepfs() {
		String dispalyContent = "";
		for (StemLeaf stemleaf : stemLeafs) {
			dispalyContent += stemleaf.toString() + "\n ";
		}
		LOGGER.log(
				Level.INFO,
				"\n Stem and Leaf Display:\n Frequency \t Stem \t Leaf \n ======================================\n {0}",
				new Object[] { dispalyContent });
	}
}
