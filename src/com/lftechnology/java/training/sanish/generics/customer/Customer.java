package com.lftechnology.java.training.sanish.generics.customer;

/**
 * Customer interface
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public interface Customer {
    /**
     * Return customer id
     *
     * @return {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public int getCustomerId();

    /**
     * Return customer name
     *
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public String getCustomerName();

    /**
     * Return customer contact number
     *
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public String getCustomerContactNumber();

    /**
     * Display customer information
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void viewCustomerInfo();

    /**
     * Set customer id
     * @param customerId {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void setCustomerId(int customerId);

    /**
     * Set customer name
     * @param customeName {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void setCustomerName(String customeName);

    /**
     * Set customer contact number
     * @param contactNumber {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void setCustomerContactNumber(String contactNumber);
}
