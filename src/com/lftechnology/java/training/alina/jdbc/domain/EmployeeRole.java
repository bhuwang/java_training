package com.lftechnology.java.training.alina.jdbc.domain;

/**
 * EmployeeRole Class defines roles of employee
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public enum EmployeeRole {
    ADMIN("admin"), USER("user");
    private String role;

    private EmployeeRole(String role) {
        this.setRole(role);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
