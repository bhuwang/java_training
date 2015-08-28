
package com.lftechnology.java.training.krishna.collections.generics;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Write a program in which Generic method is used to sum Integer or Double. 
 */

/**
 * This program used to sum two numbers
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class AdditionDemo {

	private static final Logger LOGGER =
		Logger.getLogger(AdditionDemo.class.getName());

	//constructor
	private AdditionDemo() {

	}


	public static void main(String[] args) {

		IntegerAdditionImpl integerNumber = new IntegerAdditionImpl();
		Integer intVal = (Integer) integerNumber.add(34, 35);
		LOGGER.log(Level.INFO, "Sum of two integer number: {0}", intVal);
		DoubleAdditionImpl doubleNumber = new DoubleAdditionImpl();
		Double doubleVal = (Double) doubleNumber.add(34.6f, 35.5f);
		LOGGER.log(Level.INFO, "Sum of two float number: {0}", doubleVal);
		FloatAdditionImpl floatNumber = new FloatAdditionImpl();
		Float floatVal = (Float) floatNumber.add(50.5, 35.6);
		LOGGER.log(Level.INFO, "Sum of two double number: {0}", floatVal);
	}

}
