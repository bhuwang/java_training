
package com.lftechnology.java.training.alina.collections.generics.vehiclelist;

/**
 * Vehicles Interface is used to add and remove vehicles
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 * @param <T>
 * @param <K>
 */
public interface Vehicles<T, K extends Number> {

	/**
	 * Adds vehicle list
	 * 
	 * @param element
	 *            {@link Object}
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	void addVehicle(T element);

	/**
	 * Removes vehicle element
	 * 
	 * @param element
	 *            {@link Integer}
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	void removeVehicle(K element);

	/**
	 * Displays vehicle list
	 * 
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	void displayLists();
}
