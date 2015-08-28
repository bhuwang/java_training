
package com.lftechnology.java.training.alina.collections.generics.vehiclelist;

/**
 * Defines the properties of Car
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class Car {

	private String brandName;

	public Car(String brandName) {

		this.setBrandName(brandName);
	}

	public String getBrandName() {

		return brandName;
	}

	public void setBrandName(String brandName) {

		this.brandName = brandName;
	}

	@Override
	public String toString() {

		return brandName;
	}
}
