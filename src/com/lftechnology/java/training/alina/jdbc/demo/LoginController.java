package com.lftechnology.java.training.alina.jdbc.demo;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.lftechnology.java.training.alina.jdbc.dao.user.impl.UserDaoImpl;
import com.lftechnology.java.training.alina.jdbc.dbutils.DbFacade;
import java.sql.SQLException;

public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    public static void main(String[] args) throws SQLException {
        Boolean isLogin = false;
        try (Scanner scanner = new Scanner(System.in)) {
            UserDaoImpl userDao = new UserDaoImpl();
            do {
                isLogin = userDao.checkEmployeeLogin(scanner);
                if (isLogin) {
                    LOGGER.log(Level.INFO, "Welcome !");
                }
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
            LOGGER.log(Level.INFO, "Username and Password not found. Please try again.");
            return false;
        } else {
            return true;
        }
    }
}
