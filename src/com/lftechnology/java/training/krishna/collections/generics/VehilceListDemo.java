
package com.lftechnology.java.training.krishna.collections.generics;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a program which consists of Generic class VehicleList . In this, list of cars brands and motorbike brands can be removed and added using a single generic class.
 */

/**
 * This program is used to dispaly vehicle list
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class VehilceListDemo {

	private static final Logger LOGGER =
		Logger.getLogger(VehilceListDemo.class.getName());

	// constructor
	private VehilceListDemo() {

	}

	public static void main(String[] args) {

		VehicleList<Vehicle> vehicles = new VehicleList<Vehicle>();
		vehicles.addVehicle(new Car("BMW", 23, 2, 40));
		vehicles.addVehicle(new MoterBike("Hero Honda", 23, 3, 50));
		
		LOGGER.log(Level.INFO, "After adding vehicle list: {0}", new Object[] {
			vehicles.vehicleList()
		});

		vehicles.removeVehicle(new Car("BMW", 23, 2, 40));
		
		LOGGER.log(Level.INFO, "After removing vehicle list: {0}", new Object[] {
			vehicles.vehicleList()
		});

	}

}