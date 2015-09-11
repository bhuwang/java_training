package com.lftechnology.java.training.alina.jdbc.api;

import java.util.List;

public interface CrudService<T> {
    /**
     * Find details based on id
     * 
     * @param id
     *            {@link Integer}
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    T findByPk(Integer id);

    /**
     * Lists all details
     * 
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    List<T> findAll();

    /**
     * Add new record
     * 
     * @param t
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    int addNew(T t);

    /**
     * Update record
     * 
     * @param t
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    T update(T t);

    /**
     * Delete record
     * 
     * @param s
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    boolean delete(String s);
}
