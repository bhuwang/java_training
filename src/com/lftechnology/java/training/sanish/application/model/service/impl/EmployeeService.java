package com.lftechnology.java.training.sanish.application.model.service.impl;

import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.service.CrudService;

import java.sql.ResultSet;

/**
 * Created by sanish on 9/14/15.
 */
public interface EmployeeService extends CrudService<Employee> {
    public boolean isAdmin(Employee employee);
    public boolean isUser(Employee employee);
    public User getUser(Employee employee);
}
