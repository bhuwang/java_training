/**
 * 
 */
package com.lftechnology.java.training.niraj.stem_leaf;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.lftechnology.java.training.alina.basic.SumOfMultiples;

/**
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class StemLeafPlot {

	static Scanner scanner = new Scanner(System.in);
	final static Logger LOGGER = Logger.getLogger(SumOfMultiples.class
			.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Please provide the number of data points:");
			while (!scanner.hasNextInt()) {
				System.out.println("Please provide the integer value:");
				scanner.next();
			}
			int dataPointLength = scanner.nextInt();
			LOGGER.info("No. of Data Points : " + dataPointLength);
			int[] dataPoints = new int[dataPointLength];
			for (int i = 0; i < dataPointLength; i++) {
				System.out.println("datapoint[" + i + "] :");
				while (!scanner.hasNextInt()) {
					System.out.println("Please provide the integer value:");
					scanner.next();
				}
				dataPoints[i] = scanner.nextInt();
			}
			LOGGER.info("Data Points : " + Arrays.toString(dataPoints));

		} catch (InputMismatchException e) {
			LOGGER.info("Invalid input is provided");
		}

	}

}
