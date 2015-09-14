
package com.lftechnology.java.training.krishna.employeemanagement.dao;

import java.io.Serializable;
import java.util.List;

/**
 * This program is used to perform different action such as create update.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public interface GenericDao<T, PK extends Serializable> {

	/**
	 * create users
	 *
	 * @param entity
	 *            {@link T}
	 * @return T
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public T create(T entity);

	/**
	 * find user by id
	 *
	 * @param id
	 * @return T
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */

	public T findById(PK id);

	/**
	 * update users
	 *
	 * @param entity
	 *            {@link T}
	 * @return T
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public T update(T entity);

	/**
	 * delete users
	 *
	 * @param entity
	 *            {@link T}
	 * @return boolean
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public boolean delete(T entity);

	/**
	 * list users
	 *
	 * @param key
	 *            {@link String}
	 * @return T {@link List}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public List<T> findAll(String key);

}
