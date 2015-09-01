
package com.lftechnology.java.training.krishna.collections.generics;

/**
 * This program store customer information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class Customer {

	private String customerName;
	private String email;

	public Customer(String customerName, String email) {

		this.customerName = customerName;
		this.email = email;
	}

	public String getCustomerName() {

		return customerName;
	}

	public void setCustomerName(String customerName) {

		this.customerName = customerName;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	@Override
	public String toString() {

		return "Customer [customerName=" + customerName + ", email=" + email +
			"]";
	}

}