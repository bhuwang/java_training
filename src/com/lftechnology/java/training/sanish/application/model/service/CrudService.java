package com.lftechnology.java.training.sanish.application.model.service;

import com.lftechnology.java.training.sanish.application.model.Model;

import java.sql.ResultSet;
import java.util.List;

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
    List<T> getAll();

    /**
     * Return all data set with specific condition
     *
     * @param condition {@link String}
     * @param parameters list of parameters
     * @return {@link ResultSet}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    <V> List<T> getAll(String condition, V... parameters);

    /**
     * Update database table row
     * @param setStatement {@link String} set statement of query
     * @param condition {@link String} condition statement of query
     * @param parameters list of parameters
     * @param <V>
     * @return {@link Integer} number of row affected
     */
    <V> int update(String setStatement, String condition, V... parameters);
}
