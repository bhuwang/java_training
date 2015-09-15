package com.lftechnology.java.training.alina.jdbc.api;

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
     */
    List<T> findByPk(Integer id);

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
    T addNew(T t);

    /**
     * Update record
     * 
     * @param t
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    Integer update(Database db);

    /**
     * Delete record
     * 
     * @param s
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    Boolean delete(String s);
}
