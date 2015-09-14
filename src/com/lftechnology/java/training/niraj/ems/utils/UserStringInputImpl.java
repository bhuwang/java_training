package com.lftechnology.java.training.niraj.utils;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Implementation of user string input interface
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 */
public class UserStringInputImpl implements UserStringInput {

    private static final Logger LOGGER = Logger.getLogger(UserStringInputImpl.class.getName());

    @Override
    public String getInput(Scanner scanner) {

        LOGGER.info("Please enter a word :");
        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                LOGGER.info("Please enter a word :");
            } else {
                break;
            }
        }
        return input;

    }

}
