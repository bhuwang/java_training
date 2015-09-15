package com.lftechnology.java.training.niraj.vehiclelist;

import java.util.List;

/**
 * Interface for crud services
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 * @param <T>
 * @param <S>
 */
public interface CrudService<T extends Vehicles> {

    /**
     * Adds an object of sub class of Vehicles
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param item
     *            object of sub class of {@link Vehicles}
     * @return added object that is sub class of {@link Vehicles}
     * 
     */
    public T add(T item);

    /**
     * Removes an object of sub class of {@link Vehicles}
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param item
     *            object of sub class of {@link Vehicles}
     * @return Boolean
     */
    public boolean remove(T item);

    /**
     * Lists all the objects of subclass of {@link Vehicles} added
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @return {@link List} of objects of subclass of {@link Vehicles}
     */
    public List<T> list();
}
