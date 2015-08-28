
package com.lftechnology.java.training.alina.collections.generics.vehiclelist;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a program which consists of Generic class VehicleList . In this, list
 * of cars brands and motorbike brands can be removed and added using a single
 * generic class.
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class VehicleListDemo {

	private static final Logger LOGGER =
		Logger.getLogger(VehicleListDemo.class.getName());
	private static VehicleList<Car, Integer> carList =
		new VehicleList<Car, Integer>();
	private static VehicleList<MotorBike, Integer> motorbikeList =
		new VehicleList<MotorBike, Integer>();

	private VehicleListDemo() {

	}

	/**
	 * Main function includes functionality to add/remove vehicle brands
	 * 
	 * @param args
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public static void main(String[] args) {

		addRemoveCarBrands();
		addRemoveMotorBikeBrand();

	}

	/**
	 * Function used to add/remove car brands
	 * 
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static void addRemoveCarBrands() {

		LOGGER.log(Level.INFO, "List of Car Brands :");
		motorbikeList.addVehicle(new MotorBike("Hero Honda"));
		motorbikeList.addVehicle(new MotorBike("Dio"));
		motorbikeList.addVehicle(new MotorBike("Suzuki"));
		motorbikeList.displayLists();
		motorbikeList.removeVehicle(new Integer(2));
		motorbikeList.removeVehicle(new Integer(1));
		LOGGER.log(Level.INFO, "New List of Car Brands :");
		motorbikeList.displayLists();
	}

	/**
	 * Function used to add/remove motor bike brands
	 * 
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static void addRemoveMotorBikeBrand() {

		LOGGER.log(Level.INFO, "List of Motor Bikes Brand :");
		carList.addVehicle(new Car("BMW"));
		carList.addVehicle(new Car("Ferrari"));
		carList.addVehicle(new Car("Maruti"));
		carList.displayLists();
		carList.removeVehicle(new Integer(2));
		LOGGER.log(Level.INFO, "New List of Motor Bikes Brand :");
		carList.displayLists();
	}
}
