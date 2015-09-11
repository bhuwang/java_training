package com.lftechnology.java.training.alina.jdbc.api;

import java.util.List;

public interface CrudService<T, I extends Number, B, S> {
    /**
     * Find details based on id
     * 
     * @param id
     *            {@link String}
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    T findByPk(String id);

    /**
     * Lists all details
     * 
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    List<T> findAll();

    /**
     * Add new details
     * 
     * @param t
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    I addNew(T t);

    /**
     * Update details
     * 
     * @param t
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    T update(T t);

    B delete(S i);
}
