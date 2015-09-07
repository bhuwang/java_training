
package com.lftechnology.java.training.krishna.collections.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * This program add and remove vehicle information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class VehicleList<T extends Vehicle> {

	private static final Map<String, Vehicle> vehicles =
		new HashMap<String, Vehicle>();

	//constructor
	public VehicleList() {

	}

	/**
	 * Add vehicle on vehicle list
	 * 
	 * @param t
	 *            {@link T}
	 * @return t {@link T}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public T addVehicle(T t) {

		vehicles.put(t.getBrandName(), t);
		return t;
	}

	/**
	 * remove vehicle from vehicle list
	 * 
	 * @param t
	 *            {@link T}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public void removeVehicle(T t) {

		vehicles.remove(t.getBrandName());
	}

	/**
	 * vehicle list information
	 * 
	 * @return vehicles {@link Map}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public Map<String, Vehicle> vehicleList() {

		return vehicles;
	}

}