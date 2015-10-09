package com.lftechnology.java.training.alina.jdbc.views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeEditView {
    private static final Logger LOGGER = Logger.getLogger(EmployeeEditView.class.getName());

    private EmployeeEditView() {

    }

    /**
     * Prints menu for Employee Edit
     * 
     * @param result
     *            {@link ResultSet}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void displayEmployeeEditMenu() throws SQLException {
        LOGGER.log(Level.INFO, "\n=====================Edit Options===========================\n" + "\n\ta Edit fullname"
                + "\n\tb Edit department" + "\n\tc Edit Address" + "\n\td Change Password" + "\n\te Back\n");
    }
}
