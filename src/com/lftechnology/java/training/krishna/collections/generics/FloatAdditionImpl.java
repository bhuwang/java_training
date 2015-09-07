
package com.lftechnology.java.training.krishna.collections.generics;

/**
 * Sum operation between two float numbers.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class FloatAdditionImpl implements AdditionService<Number> {

	@Override
	public Number add(Number number1, Number number2) {

		return number1.floatValue() + number2.floatValue();
	}

}