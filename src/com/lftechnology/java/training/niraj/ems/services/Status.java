package com.lftechnology.java.training.niraj.ems.services;

public enum Status {
    ACTIVE("1"), INACTIVE("0");

    private final String isActive;

    private Status(String isActive) {
        this.isActive = isActive;
    }

    public String getStatus() {
        return isActive;
    }
}
