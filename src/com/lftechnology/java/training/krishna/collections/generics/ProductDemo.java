
package com.lftechnology.java.training.krishna.collections.generics;

/**
 * Create a generic class Product with a display method and instantiate an object of Product using different data types.
 * Eg : Product<String,String> , Product<String,Integer>
 */
/**
 * This program is used to instantiate an object of Product using different data
 * types.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class ProductDemo {

	// constructor
	private ProductDemo() {

	}

	public static void main(String[] args) {

		Product<String, String> strObject =
			new Product<String, String>("Acura", "Arash");
		strObject.displayInformation();

		Product<String, Integer> intObject =
			new Product<String, Integer>("Alfa Romeo", 1);
		intObject.displayInformation();

		Product<String, Float> floatObject =
			new Product<String, Float>("Ascari", 1.5f);
		floatObject.displayInformation();

		Product<String, Boolean> boolObject =
			new Product<String, Boolean>("Audi", true);
		boolObject.displayInformation();

		Product<Car, Boolean> carObject =
			new Product<Car, Boolean>(new Car("BMW", 23, 2, 40), true);
		carObject.displayInformation();

	}

}