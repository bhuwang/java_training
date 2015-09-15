package com.lftechnology.java.training.alina.jdbc.views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.alina.jdbc.domain.Employee;

public class AdminView {

    private static final Logger LOGGER = Logger.getLogger(AdminView.class.getName());

    private AdminView() {

    }

    /**
     * Prints menu for Admin Role
     * 
     * @param result
     *            {@link ResultSet}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void displayAdminRoleMenu(Employee employee) throws SQLException {
        LOGGER.log(Level.INFO, "\n=====================Employee Management System (Admin Menu)===========================\n"
                + "Welcome {0} !\n==================================================\n" + "\n\ta Add a new Employee"
                + "\n\tb Delete an Employee" + "\n\tc Terminate an Employee" + "\n\td View Employee List" + "\n\te Search an Employee"
                + "\n\tf Logout\n", new Object[] { employee.getFullname() });
    }
}
