package com.lftechnology.java.training.sanish.generics.constants;

/**
 * Created by sanish on 9/7/15.
 */
public enum VehicleColor {
    RED("Red"), BLACK("Black"), WHITE("White"), RED_BLACK("Red & Black"), RED_WHITE("Red & White"), BLACK_WHITE("Black & White");
    private final String color;

    VehicleColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
