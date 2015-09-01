package com.lftechnology.java.training.alina.collections.generics.wildcards;

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
