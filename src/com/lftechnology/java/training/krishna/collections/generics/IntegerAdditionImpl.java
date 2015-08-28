
package com.lftechnology.java.training.krishna.collections.generics;

/**
 * Sum operation between two integer numbers.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class IntegerAdditionImpl implements AdditionService<Number> {

	@Override
	public Number add(Number number1, Number number2) {

		return number1.intValue() + number2.intValue();
	}

}
