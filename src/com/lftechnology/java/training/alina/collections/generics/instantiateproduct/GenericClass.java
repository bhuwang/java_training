
package com.lftechnology.java.training.alina.collections.generics.instantiateproduct;

/**
 * GenericClass consists of Class definition of classes
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 * @param <T>
 */
public class GenericClass<T> {

	private Class<T> classDetail;

	public GenericClass(Class<T> classDetail) {

		this.classDetail = classDetail;
	}

	/**
	 * Builds new instance class
	 * 
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public T buildOne()
		throws InstantiationException, IllegalAccessException {

		return classDetail.newInstance();
	}
}
