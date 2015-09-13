package com.lftechnology.java.training.alina.jdbc.views;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginView {

    private static final Logger LOGGER = Logger.getLogger(LoginView.class.getName());

    public static void displayLoginHeader() {
        LOGGER.log(Level.INFO, "\n==============================\nLOGIN PAGE\n==============================\n");
    }
}
