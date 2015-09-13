package com.lftechnology.java.training.alina.jdbc.views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeView {

    private static final Logger LOGGER = Logger.getLogger(EmployeeView.class.getName());

    /**
     * Prints menu for Admin Role
     * 
     * @param result
     *            {@link ResultSet}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void displayEmployeeRoleMenu(ResultSet result) throws SQLException {
        LOGGER.log(Level.INFO, "\n=====================Employee Management System (Employee Menu)===========================\n"
                + "Welcome {0} !\n==================================================\n" + "\n\ta View Employee List"
                + "\n\tb Search an employee" + "\n\tc Edit Information" + "\n\td Logout\n", new Object[] { result.getString("fullname") });
    }
}
