
package com.lftechnology.java.training.alina.basic.packagejarexecute;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>NumberPrint Class displays numbers from 1-10.</p> <p>Steps : </p> <ol
 * type="a"> <li>Create a Java application PrintNumber which prints number from
 * 1-10.</li> <li>Create Executable Jar</li> <li>Run java application from
 * command line.</li> <li>Print numbers</li> <li>Create JavaDoc of
 * Application</li> </ol>
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class NumberPrint {

	private static final Logger LOGGER =
		Logger.getLogger(NumberPrint.class.getName());

	private NumberPrint() {

	}

	/**
	 * Main Method is used to display numbers from 1-10
	 * 
	 * @param args
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public static void main(String[] args) {

		List<Integer> numbers = getNumbersWithinRange(1, 10);
		LOGGER.log(Level.INFO, "Numbers from 1-10 are : {0}", new Object[] {
			numbers
		});
	}

	/**
	 * Gets the number within range 1-10
	 * 
	 * @param from
	 *            {@link Integer}
	 * @param to
	 *            {@link Integer}
	 * @return listRange {@link List} list of numbers within 1-10
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static List<Integer> getNumbersWithinRange(int from, int to) {

		List<Integer> listRange = new ArrayList<Integer>();
		for (int i = from; i <= to; i++) {
			listRange.add(i);
		}
		return listRange;
	}
}
