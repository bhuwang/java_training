package com.lftechnology.java.training.sanish.generics.customer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Bank customer
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class BankCustomer implements Customer {
    private static final Logger LOGGER = Logger.getLogger(BankCustomer.class.getName());
    private int customerId;
    private String customerName;
    private String customerContactNumber;
    private int accountNumber;
    private String bankName;
    private String customerType;

    private BankCustomer() {
    }

    public BankCustomer(int customerId, String customerName, String customerContactNumber, int accountNumber, String bankName,
            String customerType) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerContactNumber = customerContactNumber;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.customerType = customerType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
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
                        "Id : {0} \n Name : {1} \n Bank : {2} \n Account Number {3} \n Customer Type : {4} \n Contact Number : {5}",
                new Object[] { customerId, customerName, bankName, accountNumber, customerType, customerContactNumber });
    }

    @Override public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    @Override public String toString() {
        return "Id:" + customerId + "  Name: " + customerName + " Bank: " + bankName + " Account Number: " + accountNumber
                + " Customer Type: " + customerType + " \n Contact Number: " + customerContactNumber + "";
    }
}
