package com.lftechnology.java.training.srijan.basics.stemandleaf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

public class DataPresentation {
	private int[] datas;
	private static final Logger LOGGER = Logger.getLogger(DataPresentation.class.getName());
	private int[][] stemFrequencyLeaf;
	List<Integer> stemAndLeaf = new ArrayList<>();
	Set<Integer> stem = new TreeSet<>();
	List<Integer> leaf = new ArrayList<>();

	/**
	 * <p>
	 * constructor
	 * </p>
	 * <p>
	 * initialize array
	 * </p>
	 * 
	 * @param numberOfDatas
	 *            {@link Integer}
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	public DataPresentation(int numberOfDatas) {
		datas = new int[numberOfDatas];
		stemFrequencyLeaf = new int[numberOfDatas][3];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = 0;
		}

		for (int i = 0; i < numberOfDatas; i++) {
			for (int j = 0; j < 3; j++) {
				stemFrequencyLeaf[i][j] = 0;
			}
		}
	}

	/**
	 * <p>
	 * controls all the Methods
	 * </p>
	 * <p>
	 * Inputs Data, display unsorted Data, sorts input Data
	 * </p>
	 * 
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	public void dataHandler() {
		inputDataPoints();
		displayUnsortedInputData();
		insertionSort();
		separateStemFrequencyLeaf();
	}

	/**
	 * <p>
	 * Inputs Data and stores in an array
	 * </p>
	 * 
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	public void inputDataPoints() {
		Scanner inputData = new Scanner(System.in);
		LOGGER.info("Input Datas");
		try {
			for (int i = 0; i < datas.length; i++) {
				datas[i] = inputData.nextInt();
				stemAndLeaf.add(datas[i]);
				//treeSetOfStemAndLeaf.add(datas[i]);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			LOGGER.info("Array index out of bound:" + ex.getMessage());
		} finally {
			inputData.close();
		}
	}

	/**
	 * <p>
	 * Displays data without sorting
	 * </p>
	 * 
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	public void displayUnsortedInputData() {
		Iterator<Integer> iterator;
		iterator = stemAndLeaf.iterator();
		LOGGER.info("Unsorted Entered Datas:");
		for (int i = 0; i < datas.length; i++) {
			LOGGER.info("[" + i + "]" + ":" + datas[i]);
		}
	}

	/**
	 * <p>
	 * Sorts Data using Insertion sort Technique and stores in same array
	 * </p>
	 * 
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	public void insertionSort() {
		int tempData = 0;
		int temp = 0;
		for (int i = 1; i <= datas.length - 1; i++) {
			tempData = i;
			while (tempData > 0 && datas[tempData] < datas[tempData - 1]) {
				temp = datas[tempData];
				datas[tempData] = datas[tempData - 1];
				datas[tempData - 1] = temp;
				tempData--;
			}
		}
		displaySortedData();
	}

	/**
	 * <p>
	 * Displays sorted Data
	 * </p>
	 * 
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	public void displaySortedData() {
		LOGGER.info("Sorted Data in Ascending Order:");
		for (int i = 0; i < datas.length; i++) {
			LOGGER.info("[" + i + "]" + ":" + datas[i]);
		}
	}
	
	/**
	 * <p>Separates stem and leaf from collection</p>
	 * @author srijan
	 */
	public void separateStemFrequencyLeaf() {
		Iterator<Integer> iterator;
		iterator = stemAndLeaf.iterator();
		int quotient = 0;
		int remainder = 0;
		while (iterator.hasNext()) {
			int value = iterator.next();
			quotient = value / 10;
			remainder = value % 10;
			stem.add(quotient);
			leaf.add(remainder);
		}
		displayStem();
		
	}
	
	/**
	 * <p>Displays stem </p>
	 * @author srijan
	 */
	public void displayStem(){
		Iterator<Integer> stemIterator;
		stemIterator = stem.iterator();
		while(stemIterator.hasNext()){
			LOGGER.info("Stem " + stemIterator.next());
		}
		displayLeaf();
		
	}
	
	/**
	 * <p>Displays leaf</p>
	 * @author srijan
	 */
	public void displayLeaf(){
		Iterator<Integer> leafIterator;
		leafIterator = leaf.iterator();
		while(leafIterator.hasNext()){
			LOGGER.info("Leaf " + leafIterator.next());
		}
	}

}
