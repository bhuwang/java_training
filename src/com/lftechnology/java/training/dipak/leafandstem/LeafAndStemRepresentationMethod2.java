package com.lftechnology.java.training.dipak.leafandstem;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java program to display an integer data set in the form of stem and leaf. The
 * data points are input by the user from keyboard.
 * 
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 *
 */
public class LeafAndStemRepresentationMethod2 {
	private final static Logger LOGGER = Logger.getLogger(LeafAndStemRepresentationMethod2.class.getName());
	private int numberArray[];
	private String[][] leavesAndStems;

	public LeafAndStemRepresentationMethod2(int range) {
		numberArray = new int[range];
	}

	/**
	 * <p>
	 * This method calls a static BubbleSort method in another class. An
	 * unsorted array is passed into the function which is then returned back as
	 * sorted array.
	 * </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	void sortArray() {
		numberArray = BubbleSort.sortArray(numberArray);
	}

	/**
	 * <p>
	 * This method displays the sorted array(Ascending Order).
	 * </p>
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
	 * <p>
	 * This method separates the integer into stem and leaves
	 * </p>
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
			stringRepresentation = new Integer(numberArray[i]).toString();
			if (stringRepresentation.length() == 1) {
				leaf[i] = stringRepresentation;
				continue;
			}
			leafFinal[i] = "";
			stem[i] = stringRepresentation.substring(0, 1);
			leaf[i] = stringRepresentation.substring(1, stringRepresentation.length());
		}
		int index = 0;
		for (int i = 0; i < stem.length; i++) {
			if ("10".equals(stem[i])) {
				continue;
			}
			frequency = 1;
			leafFinal[index] = leafFinal[index] + leaf[i];
			for (int j = i + 1; j < stem.length; j++) {
				if ((stem[i].equals(stem[j])) && (!("10".equals(stem[i])))) {
					frequency++;
					leafFinal[index] += "," + leaf[j];
					stem[j] = "10";
				}
			}
			stemFinal[index] = "" + stem[i];
			leavesAndStems[index][0] = stemFinal[index];
			leavesAndStems[index][1] = new Integer(frequency).toString();
			leavesAndStems[index][2] = leafFinal[index];
			index++;
			stem[i] = "10";
		}

	}

	/**
	 * <p>
	 * This method displays the stems and leaves.
	 * </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	void displayStemAndLeaf() {
		LOGGER.info("The Stem and Leaf Display ::");
		for (int i = 0; i < leavesAndStems.length && leavesAndStems[i][0] != null; i++) {
			LOGGER.log(Level.INFO, "Stem::{0}   Frequency::{1}   Leaves::{2}",
					new Object[] { leavesAndStems[i][0], leavesAndStems[i][1], leavesAndStems[i][2] });
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int range=0;
		LeafAndStemRepresentationMethod2 lsrm1;
		Scanner scanner = new Scanner(System.in);
		boolean closeResource=false;
		LOGGER.log(Level.INFO, "Enter the size of array:");
		try{
			range = Math.abs(Integer.parseInt(scanner.nextLine()));
		}catch(NumberFormatException nfe){
			LOGGER.info("Characters entered. Program will terminate");
			System.exit(0);
		}
		LOGGER.log(Level.INFO,"Enter {0} numbers::",range);
		lsrm1 = new LeafAndStemRepresentationMethod2(range);
		for (int i = 0; i < lsrm1.numberArray.length; i++) {
			try {
				LOGGER.log(Level.INFO, "Enter number {0}:",i+1);
				int m = Integer.parseInt(scanner.nextLine());
				lsrm1.numberArray[i] = m;
				
			} catch (NumberFormatException nfe) {
				LOGGER.info("Character Entered");
				i--;
			}finally{
				if(closeResource){
					scanner.close();
				}
			}

		}
		lsrm1.sortArray();
		lsrm1.displaySortedArray();
		lsrm1.separateStemAndLeaf();
		lsrm1.displayStemAndLeaf();

	}

}
