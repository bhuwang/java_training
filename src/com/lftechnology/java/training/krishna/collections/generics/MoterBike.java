
package com.lftechnology.java.training.krishna.collections.generics;

/**
 * This program store moterbike information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class MoterBike extends Vehicle {

	private int gears;
	private int cylinderVolume;

	public MoterBike(
		String brandName, int plateNumber, int gears, int cylinderVolume) {

		super(brandName, plateNumber);
		this.gears = gears;
		this.cylinderVolume = cylinderVolume;
	}

	public int getGears() {

		return gears;
	}

	public void setGears(int gears) {

		this.gears = gears;
	}

	public int getCylinderVolume() {

		return cylinderVolume;
	}

	public void setCylinderVolume(int cylinderVolume) {

		this.cylinderVolume = cylinderVolume;
	}

	@Override
	public String toString() {

		return "MoterBike [gears=" + gears + ", cylinderVolume=" +
			cylinderVolume + ", brandName=" + getBrandName() +
			", plateNumber=" + getPlateNumber() + ", toString()=" +
			super.toString() + ", hashCode()=" + hashCode() + "]";
	}

}
