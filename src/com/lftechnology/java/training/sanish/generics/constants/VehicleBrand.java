package com.lftechnology.java.training.sanish.generics.constants;

/**
 * Provide vehicle brand name
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public enum VehicleBrand {
    BMW("BMW"), FERRARI("Ferrari"), KIA("Kia"), FORD("Ford"), YAMAHA("Yamaha"), HONDA("Honda"), ATK("ATK"), BAJAJ("Bajaj"),;
    private String brandName;

    VehicleBrand(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }
}
