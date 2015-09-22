package com.lftechnology.java.training.sanish.generics.customer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Restaurant customer
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class RestaurantCustomer implements Customer {
    private static final Logger LOGGER = Logger.getLogger(BankCustomer.class.getName());
    private int customerId;
    private String customerName;
    private String customerContactNumber;
    private String restaurantName;

    private RestaurantCustomer() {
    }

    public RestaurantCustomer(int customerId, String customerName, String customerContactNumber, String restaurantName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerContactNumber = customerContactNumber;
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override public int getCustomerId() {
        return customerId;
    }

    @Override public String getCustomerName() {
        return customerName;
    }

    @Override public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    @Override public void viewCustomerInfo() {
        LOGGER.log(Level.INFO, "Bank customer information : \n" +
                        "========================================== \n" +
                        "Id : {0} \n Name : {1} \n Restaurant : {2} \n Contact Number : {3}",
                new Object[] { customerId, customerName, restaurantName, customerContactNumber });
    }

    @Override public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override public void setCustomerName(String customeName) {
        this.customerName = customeName;
    }

    @Override public void setCustomerContactNumber(String contactNumber) {
        this.customerContactNumber = contactNumber;
    }

    @Override public String toString() {
        return "Id:" + customerId + "  Name: " + customerName + " Contact Number: " + customerContactNumber + " Restaurent: "
                + restaurantName;
    }
}
