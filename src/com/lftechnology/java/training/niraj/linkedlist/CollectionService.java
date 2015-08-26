
package com.lftechnology.java.training.niraj.linkedlist;

import java.util.Collections;

/**
 * Interface for Services related to {@link Collections}
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 * @param <T>
 */
public interface CollectionService<T> {

	/**
	 * Merge two Collections
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param firstCollection
	 *            {@link Collections}
	 * @param secondCollection
	 *            {@link Collections}
	 */
	public void merge(T firstCollection, T secondCollection);

	/**
	 * Removes all the elements available in certain Collection from another
	 * collection
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param collection
	 *            {@link Collections}
	 * @param collectionToRemove
	 *            {@link Collections}
	 */
	public void remove(T collection, T collectionToRemove);

	/**
	 * Removes all the elements from a Collection of certain {@link Parity}
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param collection
	 *            {@link Collections}
	 * @param p
	 *            {@link Parity}
	 */
	public void remove(T collection, Parity p);
}
