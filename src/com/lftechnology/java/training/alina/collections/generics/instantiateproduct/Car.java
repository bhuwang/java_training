
package com.lftechnology.java.training.alina.collections.generics.instantiateproduct;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Car Class consists of simple log level description of car
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class Car {

	private static final Logger LOGGER = Logger.getLogger(Car.class.getName());

	public Car() {

		LOGGER.log(Level.INFO, "Constructing Class Car");
	}
}
