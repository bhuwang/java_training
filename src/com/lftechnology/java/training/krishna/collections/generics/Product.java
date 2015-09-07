
package com.lftechnology.java.training.krishna.collections.generics;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program set and get product information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class Product<T, V> {

	private static final Logger LOGGER =
		Logger.getLogger(Product.class.getName());
	private T product1;
	private V product2;

	public Product(T product1, V product2) {

		this.product1 = product1;
		this.product2 = product2;
	}

	public T getProduct1() {

		return product1;
	}

	public void setProduct1(T product1) {

		this.product1 = product1;
	}

	public V getProduct2() {

		return product2;
	}

	public void setProduct2(V product2) {

		this.product2 = product2;
	}

	@Override
	public String toString() {

		return "Product [product1=" + product1 + ", product2=" + product2 + "]";
	}

	/**
	 * product list information
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public void displayInformation() {

		LOGGER.log(Level.INFO, "Type of T is: {0}, Value: {1}", new Object[] {
			product1.getClass().getName(), getProduct1()
		});
		LOGGER.log(Level.INFO, "Type of V is: {0}, Value: {1}", new Object[] {
			product2.getClass().getName(), getProduct2()
		});
	}

}