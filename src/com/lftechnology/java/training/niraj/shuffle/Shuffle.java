
package com.lftechnology.java.training.niraj.shuffle;

/**
 * Interface related to shuffling of given type of collection
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 * @param <T>
 */
public interface Shuffle<T> {

	/**
	 * Shuffles the list
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param itemList
	 *            T
	 */
	public T shuffleList(T itemList);

	/**
	 * Get sub list
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param itemList
	 * @param subListLength
	 * @return T
	 */
	public T getSubList(T itemList, int subListLength);

	/**
	 * Sorts list
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @param itemList
	 */
	public T sortList(T itemList);

}
