
package com.lftechnology.java.training.krishna.collections.generics;

/**
 * This program store vehicle information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class Vehicle {

	private String brandName;
	private int plateNumber;

	public Vehicle(String brandName, int plateNumber) {

		this.brandName = brandName;
		this.plateNumber = plateNumber;
	}

	public String getBrandName() {

		return brandName;
	}

	public void setBrandName(String brandName) {

		this.brandName = brandName;
	}

	public int getPlateNumber() {

		return plateNumber;
	}

	public void setPlateNumber(int plateNumber) {

		this.plateNumber = plateNumber;
	}

	@Override
	public String toString() {

		return "Vehicle [brandName=" + brandName + ", plateNumber=" +
			plateNumber + "]";
	}

}