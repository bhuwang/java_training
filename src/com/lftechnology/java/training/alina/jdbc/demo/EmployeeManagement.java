package com.lftechnology.java.training.alina.jdbc.demo;

import java.sql.SQLException;
import com.lftechnology.java.training.alina.jdbc.controller.LoginController;

/**
 * EmployeeManagement consists of employee management functionalities
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class EmployeeManagement {

    public static void main(String[] args) throws SQLException {
        LoginController loginController = new LoginController();
        loginController.userLogin();
    }
}
