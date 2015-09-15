package com.lftechnology.java.training.niraj.ems.enums;

import com.lftechnology.java.training.niraj.ems.utils.Constants;

public enum Status {
    ACTIVE("1"), INACTIVE("0");

    private final String ISACTIVE = "Yes";
    private final String ISINACTIVE = "No";
    private final String isActive;

    private Status(String isActive) {
        this.isActive = isActive;
    }

    public String getStatus() {
        return isActive;
    }

    public String getStatusString() {
        if (isActive != null && isActive.equals(Constants.ACTIVE)) {
            return ISACTIVE;
        } else {
            return ISINACTIVE;
        }
    }
}
