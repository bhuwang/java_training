package com.lftechnology.java.training.srijan.basics;

import java.util.logging.Logger;

public class FabonacciNumber {

	private static final Logger LOGGER = Logger.getLogger(FabonacciNumber.class.getName());

	public static void main(String[] args) {
		Fabonacci fabonacci = new Fabonacci(0, 1);
		LOGGER.info("FirstNumber of Fabonacci series is:" + fabonacci.getFirstNumber());
		LOGGER.info("SecondNumber of Fabonacci series is:" + fabonacci.getSecondNumber());
		fabonacci.displayFabonacciNumber();
		fabonacci.displaySumOfEvenFabonacciNumber();

	}
}
