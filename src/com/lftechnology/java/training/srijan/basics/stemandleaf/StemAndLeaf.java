package com.lftechnology.java.training.srijan.basics.stemandleaf;

import java.util.Scanner;
import java.util.logging.Logger;

public class StemAndLeaf {
	
	private static final Logger LOGGER = Logger.getLogger(StemAndLeaf.class.getName());
	
	private StemAndLeaf(){
		
	}
	
	public static void main(String[] args){
		int numberOfDatas = 0;
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter number of Data Points:");
		numberOfDatas = input.nextInt();
		DataPresentation stemAndleaf = new DataPresentation(numberOfDatas);
		stemAndleaf.dataHandler();
		input.close();
	}
}
