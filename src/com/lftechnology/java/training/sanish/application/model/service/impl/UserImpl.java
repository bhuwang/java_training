package com.lftechnology.java.training.sanish.application.model.service.impl;

import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.service.CrudService;

import java.sql.ResultSet;

/**
 * User service interface
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public interface UserImpl extends CrudService<User> {
    /**
     * Get user by user name
     *
     * @param userName {@link String} user name
     * @return {@link User}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public User getUserByUserName(String userName);
    public boolean setPassword(User user, String password);

    /**
     * Set properties of user with supplied result set
     *
     * @param user {@link User}
     * @param rs   {@link ResultSet}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void setResultSetAttributes(User user, ResultSet rs);
}
