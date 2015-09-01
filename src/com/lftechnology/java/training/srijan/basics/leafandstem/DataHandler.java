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
		//separateStemFromUserInputs();
		//separatesLeavesFromUserInputs();
		//displayStems();
		//displayLeaves();
		sortStemAndLeaf();
		displaySortedStemAndLeaf();
		//determineLeavesForStems();
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

	public void separateStemFromUserInputs() {
		Iterator<Integer> iterator;
		iterator = userInputs.iterator();
		while (iterator.hasNext()) {
			setOfStems.add(iterator.next() / 10);
		}
	}

	public void separatesLeavesFromUserInputs() {
		for (Integer leaves : userInputs) {
			listOfLeaves.add(leaves % 10);
		}
	}

	public void displayStems() {
		LOGGER.info("All Stems");
		for (Integer stems : setOfStems) {
			LOGGER.info(stems + "");
		}
	}

	public void displayLeaves() {
		LOGGER.info("All Leaves");
		for (Integer leaves : listOfLeaves) {
			LOGGER.info(leaves + "");
		}
	}

	/*public void determineLeavesForStems() {
		System.out.println(" stems " + this.setOfStems);
		System.out.println(" list of leaves : " + this.listOfLeaves.toString());
		List<Integer> tempListOfLeaves = new ArrayList<>();
		for (int stem : this.setOfStems) {
			//check if leave is of corresponding stem
			for (int leaf : this.listOfLeaves) {
				if ((leaf == 2 || leaf == 3) && stem == 1) {
					if (this.stemByLeaves.get(stem) == null) {
						this.stemByLeaves.put(stem, "");
					}
					String temp = this.stemByLeaves.get(stem) + "," + leaf;
					this.stemByLeaves.put(stem, temp);
					tempListOfLeaves.add(leaf);
				}
			}
			this.listOfLeaves.removeAll(tempListOfLeaves);
			tempListOfLeaves.clear();
		}
		System.out.println(stemByLeaves);
	}*/
	
	public void separateStemsAndLeaves(){
		int stem = 0;
		//int leaf = 0;
		Iterator<Integer> iterator;
		iterator = this.userInputs.iterator();
		while(iterator.hasNext()){
			int value = iterator.next();
			stem = value/10;
			Integer leafValue = getLeafValue(value);
			List<Integer> leaf = this.stemByLeaves.get(leafValue);
			this.stemByLeaves.put(stem,leaf = new ArrayList<Integer>());
			leaf.add(leafValue);
			System.out.println(leafValue);
		}
		//System.out.println(stemByLeaves);
		LOGGER.log(Level.INFO, "separate stem and leaf {0}", stemByLeaves);
	}
	
	public Integer getLeafValue(Integer value){
		return (value % 10);
	}

}
