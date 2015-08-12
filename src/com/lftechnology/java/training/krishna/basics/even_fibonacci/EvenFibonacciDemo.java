package com.lftechnology.java.training.krishna.basics.even_fibonacci;

import java.util.logging.Logger;


public class EvenFibonacciDemo {
	private final static Logger LOGGER = Logger.getLogger(EvenFibonacci.class.getName());
	public static void main(String[] args) {
		EvenFibonacci evenFibonacci = new EvenFibonacci(0, 1);
		int fib = evenFibonacci.sumEvenFibonacci();
		LOGGER.info("sum of even fibonacci number : "  + fib);

	}

}
