
package com.lftechnology.java.training.alina.collections.generics.instantiateproduct;

/**
 * Product Class consists of products of different data types
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 * @param <T1>
 * @param <T2>
 */
public class Product<T1, T2> {

	private T1 product1;
	private T2 product2;

	public Product(T1 product1, T2 product2) {

		this.setProduct1(product1);
		this.setProduct2(product2);
	}

	public T1 getProduct1() {

		return product1;
	}

	public void setProduct1(T1 product1) {

		this.product1 = product1;
	}

	public T2 getProduct2() {

		return product2;
	}

	public void setProduct2(T2 product2) {

		this.product2 = product2;
	}

	@Override
	public String toString() {

		return "\tProduct1" + "\tType : " + product1.getClass().getName() +
			"\t\tValue : " + getProduct1() + "\n\tProduct2" + "\tType : " +
			product2.getClass().getName() + "    \tValue : " + getProduct2();
	}
}
