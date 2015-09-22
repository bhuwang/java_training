package com.lftechnology.java.training.sanish.generics.vehicle;

/**
 * Vehicle interface
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public interface Vehicle {
    /**
     * Return vehicle category
     *
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public String getVehicleCategory();

    /**
     * Set vehicle category
     *
     * @param vehicleCategory {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void setVehicleCategory(String vehicleCategory);

    /**
     * Return vehicle vehicle type
     *
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public String getVehicleType();

    /**
     * Set vehicle type
     *
     * @param vehicleType {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void setVehicleType(String vehicleType);

    /**
     * Return vehicle brand name
     *
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public String getBrandName();

    /**
     * Set vehicle brand
     *
     * @param vehicleBrandName {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void setBrandName(String vehicleBrandName);

    /**
     * Return vehicle color
     *
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public String getVehicleColor();

    /**
     * Set vehicle color
     *
     * @param color {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void setVehicleColor(String color);
}
