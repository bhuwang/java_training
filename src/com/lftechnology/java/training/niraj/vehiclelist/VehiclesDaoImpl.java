package com.lftechnology.java.training.niraj.vehiclelist;

import java.util.ArrayList;
import java.util.List;

public class VehiclesDaoImpl<T extends Vehicles> implements CrudService<T> {
    protected List<T> vehicleList = new ArrayList<T>();

    @Override
    public T add(T item) {
        vehicleList.add(item);
        return item;
    }

    @Override
    public boolean remove(T item) {
        return vehicleList.remove(item);
    }

    @Override
    public List<T> list() {
        return vehicleList;
    }

}
