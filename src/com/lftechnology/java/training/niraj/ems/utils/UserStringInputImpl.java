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
        if (console != null) {
            // todo for console
        } else {
            choices = getMultipleChoices(scanner, message, min, max);
        }
        return choices;
    }

    public List<String> getMultipleChoices(Scanner scanner, String message, int min, int max) {
        LOGGER.info(message);
        String[] choices = null;
        String input;
        List<String> choiceList = new ArrayList<String>();
        while (true) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                LOGGER.warning(message);
            } else {
                choices = input.split(",");
                boolean isValid = true;
                for (int i = 0; i < choices.length; i++) {
                    String choice = choices[i].trim();
                    if (!Utils.isInteger(choice, 10) && Integer.parseInt(choice) < min && Integer.parseInt(choice) > max) {
                        isValid = false;
                    } else {
                        choiceList.add(choice);
                    }
                }
                if (!isValid) {
                    LOGGER.warning(message);
                } else {
                    break;
                }
            }
        }
        return choiceList;

    }

    public String getPassword(Console console) {
        char[] password = console.readPassword("Password: ");
        Arrays.fill(password, ' ');
        String pass = Arrays.toString(password);
        return pass;
    }

}
