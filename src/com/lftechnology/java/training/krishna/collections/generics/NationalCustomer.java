
package com.lftechnology.java.training.krishna.collections.generics;

/**
 * This program store national customer information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class NationalCustomer extends Customer {

	private double salary;

	public NationalCustomer(String customerName, String email, double salary) {

		super(customerName, email);
		this.salary = salary;
	}

	public double getSalary() {

		return salary;
	}

	public void setSalary(double salary) {

		this.salary = salary;
	}

	@Override
	public String toString() {

		return "NationalCustomer [salary=" + salary + ", getCustomerName()=" +
			getCustomerName() + ", getEmail()=" + getEmail() + ", toString()=" +
			super.toString() + ", getClass()=" + getClass() + ", hashCode()=" +
			hashCode() + "]";
	}

}