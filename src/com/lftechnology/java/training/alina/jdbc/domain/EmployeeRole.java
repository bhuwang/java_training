package com.lftechnology.java.training.alina.jdbc.domain;

public enum EmployeeRole {
    ADMIN("admin"), USER("user");
    public String role;

    private EmployeeRole(String role) {
        this.role = role;
    }
}
