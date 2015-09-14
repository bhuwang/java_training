package com.lftechnology.java.training.niraj.ems.services;

public interface CrudService<T, S> {

    /**
     * Saves information
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param t
     * @return
     * @throws Exception
     */
    public T save(T t) throws Exception;

    /**
     * Finds a record
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param s
     * @return
     * @throws Exception
     */
    public T find(S s) throws Exception;

    /**
     * Updates a record
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param t
     * @return
     * @throws Exception
     */
    public boolean update(T t) throws Exception;
}
