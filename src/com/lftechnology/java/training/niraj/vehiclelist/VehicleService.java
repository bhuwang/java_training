package com.lftechnology.java.training.niraj.vehiclelist;


public interface VehicleService<T extends Vehicles, S> extends CrudService<T> {
    /**
     * Searches vehicle
     * 
     * @author Niraj Rajbhandari<nirajrajbhandari@lftechnology.com>
     * @param s
     *            search parameter
     * @return object of subclass of {@link Vehicles}
     */
    public T findByBrand(S s);

}
