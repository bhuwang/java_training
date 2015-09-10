package com.lftechnology.java.training.sanish.application.model.service;

import com.lftechnology.java.training.sanish.application.model.Model;

import java.sql.ResultSet;

/**
 * Crud service interface
 *
 * @param <T> {@link Model}
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public interface CrudService<T extends Model> {

    /**
     * Add new data row
     *
     * @param t {@link Model}
     * @return {@link Model}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public T addNew(T t);

    /**
     * Return result set by primary key value
     *
     * @param pk {@link Integer} primary key value
     * @return {@link Model}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public T findById(Integer pk);

    /**
     * Return all data set
     *
     * @return {@link ResultSet}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    ResultSet getAll();

    /**
     * Return all data set with specific condition
     *
     * @param condition {@link String}
     * @return {@link ResultSet}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    ResultSet getAll(String condition);
}
