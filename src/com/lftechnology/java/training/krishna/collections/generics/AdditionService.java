
package com.lftechnology.java.training.krishna.collections.generics;

/**
 * Sum operation between two numbers.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */

public interface AdditionService<T extends Number> {

	/**
	 * Calculate sum between two numbers
	 *
	 * @param number1
	 *            {@link T}
	 * @param number2
	 *            {@link T}
	 * @return T
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	T add(T number1, T number2);
}
