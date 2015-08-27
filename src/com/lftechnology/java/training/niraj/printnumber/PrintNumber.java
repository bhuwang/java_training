/**
 * 
 */

package com.lftechnology.java.training.niraj.printnumber;

import java.util.logging.Logger;

/**
 * Prints number from <code>1</code> to <code>10</code>
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 * @see java.lang.StringBuilder
 */
public class PrintNumber {

	private static final Logger LOGGER =
		Logger.getLogger(PrintNumber.class.getName());

	private PrintNumber() {

	}

	public static void main(String[] args) {

		StringBuilder numbers = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			numbers.append("\n- " + i);
		}
		LOGGER.info(numbers.toString());
	}

}
