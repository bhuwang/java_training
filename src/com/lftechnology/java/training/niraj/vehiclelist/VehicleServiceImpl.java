package com.lftechnology.java.training.niraj.vehiclelist;

import java.util.List;

public class VehicleServiceImpl<T extends Vehicles> implements VehicleService<T, String> {

    private VehiclesDaoImpl<T> vehicleDao;

    public VehicleServiceImpl(VehiclesDaoImpl<T> vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    @Override
    public T add(T item) {
        return vehicleDao.add(item);
    }

    @Override
    public boolean remove(T item) {
        return vehicleDao.remove(item);
    }

    @Override
    public List<T> list() {
        return vehicleDao.list();
    }

    @SuppressWarnings("unchecked")
    public T findByBrand(String brand) {
        List<T> vehicleList = list();
        for (Vehicles vehicle : vehicleList) {
            if (vehicle.getBrand().equals(brand)) {
                return (T) vehicle;
            }
        }
        return null;
    }

}
