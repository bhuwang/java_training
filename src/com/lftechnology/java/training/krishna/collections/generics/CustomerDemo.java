
package com.lftechnology.java.training.krishna.collections.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *  Write a method which takes List of any subclass of object Customer. (use wildcard)
 */
/**
 * This program is used to dispaly customer information
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */

public class CustomerDemo {

	// constructor
	private CustomerDemo() {

	}

	public static void main(String[] args) {

		CustomerRecord customerRecord = new CustomerRecord();
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new InternationalCustomer(
			"Hari", "hari@gmail.com", 300.89));
		customerList.add(new NationalCustomer(
			"Jenny", "jenny@yahoo.com", 200.89));
		customerRecord.displayList(customerList);

	}

}
