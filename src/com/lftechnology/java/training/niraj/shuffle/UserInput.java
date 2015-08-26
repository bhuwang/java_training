
package com.lftechnology.java.training.niraj.shuffle;

import java.util.Scanner;

public interface UserInput<T> {

	

	/**
	 * Get the input from the user
	 * 
	 * @author Niraj Rajbhandari <nirajrajbahndari@lftechnology.com>
	 * @param min
	 * @param max
	 * @return int input provided by the user
	 */
	public T getInput(Scanner scanner);
}
