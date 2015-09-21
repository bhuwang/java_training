package com.lftechnology.java.training.srijan.basics.leafandstem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataHandler {

	private int numberOfDatas;
	private static final Logger LOGGER = Logger.getLogger(DataHandler.class.getName());
	List<Integer> userInputs = new ArrayList<>();
	Set<Integer> setOfStems = new TreeSet<>();
	List<Integer> listOfLeaves = new ArrayList<>();
	Set<Integer> setOfSortedInputs = new TreeSet<>();
	Map<Integer, List<Integer>> stemByLeaves = new HashMap<Integer, List<Integer>>();

	public DataHandler(int numberOfDatas) {
		this.numberOfDatas = numberOfDatas;
	}
	
	/**
	 * <p>Handles all the functionality of this application</p>
	 * @author srijan
	 */
	public void dataHandler() {
		inputsStemsAndLeaves();
		displayStemAndLeaf();
		sortStemAndLeaf();
		displaySortedStemAndLeaf();
		separateStemsAndLeaves();
	}
	
	/**
	 * <p>Inputs data from user whose stem and leaf to be determined</p>
	 * @author srijan
	 */
	public void inputsStemsAndLeaves() {
		Scanner input = new Scanner(System.in);
		int unseparatedStemAndLeaf = 0;
		LOGGER.info("Input datas");
		try {
			for (int i = 0; i < numberOfDatas; i++) {
				unseparatedStemAndLeaf = input.nextInt();
				userInputs.add(unseparatedStemAndLeaf);
			}
		} catch (Exception ex) {
			LOGGER.info("Exception " + ex);
		} finally {
			input.close();
		}
	}
	
	/**
	 * <p>Displays stem and leaf</p>
	 * @author srijan
	 */
	public void displayStemAndLeaf() {
		Iterator<Integer> iterator;
		iterator = userInputs.iterator();
		LOGGER.info("Stem And Leaf in ArrayList ");
		while (iterator.hasNext()) {
			LOGGER.info(iterator.next() + "");
		}
	}
	
	/**
	 * <p>Sorts unique input data in ascending order before stem and leaf are separated</p>
	 * @author srijan
	 */
	public void sortStemAndLeaf() {
		Iterator<Integer> iterator;
		iterator = userInputs.iterator();
		while (iterator.hasNext()) {
			setOfSortedInputs.add(iterator.next());
		}
	}
	
	/**
	 * <p>Displays sorted input data</p>
	 * @author srijan
	 */
	public void displaySortedStemAndLeaf() {
		Iterator<Integer> iterator;
		iterator = setOfSortedInputs.iterator();
		LOGGER.info("Sorted Stem And Leaf");
		while (iterator.hasNext()) {
			LOGGER.info(iterator.next() + "");
		}
	}
	
	/**
	 * <p>Separates stems and leaves and displays </p>
	 * @author srijan
	 */
	public void separateStemsAndLeaves() {
		int stem = 0;
		Iterator<Integer> iterator;
		iterator = this.userInputs.iterator();
		while (iterator.hasNext()) {
			int value = iterator.next();
			stem = value / 10;
			Integer leafValue = getLeafValue(value);
			List<Integer> leaf = this.stemByLeaves.get(leafValue);
			leaf = new ArrayList<Integer>();
			this.stemByLeaves.put(stem, leaf);
			leaf.add(leafValue);
		}
		LOGGER.log(Level.INFO, "separate stem and leaf {0}", stemByLeaves);
	}
	
	/**
	 * <p>determine leaf from input data</p>
	 * @param value
	 * @return
	 */
	public Integer getLeafValue(Integer value) {
		return value % 10;
	}

}
