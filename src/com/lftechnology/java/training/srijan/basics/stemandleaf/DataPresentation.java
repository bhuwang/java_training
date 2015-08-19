package com.lftechnology.java.training.srijan.basics.stemandleaf;

import java.util.Scanner;
import java.util.logging.Logger;

public class DataPresentation {
	private int[] datas;
	private static final Logger LOGGER = Logger.getLogger(DataPresentation.class.getName());
	private int[][] stemFrequencyLeaf;
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
		
		for(int i=0;i<numberOfDatas;i++){
			for(int j=0;j<3;j++){
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
	
	public void separateStemFrequencyLeaf(){
		
	}
}
