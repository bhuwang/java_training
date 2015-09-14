package com.lftechnology.java.training.niraj.ems.enums;

public enum Status {
    ACTIVE("1"), INACTIVE("0");

    private final String IS_ACTIVE = "Yes";
    private final String IS_INACTIVE = "No";
    private final String isActive;

    private Status(String isActive) {
        this.isActive = isActive;
    }

    public String getStatus() {
        return isActive;
    }

    public String getStatusString() {
        if (isActive.equals("1")) {
            return IS_ACTIVE;
        } else {
            return IS_INACTIVE;
        }
    }
}
