package com.lftechnology.java.training.dipak.leafandstem;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java program to display an integer data set in the form of stem and leaf. The
 * data points are input by the user from keyboard.
 * 
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 */
public class LeafAndStemRepresentationMethod2 {

	private static final Logger LOGGER =
		Logger.getLogger(LeafAndStemRepresentationMethod2.class.getName());
	private int[] numberArray;

	private String[][] leavesAndStems;

	public LeafAndStemRepresentationMethod2(int range) {
		numberArray = new int[range];
	}

	/**
	 * <p> This method calls a static BubbleSort method in another class. An
	 * unsorted array is passed into the function which is then returned back as
	 * sorted array. </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	void sortArray() {

		numberArray = BubbleSort.sortArray(numberArray);
	}

	/**
	 * <p> This method displays the sorted array(Ascending Order). </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	void displaySortedArray() {

		LOGGER.info("The sorted array is::");
		for (int i = 0; i < numberArray.length; i++) {
			LOGGER.log(Level.INFO, "{0} ", numberArray[i]);
		}
	}

	/**
	 * <p> This method separates the integer into stem and leaves </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	void separateStemAndLeaf() {

		String[] stem = new String[numberArray.length];
		String[] leaf = new String[numberArray.length];
		String[] stemFinal = new String[numberArray.length + 1];
		String[] leafFinal = new String[numberArray.length + 1];
		int frequency;
		leavesAndStems = new String[numberArray.length + 1][3];
		for (int i = 0; i < numberArray.length; i++) {
			String stringRepresentation = "";
			stringRepresentation = Integer.toString(numberArray[i]);
			if (stringRepresentation.length() == 1) {
				leaf[i] = stringRepresentation;
				continue;
			}
			leafFinal[i] = "";
			stem[i] = stringRepresentation.substring(0, 1);
			leaf[i] = stringRepresentation.substring(
				1, stringRepresentation.length());
		}
		int index = 0;
		for (int i = 0; i < stem.length && stem[i] != null; i++) {
			if (isPresent(stem[i])) {
				continue;
			}
			frequency = 1;
			leafFinal[index] = leafFinal[index] + leaf[i];
			for (int j = i + 1; j < stem.length && stem[j] != null; j++) {
				if ((stem[i].equals(stem[j])) && (!isPresent(stem[i]))) {
					frequency++;
					leafFinal[index] += "," + leaf[j];
				}
			}
			stemFinal[index] = "" + stem[i];
			leavesAndStems[index][0] = stemFinal[index];
			leavesAndStems[index][1] = Integer.toString(frequency);
			leavesAndStems[index][2] = leafFinal[index];
			index++;
		}
	}

	/**
	 * <p> This method checks whether the given element is present in the
	 * leavesAndStems array or not. </p>
	 * 
	 * @param String
	 *            numberToBeChecked
	 * @return true if the numberToBeChecked is present else false
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	boolean isPresent(String numberToBeChecked) {

		for (int i = 0; i < leavesAndStems.length &&
			leavesAndStems[i][0] != null; i++) {
			if (numberToBeChecked.equals(leavesAndStems[i][0])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <p> This method displays the stems and leaves. </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	void displayStemAndLeaf() {

		sortStemAndLeafArray();
		LOGGER.info("The Stem and Leaf Display ::");
		System.out.println(leavesAndStems[0][0]);
		for (int i = 0; i < leavesAndStems.length &&
			leavesAndStems[i][0] != null; i++) {
			LOGGER.log(
				Level.INFO, "Stem::{0}   Frequency::{1}   Leaves::{2}",
				new Object[] {
					leavesAndStems[i][0], leavesAndStems[i][1],
					leavesAndStems[i][2]
			});
		}
	}

	/**
	 * <p> This method sorts the leafAndStem array in ascending order. </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	void sortStemAndLeafArray() {

		String temp1;
		for (int i = 0; i < leavesAndStems.length - 1 &&
			leavesAndStems[i][0] != null; i++) {
			for (int j = 0; j < leavesAndStems.length - i - 1 &&
				leavesAndStems[j + 1][0] != null; j++) {
				if (Integer.parseInt(leavesAndStems[j][0]) > Integer.parseInt(
					leavesAndStems[j + 1][0])) {
					temp1 = leavesAndStems[j][0];
					leavesAndStems[j][0] = leavesAndStems[j + 1][0];
					leavesAndStems[j + 1][0] = temp1;

					temp1 = leavesAndStems[j][1];
					leavesAndStems[j][1] = leavesAndStems[j + 1][1];
					leavesAndStems[j + 1][1] = temp1;

					temp1 = leavesAndStems[j][2];
					leavesAndStems[j][2] = leavesAndStems[j + 1][2];
					leavesAndStems[j + 1][2] = temp1;
				}
			}
		}
	}

	public static void main(String[] args) {

		LeafAndStemRepresentationMethod2 lsrm1;
		int range = 0;
		Scanner scanner = new Scanner(System.in);
		boolean closeResource = false;
		LOGGER.log(Level.INFO, "Enter the size of array:");
		try {
			range = Math.abs(Integer.parseInt(scanner.nextLine()));
		}
		catch (NumberFormatException nfe) {
			LOGGER.info("Characters entered. Program will terminate");
			System.exit(0);
		}
		LOGGER.log(Level.INFO, "Enter {0} numbers::", range);
		lsrm1 = new LeafAndStemRepresentationMethod2(range);
		int i = 0;
		while (i < lsrm1.numberArray.length) {
			try {
				LOGGER.log(Level.INFO, "Enter number {0}:", i + 1);
				int m = Integer.parseInt(scanner.nextLine());
				lsrm1.numberArray[i] = m;
				if (i + 1 == lsrm1.numberArray.length) {
					closeResource = true;
				}
			}
			catch (NumberFormatException nfe) {
				LOGGER.info("Character Entered");
				i--;
			}
			finally {
				if (closeResource) {
					scanner.close();
				}
			}
			i++;
		}
		lsrm1.sortArray();
		lsrm1.displaySortedArray();
		lsrm1.separateStemAndLeaf();
		lsrm1.displayStemAndLeaf();

	}

}
