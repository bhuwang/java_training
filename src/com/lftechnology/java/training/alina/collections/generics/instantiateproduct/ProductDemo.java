
package com.lftechnology.java.training.alina.collections.generics.instantiateproduct;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Create a generic class Product with a display method and instantiate an
 * object of Product using different data types. Eg : Product<String,String> ,
 * Product<String,Integer>
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class ProductDemo {

	private static final Logger LOGGER =
		Logger.getLogger(ProductDemo.class.getName());

	private ProductDemo() {

	}

	/**
	 * Main Class consists of display of products in terms of different data
	 * types
	 * 
	 * @param args
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public static void main(String[] args)
		throws InstantiationException, IllegalAccessException {

		displayInStringStringForm();
		displayInStringIntForm();
		displayInIntBooleanForm();
	}

	/**
	 * Display Product in int,boolean form
	 * 
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static void displayInIntBooleanForm() {

		Product<Integer, Boolean> productIntBool =
			new Product<Integer, Boolean>(1, true);
		LOGGER.log(Level.INFO, "{0}", productIntBool);
	}

	/**
	 * Display Product in string,int form
	 * 
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static void displayInStringIntForm() {

		Product<String, Integer> productStringInt =
			new Product<String, Integer>("Goggles", 5);
		LOGGER.log(Level.INFO, "{0}", productStringInt);
	}

	/**
	 * Display Product in string,string form
	 * 
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static void displayInStringStringForm() {

		Product<String, String> productString =
			new Product<String, String>("Bike", "Cards");
		LOGGER.log(Level.INFO, "{0}", productString);
	}
}
