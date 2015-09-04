package com.lftechnology.java.training.sanish.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * VehicleList implementation class
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class VehicleListImpl<T extends Vehicle> implements VehicleList {
    private static final Logger LOGGER = Logger.getLogger(VehicleListImpl.class.getName());
    private List<T> vehicleList = new ArrayList<T>();

    @Override public List<T> getVehicleList() {
        return this.vehicleList;
    }

    @Override public void addVehicle(Vehicle vehicle) {
        vehicleList.add((T) vehicle);
    }

    @Override public void removeVehicle(int index) {
        vehicleList.remove(index);
    }

    @Override public void listVehicles() {
        String vehicleListText = "";
        int count = 0;
        for (T vehicle : vehicleList) {
            count++;
            vehicleListText += count + vehicle.toString();
        }

        LOGGER.log(Level.INFO, "Car list : \n" +
                "==================================== \n" +
                "Sn. \t Brand \t color \n" +
                "==================================== \n" +
                "{0}", new Object[] { vehicleListText });
    }
}

