
package com.lftechnology.java.training.alina.collections.generics.wildcards;

/**
 * Class Customer consists of information of customers
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class Customer {

	private String name;
	private String address;
	private float bill;

	public Customer(String name, String address, float salary) {

		this.name = name;
		this.address = address;
		this.bill = salary;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public float getBill() {

		return bill;
	}

	public void setBill(float bill) {

		this.bill = bill;
	}

	@Override
	public String toString() {

		return "Name : " + getName() + ", Address : " + getAddress() +
			", Salary : " + getBill() + "\n";
	}
}
