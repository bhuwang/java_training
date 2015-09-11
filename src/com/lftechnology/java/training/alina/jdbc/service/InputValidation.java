package com.lftechnology.java.training.alina.jdbc.service;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class InputValidation {
    private static final Logger LOGGER = Logger.getLogger(InputValidation.class.getName());

    public static String alphabetValidation(Scanner input, String fieldLabel) {
        LOGGER.log(Level.INFO, fieldLabel);
        String stringValue = input.nextLine();
        if (!Pattern.matches("[a-zA-Z]+", stringValue)) {
            LOGGER.log(Level.INFO, "Please provide a valid username.");
            stringValue = input.nextLine();
        }
        return stringValue;
    }

    /**
     * Function used to validate the number
     * 
     * @param input
     *            {@link Scanner}
     * @param fieldLabel
     *            {@link String} label given to a field
     * @return fieldName {@link Integer} input value by user
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static int numberValidation(Scanner input, String fieldLabel) {
        int fieldValue;
        int minValue = 1;
        do {
            LOGGER.log(Level.INFO, fieldLabel);
            while (!input.hasNextInt()) {
                LOGGER.log(Level.INFO, "Please enter valid number : ");
                input.nextLine();
            }
            fieldValue = Integer.parseInt(input.nextLine());
        } while (!isValidNumber(fieldValue, minValue));
        return fieldValue;
    }

    /**
     * Function used to check if a number is valid and within range
     * 
     * @param fieldValue
     *            {@link Integer} value of input field
     * @param minValue
     *            {@link Integer} minimum value to compare
     * @return {@link Boolean}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static boolean isValidNumber(int fieldValue, int minValue) {
        if (fieldValue < minValue) {
            LOGGER.log(Level.INFO, "Please enter number greater than 0 : ");
            return false;
        } else {
            return true;
        }
    }
}
