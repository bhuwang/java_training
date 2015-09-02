package com.lftechnology.java.training.alina.basic.stemleaf;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class NumberValidation contains different validations regarding number
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class NumberValidation {

    private static final Logger LOGGER = Logger.getLogger(NumberValidation.class.getName());

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
    public int numberValidation(Scanner input, String fieldLabel, int minValue, int maxValue) {
        int fieldValue;
        do {
            LOGGER.log(Level.INFO, fieldLabel);
            while (!input.hasNextInt()) {
                LOGGER.log(Level.INFO, "Please enter valid number : ");
                input.nextLine();
            }
            fieldValue = Integer.parseInt(input.nextLine());
        } while (!isValidNumber(fieldValue, minValue, maxValue));
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
    private boolean isValidNumber(int fieldValue, int minValue, int maxValue) {
        if (fieldValue < minValue || fieldValue > maxValue) {
            LOGGER.log(Level.INFO, "Please enter number within range ({0}-{1})", new Object[] { minValue, maxValue });
            return false;
        }
        return true;
    }
}
