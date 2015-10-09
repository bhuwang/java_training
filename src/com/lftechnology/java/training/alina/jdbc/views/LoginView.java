package com.lftechnology.java.training.alina.jdbc.views;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.domain.User;
import com.lftechnology.java.training.alina.jdbc.service.UserService;

public class LoginView {

    private static final Logger LOGGER = Logger.getLogger(LoginView.class.getName());

    private LoginView() {

    }

    public static User displayLoginHeader(Scanner scanner) throws SQLException {
        User user = new User();
        LOGGER.log(Level.INFO, "\n==============================\nLOGIN PAGE\n==============================\n");
        user = UserService.setLoginInfo(scanner, Constants.USER_LOGIN);
        return user;
    }
}
