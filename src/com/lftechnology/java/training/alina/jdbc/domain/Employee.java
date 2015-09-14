package com.lftechnology.java.training.alina.jdbc.domain;

import java.sql.Timestamp;

/**
 * Employee Class consists of Employee parameters
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class Employee extends User implements Comparable<Employee> {
    private int employeeId;
    private String fullname;
    private String department;
    private String address;
    private String role;
    private int userId;
    private boolean isDeleted;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public enum EmployeeRole {
        ADMIN("admin"), USER("user");
        public String role;

        private EmployeeRole(String role) {
            this.role = role;
        }
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public int compareTo(Employee otherEmployee) {
        return fullname.compareTo(otherEmployee.fullname);
    }

    @Override
    public String toString() {
        return "Full Name : " + fullname + ", Address : " + address + ", Department : " + department + ", Role : " + role + ", "
                + super.toString()
                + "\n---------------------------------------------------------------------------------------------------\n";
    }
}
