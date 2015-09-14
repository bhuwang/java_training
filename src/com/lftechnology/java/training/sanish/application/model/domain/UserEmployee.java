package com.lftechnology.java.training.sanish.application.model.domain;

/**
 * UserEmployee model
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class UserEmployee {
    private User user;
    private Employee employee;

    public User getUser() {
        return user;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getUserId() {
        return user.getUserId();
    }

    public int getEmployeeId() {
        return employee.getEmployId();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
