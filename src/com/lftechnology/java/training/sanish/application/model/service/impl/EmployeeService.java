package com.lftechnology.java.training.sanish.application.model.service.impl;

import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.service.CrudService;

/**
 * Employee service interface
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public interface EmployeeService extends CrudService<Employee> {
    /**
     * Check is employee has admin role
     *
     * @param employee {@link Employee}
     * @return {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public boolean isAdmin(Employee employee);

    /**
     * Check is employee has user role
     *
     * @param employee {@link Employee}
     * @return {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public boolean isUser(Employee employee);

    /**
     * Return user information of employee
     *
     * @param employee
     * @return {@link User}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public User getUser(Employee employee);
}
