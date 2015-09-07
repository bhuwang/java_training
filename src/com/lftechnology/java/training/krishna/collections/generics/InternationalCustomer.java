
package com.lftechnology.java.training.krishna.collections.generics;

/**
 * This program store international customer information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class InternationalCustomer extends Customer {

	private double salary;

	public InternationalCustomer(
		String customerName, String email, double salary) {

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

		return "InternationalCustomer [salary=" + salary +
			", getCustomerName()=" + getCustomerName() + ", getEmail()=" +
			getEmail() + ", toString()=" + super.toString() + ", getClass()=" +
			getClass() + ", hashCode()=" + hashCode() + "]";
	}

}