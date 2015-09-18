package com.lftechnology.java.training.alina.jdbc.api;

import java.sql.SQLException;
import java.util.List;

import com.lftechnology.java.training.alina.jdbc.domain.Database;

/**
 * Consists of crud serives like add,edit,delete,list
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 *
 * @param <T>
 */
public interface CrudService<T> {
    /**
     * Find details based on id
     * 
     * @param id
     *            {@link Integer}
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException 
     */
    List<T> findByPk(Integer id) throws SQLException;

    /**
     * Lists all details
     * 
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException 
     */
    List<T> findAll() throws SQLException;

    /**
     * Add new record
     * 
     * @param t
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException 
     */
    T addNew(T t) throws SQLException;

    /**
     * Update record
     * 
     * @param t
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException 
     */
    Integer update(Database db) throws SQLException;

    /**
     * Delete record
     * 
     * @param s
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException 
     */
    Boolean delete(String s) throws SQLException;
}
