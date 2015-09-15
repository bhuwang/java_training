package com.lftechnology.java.training.sanish.application.utility;

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
        String pattern = "[a-zA-Z1-9!@#$%^&*._,]+";
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

    public static String getEmail(Scanner scanner){
        String email = "";
        String emailPattern = "[a-z]+@[a-z]+(.[a-z])+";
        while (true) {
            if (!scanner.hasNext()) {
                scanner.next();
            } else {
                email = scanner.next();
                if (email.isEmpty()) {
                    continue;
                } else if (!email.matches(emailPattern)) {
                    LOGGER.log(Level.WARNING, "Invalid email address, Please type again : ");
                } else {
                    break;
                }
            }
        }

        return email;
    }

    public static String getUserRole(Scanner scanner) {
        String role = "User";
        int intNum = 1;
        while (true) {
            if (!scanner.hasNextInt()) {
                LOGGER.log(Level.WARNING, "Please enter valid number : ");
                scanner.next();
            } else {
                intNum = scanner.nextInt();
                if(intNum == 1){
                    role = "User";
                    break;
                }else if(intNum == 2){
                    role = "Admin";
                    break;
                }else{
                    LOGGER.log(Level.WARNING, "Please provide valid number, 1 : User 2: Admin : ");
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
                    LOGGER.log(Level.WARNING, "Invalid name, Please type again : ");
                } else {
                    checkNextInput = false;
                }
            }
        }

        return inputWords;
    }

}
