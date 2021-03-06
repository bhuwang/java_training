package com.lftechnology.java.training.sanish.application.model.service.impl;

import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.model.service.CrudService;

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

    /**
     * Set password of user
     *
     * @param user     {@link User}
     * @param password {@link String }
     * @return {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public boolean setPassword(User user, String password);

    /**
     * Get employee data of user
     *
     * @param user {@link User}
     * @return {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public Employee getEmployee(User user);

    /**
     * Search employee by search key
     *
     * @param searchKey {@link String }
     * @return {@link List<UserEmployee>}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public List<UserEmployee> searchEmployee(String searchKey);

    /**
     * Terminate user
     *
     * @param user {@link User}
     * @return {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public boolean terminateUser(User user);
}
