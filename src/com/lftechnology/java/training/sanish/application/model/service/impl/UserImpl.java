package com.lftechnology.java.training.sanish.application.model.service.impl;

import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.service.CrudService;

import java.sql.ResultSet;

/**
 * User with implementation of crudService
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public interface UserImpl extends CrudService<User> {
    public User getUserByUserName(String userName);
}
