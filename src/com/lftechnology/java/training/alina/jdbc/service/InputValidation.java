package com.lftechnology.java.training.alina.jdbc.service;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import com.lftechnology.java.training.alina.jdbc.constants.Constants;

/**
 * InputValidation consists of validations regarding user input data
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class InputValidation {
    private static final Logger LOGGER = Logger.getLogger(InputValidation.class.getName());

    private InputValidation() {

    }

    /**
     * Validates if the given value consistd only alphabets
     * 
     * @param input
     *            {@link Scanner}
     * @param fieldLabel
     *            {@link String}
     * @return stringValue {@link String}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static String alphabetValidation(Scanner input, String fieldLabel) {
        LOGGER.log(Level.INFO, fieldLabel);
        String stringValue = input.nextLine();
        if (!Pattern.matches("[a-zA-Z]+", stringValue)) {
            LOGGER.log(Level.INFO, Constants.ENTER_VALID_USERNAME);
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
                LOGGER.log(Level.INFO, Constants.ENTER_VALID_NUMBER);
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
            LOGGER.log(Level.INFO, Constants.NUMBER_LIMIT);
            return false;
        } else {
            return true;
        }
    }
}
