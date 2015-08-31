
package com.lftechnology.java.training.alina.collections.generics.wildcards;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a method which takes List of any subclass of object Customer. (use
 * wildcard)
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class WildcardDemo {

	private static final Logger LOGGER =
		Logger.getLogger(WildcardDemo.class.getName());
	private static List<CustomerUtil<?>> customerList =
		new ArrayList<CustomerUtil<?>>();

	private WildcardDemo() {

	}

	/**
	 * Main Class consists of display different sub classes and comparisions
	 * 
	 * @param args
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public static void main(String[] args) {

		CustomerUtil<CustomerA> customerA =
			new CustomerUtil<CustomerA>(new CustomerA(
				"Ram Shah", "Patan", 20000));
		CustomerUtil<CustomerB> customerB =
			new CustomerUtil<CustomerB>(new CustomerB(
				"Kapil Singh", "Kathmandu", 30000));
		CustomerUtil<CustomerA> customerC =
			new CustomerUtil<CustomerA>(new CustomerA(
				"Nagesh Pun", "Bhaktapur", 20000));
		displayCustomerLists(customerA, customerB, customerC);
		compareCustomerPayment(customerA, customerB, customerC);

	}

	/**
	 * Compares bill payment of customers
	 * 
	 * @param customerA
	 * @param customerB
	 * @param customerC
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static void compareCustomerPayment(
		CustomerUtil<CustomerA> customerA, CustomerUtil<CustomerB> customerB,
		CustomerUtil<CustomerA> customerC) {

		LOGGER.log(
			Level.INFO,
			"Is payment of {0} and {1} are same ? {2}",
			new Object[] {
				customerA.getCustomer().getName(),
				customerB.getCustomer().getName(),
				customerA.isBillPaymentEqual(customerB)
			});
		LOGGER.log(
			Level.INFO,
			"Is payment of {0} and {1} are same ? {2}",
			new Object[] {
				customerA.getCustomer().getName(),
				customerC.getCustomer().getName(),
				customerA.isBillPaymentEqual(customerC)
			});
	}

	/**
	 * Display all customer lists
	 * 
	 * @param customerA
	 * @param customerB
	 * @param customerC
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	private static void displayCustomerLists(
		CustomerUtil<?> customerA, CustomerUtil<CustomerB> customerB,
		CustomerUtil<CustomerA> customerC) {

		customerList.add(customerA);
		customerList.add(customerB);
		customerList.add(customerC);
		List<CustomerUtil<?>> customerDisplay =
			CustomerUtil.getCustomers(customerList);
		LOGGER.log(Level.INFO, "{0}", customerDisplay);
	}

}
