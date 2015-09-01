package com.lftechnology.java.training.alina.collections.generics.vehiclelist;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * VehicleList Class consists of operations to add/remove vehicles
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 * @param <T>
 * @param <K>
 */
public class VehicleList<T, K extends Number> implements Vehicles<T, K> {

    private static final Logger LOGGER = Logger.getLogger(VehicleList.class.getName());
    private List<T> list = new ArrayList<T>();

    /**
     * Adds vehicle lists
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    @Override
    public void addVehicle(T element) {
        list.add(element);
    }

    /**
     * Removes vehicle brand from list
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    @Override
    public void removeVehicle(K indexValue) {
        if (indexValue.intValue() >= list.size()) {
            LOGGER.log(Level.WARNING, "Failed to remove vehicle. No vehicle is found with index {0}", indexValue.intValue());
        } else {
            list.remove(indexValue.intValue());
        }
    }

    /**
     * Gets elemets in list form
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    @Override
    public void displayLists() {
        LOGGER.log(Level.INFO, "{0}", new Object[] { list });
    }
}
