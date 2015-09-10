package com.lftechnology.java.training.sanish.application.utility;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provide methods to get inputs form console
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class UserInput {
    private static final Logger LOGGER = Logger.getLogger(UserInput.class.getName());

    private UserInput() {
    }

    /**
     * Scan number from console and return number
     *
     * @param {@link Scanner}
     * @param {@link Integer} Minimum value acceptable
     * @param {@link Integer} Maximum value acceptable
     * @return {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static int getIntegerNumber(Scanner scanner, int min, int max) {
        int intNum = 0;
        boolean checkNextInput = true;
        while (checkNextInput) {
            if (!scanner.hasNextInt()) {
                LOGGER.log(Level.WARNING, "Please enter valid number : ");
                scanner.next();
            } else {
                intNum = scanner.nextInt();
                if (intNum < min || intNum > max) {
                    LOGGER.log(Level.WARNING, "Please enter number within range ({0}-{1}) : ", new Object[] { min, max });
                } else {
                    checkNextInput = false;
                }
            }

        }

        return intNum;
    }

    /**
     * Scan string form console and return string
     *
     * @param {@link Scanner}
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static String getString(Scanner scanner) {
        String inputString = "";
        String pattern = "[a-zA-Z1-9!@#$%^&*]+";
        boolean checkNextInput = true;
        while (checkNextInput) {
            if (!scanner.hasNext()) {
                scanner.next();
            } else {
                inputString = scanner.next();
                if (inputString.isEmpty()) {
                    continue;
                } else if (!inputString.matches(pattern)) {
                    LOGGER.log(Level.WARNING, "Invalid, Please type again : ");
                } else {
                    checkNextInput = false;
                }
            }
        }

        return inputString;
    }

    /**
     * Scan alphabetic words form console and return
     *
     * @param scanner {@link Scanner}
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static String getAlphabeticWords(Scanner scanner) {
        String inputWords = "";
        String pattern = "[a-zA-Z]+[a-z A-Z]*";
        boolean checkNextInput = true;
        while (checkNextInput) {
            if (!scanner.hasNextLine()) {
                scanner.nextLine();
            } else {
                inputWords = scanner.nextLine();
                if (inputWords.isEmpty()) {
                    continue;
                } else if (!inputWords.matches(pattern)) {
                    LOGGER.log(Level.WARNING, "Invalid name, Please type again : ");
                } else {
                    checkNextInput = false;
                }
            }
        }

        return inputWords;
    }

}
