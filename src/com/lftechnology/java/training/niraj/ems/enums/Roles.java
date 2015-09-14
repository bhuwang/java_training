package com.lftechnology.java.training.niraj.ems.services;

public enum Roles {
    ADMIN("admin"), USER("user");

    private final String role;

    private Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
