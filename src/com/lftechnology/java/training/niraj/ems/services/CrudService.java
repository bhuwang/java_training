package com.lftechnology.java.training.niraj.ems.services;

import java.sql.SQLException;

import com.lftechnology.java.training.niraj.ems.exceptions.CustomException;

public interface CrudService<T, S> {

    /**
     * Saves information
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param t
     * @return
     * @throws Exception
     */
    public T save(T t) throws SQLException;

    /**
     * Finds a record
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param s
     * @return
     * @throws Exception
     */
    public T find(S s) throws SQLException;

    /**
     * Updates a record
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param t
     * @return
     * @throws Exception
     */
    public boolean update(T t) throws SQLException,CustomException;
}
