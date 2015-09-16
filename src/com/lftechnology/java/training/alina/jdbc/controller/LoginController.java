package com.lftechnology.java.training.alina.jdbc.controller;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.dao.user.impl.UserDaoImpl;
import com.lftechnology.java.training.alina.jdbc.dbutils.DbFacade;
import com.lftechnology.java.training.alina.jdbc.demo.EmployeeManagement;

/**
 * LoginController consists of login,logout functionals
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 *
 */
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(EmployeeManagement.class.getName());

    /**
     * User login functionality
     * 
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public void userLogin() throws SQLException {
        Boolean isLogin = false;
        try (Scanner scanner = new Scanner(System.in)) {
            UserDaoImpl userDao = new UserDaoImpl();
            do {
                isLogin = userDao.checkEmployeeLogin(scanner);
            } while (!checkNotLogin(isLogin));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", new Object[] { e });
        } finally {
            DbFacade.closeDbConnection();
        }
    }

    /**
     * Checks and displays message when user fails to log in
     * 
     * @param isLogin
     *            {@link Boolean}
     * @return {@link Boolean} status of login
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static boolean checkNotLogin(Boolean isLogin) {
        if (!isLogin) {
            LOGGER.log(Level.INFO, Constants.INVALID_USERNAME_PASSWORD);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks existence of user by username
     * 
     * @param scanner
     *            {@link Scanner}
     * @param userExist
     *            {@link Boolean}
     * @param username
     *            {@link String}
     * @return userExist {@link Boolean} identifies user exists/not
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static boolean checkExistUsername(String username) throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
        boolean checkUserExist = userDao.checkValidUserByUsername(username);
        if (checkUserExist) {
            LOGGER.log(Level.INFO, Constants.USERNAME_ALREADY_EXISTS);
        }
        return checkUserExist;
    }
}
