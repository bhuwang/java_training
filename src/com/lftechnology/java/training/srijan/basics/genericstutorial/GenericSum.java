package com.lftechnology.java.training.srijan.basics.genericstutorial;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Write a program in which Generic method is used to sum Integer or Double.
 * 
 * @author srijan
 *
 */
public class GenericSum {

	private static final Logger LOGGER = Logger.getLogger(GenericSum.class.getName());

	private GenericSum() {

	}

	/**
	 * <p>
	 * Asks user if they will input integer or double number
	 * </p>
	 * 
	 * @author srijan
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String decision = "";
		GenericSumCalculator genericSumCalculator = new GenericSumCalculator();
		LOGGER.info("To take integer input press i or I and for double press d or D");
		decision = input.nextLine();

		if ("i".equals(decision) || "I".equals(decision)) {
			genericSumCalculator.inputIntegerData();
		} else if ("d".equals(decision) || "D".equals(decision)) {
			genericSumCalculator.inputDoubleData();
		} else {
			LOGGER.info("Wrong input decision please check carefully");
		}
		input.close();
	}
}
