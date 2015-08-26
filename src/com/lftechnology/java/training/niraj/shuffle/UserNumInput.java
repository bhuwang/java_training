
package com.lftechnology.java.training.niraj.shuffle;

import java.util.Scanner;

/**
 * Interface for user input of type number
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public interface UserNumInput extends UserInput<Integer> {

	/**
	 * Get the input from the user within min and max
	 * 
	 * @author Niraj Rajbhandari <nirajrajbahndari@lftechnology.com>
	 * @param min
	 * @param max
	 * @return int input provided by the user within the limits
	 */
	public int getInput(Scanner scanner, int min, int max);

	/**
	 * Get the input from the user greater than min value
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param min
	 * @return int input provided by the user greater than min value
	 */
	public int getInputMin(Scanner scanner, int min);

	/**
	 * Get the input from the user less than max value
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param max
	 * @return int input provided by the user less than the max value
	 */
	public int getInputMax(Scanner scanner, int max);
}
