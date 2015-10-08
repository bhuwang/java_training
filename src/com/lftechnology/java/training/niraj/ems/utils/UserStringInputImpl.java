package com.lftechnology.java.training.niraj.ems.utils;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                LOGGER.warning("Please enter a word :");
            } else {
                break;
            }
        }
        return input;

    }

    public String getInput(Scanner scanner, Console console, String message) {
        String input;
        if (console != null) {
            input = this.getInput(console, message);
        } else {
            input = this.getInput(scanner, message);
        }

        return input;
    }

    public String getInput(Scanner scanner, String message) {
        LOGGER.info(message);
        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                LOGGER.warning(message);
            } else {
                break;
            }
        }
        return input;
    }

    public String getInput(Console console) {
        return console.readLine("Please enter a word:");
    }

    public String getInput(Console console, String message) {
        return console.readLine(message);
    }

    public List<String> getMultipleChoices(Scanner scanner, Console console, String message, int min, int max) {
        List<String> choices = null;
        if (console == null) {
            choices = getMultipleChoices(scanner, message, min, max);
        }
        return choices;
    }

    public List<String> getMultipleChoices(Scanner scanner, String message, int min, int max) {
        LOGGER.info(message);
        String[] choices = null;
        String input;
        List<String> choiceList;
        while (true) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                LOGGER.warning(message);
            } else {
                choices = input.split(",");
                choiceList = validateChoices(choices, min, max);
                if (choiceList == null) {
                    LOGGER.warning(message);
                } else {
                    break;
                }
            }
        }
        return choiceList;

    }

    /**
     * Validates choices made by the user
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param choices
     * @param min
     * @param max
     * @return
     */
    private List<String> validateChoices(String[] choices, int min, int max) {
        List<String> choiceList = new ArrayList<String>();
        for (int i = 0; i < choices.length; i++) {
            String choice = choices[i].trim();
            if (!Utils.isInteger(choice, 10) && Integer.parseInt(choice) < min && Integer.parseInt(choice) > max) {
                choiceList = null;
                break;
            } else {
                choiceList.add(choice);
            }
        }
        return choiceList;
    }

    public String getPassword(Console console) {
        char[] password = console.readPassword("Password: ");
        Arrays.fill(password, ' ');
        return Arrays.toString(password);
    }

}
