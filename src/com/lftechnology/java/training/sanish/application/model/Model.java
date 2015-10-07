package com.lftechnology.java.training.sanish.application.model;

import java.sql.ResultSet;

/**
 * Db model interface
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public interface Model{
    /**
     * Return table name
     *
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public String getTable();

    /**
     * Return value of attribute
     *
     * @param key {@link String} attribute name
     * @param <V>
     * @return
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public <V> V getAttribute(String key);

    /**
     * Set value of attribute
     *
     * @param key {@link String} attribute name
     * @param <V>
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public <V> void setAttribute(String key, V value);

    /**
     * Set properties of model with supplied result set
     *
     * @param rs       {@link ResultSet}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void  setResultSetAttributes(ResultSet rs);
}
