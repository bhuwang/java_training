
package com.lftechnology.java.training.krishna.collections.generics;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program is used to display customer name and email
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class CustomerRecord {

	private static final Logger LOGGER =
		Logger.getLogger(CustomerRecord.class.getName());

	public CustomerRecord() {

	}

	/**
	 * This method is used to console the customer name and email
	 *
	 * @param customerList
	 *            {@link List}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public void displayList(List<? extends Customer> customerList) {

		for (Customer customer : customerList) {
			LOGGER.log(
				Level.INFO, "Customer Name: {0}, Email: {1}", new Object[] {
					customer.getCustomerName(), customer.getEmail()
				});
		}
	}
}