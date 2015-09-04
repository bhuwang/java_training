package com.lftechnology.java.training.sanish.generics;

import java.util.List;

/**
 * VehicleList interface
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public interface VehicleList<T extends Vehicle> {
    /**
     * Return list of vehicles
     *
     * @return {@link List}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public List<T> getVehicleList();

    /**
     * Add vehicle in vehicle list
     *
     * @param vehicle {@link Vehicle}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void addVehicle(T vehicle);

    /**
     * Remove vehicle from vehicle list
     *
     * @param index {@link Integer} vehicle list index from where to remove vehicle
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void removeVehicle(int index);

    /**
     * Print list of vehicles
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void listVehicles();
}
