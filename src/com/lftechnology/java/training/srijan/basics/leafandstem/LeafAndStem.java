package com.lftechnology.java.training.srijan.basics.leafandstem;

import java.util.Scanner;
import java.util.logging.Logger;

public class LeafAndStem {
	private static final Logger LOGGER = Logger.getLogger(LeafAndStem.class.getName());

	private LeafAndStem() {

	}

	public static void main(String[] args) {
		int numberOfDatas = 0;
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter number of Data Points:");
		numberOfDatas = input.nextInt();
		DataHandler stemAndleaf = new DataHandler(numberOfDatas);
		stemAndleaf.dataHandler();
		input.close();
	}
}
