package com.lftechnology.java.training.alina.jdbc.dao.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.lftechnology.java.training.alina.jdbc.api.CrudService;
import com.lftechnology.java.training.alina.jdbc.domain.User;

/**
 * UserDao is interface that extends CrudService and adds other functions
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public interface UserDao extends CrudService<User> {
    /**
     * User searching functionality
     * 
     * @param sql
     *            {@link STRING}
     * @param searchContent
     *            {@link STRING}
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    List<User> searchUser(String sql, String... searchContent);

    boolean checkEmployeeLogin(Scanner scanner, User user) throws SQLException;

    boolean checkValidUserByUsername(String username) throws SQLException;
}
