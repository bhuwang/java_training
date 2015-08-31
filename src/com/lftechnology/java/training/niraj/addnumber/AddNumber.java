
package com.lftechnology.java.training.niraj.addnumber;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gets the number from user and produce the sum
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 */
public class AddNumber {

	private static final Logger LOGGER =
		Logger.getLogger(AddNumber.class.getName());

	private AddNumber() {

	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			int num1 = AddNumber.getNum(scanner);

			int num2 = AddNumber.getNum(scanner);
			int sum = AddNumber.add(num1, num2);
			LOGGER.log(Level.INFO, "Sum:{0}", sum);
		}
		catch (InputMismatchException e) {
			LOGGER.log(Level.WARNING, "Exception: {0}", e);
		}

	}

	/**
	 * <p>Gets the sum of two number</p>
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param num1
	 *            int
	 * @param num2
	 *            int
	 * @return sum of two numbers
	 */
	public static int add(int num1, int num2) {

		return num1 + num2;
	}

	/**
	 * Gets the number from the user
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param scanner
	 *            {@link Scanner} to scan user's input
	 * @return int
	 * @see java.util.logging.Logger
	 */
	public static int getNum(Scanner scanner) {

		LOGGER.info("Please enter the number : ");
		while (!scanner.hasNextInt()) {
			LOGGER.warning("Please provide a number : ");

		}
		return scanner.nextInt();
	}

}
