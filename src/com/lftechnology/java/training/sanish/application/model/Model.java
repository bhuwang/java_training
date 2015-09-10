package com.lftechnology.java.training.sanish.application.model;

/**
 * Db model
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public interface Model {
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
     * Check other model equal with current model
     *
     * @param model {@link Model}
     * @param <M>   {@link Model}
     * @return {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public <M extends Model> boolean equals(M model);
}
