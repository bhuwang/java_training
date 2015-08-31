
package com.lftechnology.java.training.krishna.collections.generics;

/**
 * This program store moterbike information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class MoterBike extends Vehicle {

	private int gears;
	private int CC;

	public MoterBike(String brandName, int plateNumber, int gears, int cC) {

		super(brandName, plateNumber);
		this.gears = gears;
		CC = cC;
	}

	public int getGears() {

		return gears;
	}

	public void setGears(int gears) {

		this.gears = gears;
	}

	public int getCC() {

		return CC;
	}

	public void setCC(int cC) {

		CC = cC;
	}

	@Override
	public String toString() {

		return "MoterBike [gears=" + gears + ", CC=" + CC + ", brandName=" +
			getBrandName() + ", plateNumber=" + getPlateNumber() +
			", toString()=" + super.toString() + ", hashCode()=" + hashCode() +
			"]";
	}

}