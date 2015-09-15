package com.lftechnology.java.training.sanish.application.model.service.impl;

import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.model.service.CrudService;

import java.sql.ResultSet;
import java.util.List;

/**
 * User service interface
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public interface UserService extends CrudService<User> {
    /**
     * Get user by user name
     *
     * @param userName {@link String} user name
     * @return {@link User}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public User getUserByUserName(String userName);
    public boolean setPassword(User user, String password);
    public Employee getEmployee(User user);
    public List<UserEmployee> searchEmployee(String searchKey);
    public boolean terminateUser(User user);
}
