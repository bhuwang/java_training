package com.lftechnology.java.training.alina.collections.generics.vehiclelist;

/**
 * Defines the properties of MotorBike
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class MotorBike {

    private String brandName;

    public MotorBike(String brandName) {

        this.brandName = brandName;
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
