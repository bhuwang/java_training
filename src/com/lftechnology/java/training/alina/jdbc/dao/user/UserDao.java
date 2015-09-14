package com.lftechnology.java.training.alina.jdbc.dao.user;

import java.util.List;
import com.lftechnology.java.training.alina.jdbc.api.CrudService;
import com.lftechnology.java.training.alina.jdbc.domain.User;

/**
 * UserDao is interface that extends CrudService and adds other functions
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public interface UserDao extends CrudService<User> {
    List<User> searchUser(String sql, String... searchContent);
}
