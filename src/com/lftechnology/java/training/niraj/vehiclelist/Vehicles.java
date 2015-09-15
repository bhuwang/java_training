package com.lftechnology.java.training.niraj.vehiclelist;

/**
 * Defines the properties of a vehicle
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class Vehicles {
    protected String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return brand;
    }
}
