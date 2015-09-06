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

	public void dataHandler() {
		inputsStemsAndLeaves();
		displayStemAndLeaf();
		sortStemAndLeaf();
		displaySortedStemAndLeaf();
		separateStemsAndLeaves();
	}

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

	public void displayStemAndLeaf() {
		Iterator<Integer> iterator;
		iterator = userInputs.iterator();
		LOGGER.info("Stem And Leaf in ArrayList ");
		while (iterator.hasNext()) {
			LOGGER.info(iterator.next() + "");
		}
	}

	public void sortStemAndLeaf() {
		Iterator<Integer> iterator;
		iterator = userInputs.iterator();
		while (iterator.hasNext()) {
			setOfSortedInputs.add(iterator.next());
		}
	}

	public void displaySortedStemAndLeaf() {
		Iterator<Integer> iterator;
		iterator = setOfSortedInputs.iterator();
		LOGGER.info("Sorted Stem And Leaf");
		while (iterator.hasNext()) {
			LOGGER.info(iterator.next() + "");
		}
	}
	
	public void separateStemsAndLeaves(){
		int stem = 0;
		Iterator<Integer> iterator;
		iterator = this.userInputs.iterator();
		while(iterator.hasNext()){
			int value = iterator.next();
			stem = value/10;
			Integer leafValue = getLeafValue(value);
			List<Integer> leaf = this.stemByLeaves.get(leafValue);
			this.stemByLeaves.put(stem,leaf = new ArrayList<Integer>());
			leaf.add(leafValue);
		}
		LOGGER.log(Level.INFO, "separate stem and leaf {0}", stemByLeaves);
	}
	
	public Integer getLeafValue(Integer value){
		return (value % 10);
	}

}
