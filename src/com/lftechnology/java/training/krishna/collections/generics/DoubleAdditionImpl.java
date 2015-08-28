
package com.lftechnology.java.training.krishna.collections.generics;

/**
 * Sum operation between two double numbers.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class DoubleAdditionImpl implements AdditionService<Number> {

	@Override
	public Number add(Number number1, Number number2) {

		return number1.doubleValue() + number2.doubleValue();
	}

}
