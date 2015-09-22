package com.lftechnology.java.training.sanish.generics.constants;

import java.io.Serializable;

/**
 * Person information
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 2405172041950251808L;
    private String name;
    private String address;
    private String contactNumber;

    private Person() {
    }

    public Person(String name, String address, String contactNumber) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
