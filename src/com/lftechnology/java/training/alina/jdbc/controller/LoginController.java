package com.lftechnology.java.training.alina.jdbc.controller;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.alina.jdbc.dao.user.impl.UserDaoImpl;
import com.lftechnology.java.training.alina.jdbc.dbutils.DbFacade;
import com.lftechnology.java.training.alina.jdbc.demo.EmployeeManagement;

public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(EmployeeManagement.class.getName());

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
     * Check and display message while user not logged in
     * 
     * @param isLogin
     *            {@link Boolean}
     * @return {@link Boolean} status of login
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static boolean checkNotLogin(Boolean isLogin) {
        if (!isLogin) {
            LOGGER.log(Level.INFO, "\n=====>\nUsername or Password not found. Please try again.\n=====>\n");
            return false;
        } else {
            return true;
        }
    }

}
