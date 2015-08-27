
package com.lftechnology.java.training.alina.collections.generics.integerdoublesum;

import java.util.List;

/**
 * CalculateSum Class consists of calculations (sum) of numbers
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 * @param <T>
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class CalculateSum<T extends Number> {

	public CalculateSum() {

	}

	/**
	 * Used to get the sum of numbers
	 * 
	 * @param list
	 *            {@link List}
	 * @param adder
	 * @return total {@link Number} total sum of numbers
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public T getSumOfNumbers(List<T> list, NumberAdder<T> adder) {

		T total = adder.initialize();
		for (T n : list) {
			total = adder.add(total, n);
		}
		return total;
	}
}
