
package com.lftechnology.java.training.alina.collections.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * CustomerUtil Class consists of comparisions of different customer
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 * @param <T>
 */
public class CustomerUtil<T extends Customer> {

	private T customer;

	public CustomerUtil(T obj) {

		this.setCustomer(obj);
	}

	public T getCustomer() {

		return customer;
	}

	public void setCustomer(T customer) {

		this.customer = customer;
	}

	public float getBill() {

		return customer.getBill();
	}

	/**
	 * Generic method to list customers
	 * 
	 * @param buttonList
	 * @return customer {@link List} lists of customers
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public static List<CustomerUtil<?>> getCustomers(
		List<CustomerUtil<?>> customerList) {

		List<CustomerUtil<?>> customers =
			new ArrayList<CustomerUtil<?>>(customerList.size());
		for (CustomerUtil<?> customer : customerList) {
			customers.add(customer);
		}
		return customers;
	}

	/**
	 * Checks if the salary is equal or not
	 * 
	 * @param otherCustomer
	 * @return
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public boolean isBillPaymentEqual(CustomerUtil<?> otherCustomer) {

		if (customer.getBill() == otherCustomer.getBill()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {

		return customer.toString();
	}
}
