package com.lftechnology.java.training.sanish.generics.vehicle;

/**
 * MotorBike class
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class MotorBike implements Vehicle {
    private String vehicleCategory = "Two Wheel vehicle";
    private String vehicleType = "Bike";
    private String brandName;
    private String color;

    private MotorBike() {
    }

    public MotorBike(String brandName, String color) {
        this.brandName = brandName;
        this.color = color;
    }

    @Override public String getVehicleCategory() {
        return this.vehicleCategory;
    }

    @Override public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    @Override public String getVehicleType() {
        return this.vehicleType;
    }

    @Override public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override public String getBrandName() {
        return this.brandName;
    }

    @Override public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override public String getVehicleColor() {
        return this.color;
    }

    @Override public void setVehicleColor(String color) {
        this.color = color;
    }

    @Override public String toString() {
        return brandName + '\t' + color;
    }
}
