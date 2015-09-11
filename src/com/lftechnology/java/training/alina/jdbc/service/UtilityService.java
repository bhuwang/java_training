package com.lftechnology.java.training.alina.jdbc.service;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilityService {

    private static final Logger LOGGER = Logger.getLogger(UtilityService.class.getName());

    /**
     * Gets input data
     * 
     * @param scanner
     *            {@link Scanner}
     * @param fieldLabel
     *            {@link String}
     * @return {@link String} input value
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static String getInputData(Scanner scanner, String fieldLabel) {
        LOGGER.log(Level.INFO, fieldLabel);
        while (!scanner.hasNext()) {
            scanner.nextLine();
            System.out.println(scanner.nextLine());
        }
        return scanner.nextLine();
    }

    public final static void clearConsole() {
        try {
            final String operatingSystem = System.getProperty("os.name");
            System.out.println(operatingSystem);
            if (operatingSystem.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            // Handle any exceptions.
        }
    }
}
