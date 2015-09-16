package com.lftechnology.java.training.sanish.application.utility;

import com.lftechnology.java.training.sanish.application.component.Constants;

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
                LOGGER.log(Level.WARNING, Constants.ENTER_VALID_NUMBER_MSG);
                scanner.next();
            } else {
                intNum = scanner.nextInt();
                if ((min != -1 && max != -1) && (intNum < min || intNum > max)) {
                    LOGGER.log(Level.WARNING, Constants.ENTER_NUMBER_RANGE_MSG + "({0}-{1}) : ", new Object[] { min, max });
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
        String pattern = "[a-zA-Z1-9!@#$%^&*/._,]+";
        boolean checkNextInput = true;
        while (checkNextInput) {
            if (!scanner.hasNext()) {
                scanner.next();
            } else {
                inputString = scanner.next();
                if (inputString.isEmpty()) {
                    continue;
                } else if (!inputString.matches(pattern)) {
                    LOGGER.log(Level.WARNING, Constants.INVALID_MSG);
                } else {
                    checkNextInput = false;
                }
            }
        }

        return inputString;
    }

    /**
     * Scan email form console and return string
     *
     * @param {@link Scanner}
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static String getEmail(Scanner scanner) {
        String email = "";
        String emailPattern = "[a-z][a-z_/+1-9]+@[a-z]+[.a-z]+";
        boolean checkNextInput = true;
        while (checkNextInput) {
            if (!scanner.hasNext()) {
                scanner.next();
            } else {
                email = scanner.next();
                if (email.isEmpty()) {
                    continue;
                } else if (!email.matches(emailPattern)) {
                    LOGGER.log(Level.WARNING, Constants.INVALID_EMAIL_MSG);
                } else {
                    checkNextInput = false;
                }
            }
        }

        return email;
    }

    /**
     * Scan user role number
     *
     * @param {@link Scanner}
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static String getUserRole(Scanner scanner) {
        String role = Constants.USER_ROLE;
        int intNum = 1;
        boolean checkNextInput = true;
        while (checkNextInput) {
            if (!scanner.hasNextInt()) {
                LOGGER.log(Level.WARNING, Constants.INVALID_MSG);
                scanner.next();
            } else {
                intNum = scanner.nextInt();
                if (intNum == 1) {
                    role = Constants.USER_ROLE;
                    checkNextInput = false;
                } else if (intNum == 2) {
                    role = Constants.ADMIN_ROLE;
                    checkNextInput = false;
                } else {
                    LOGGER.log(Level.WARNING, Constants.INVALID_ROLE_NUM_MSG);
                }
            }

        }

        return role;
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
        String pattern = "[a-zA-Z]+[a-z ,A-Z]*";
        boolean checkNextInput = true;
        while (checkNextInput) {
            if (!scanner.hasNextLine()) {
                scanner.nextLine();
            } else {
                inputWords = scanner.nextLine();
                if (inputWords.isEmpty()) {
                    continue;
                } else if (!inputWords.matches(pattern)) {
                    LOGGER.log(Level.WARNING, Constants.INVALID_MSG);
                } else {
                    checkNextInput = false;
                }
            }
        }

        return inputWords;
    }

}
