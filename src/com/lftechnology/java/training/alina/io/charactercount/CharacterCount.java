package com.lftechnology.java.training.alina.io.charactercount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write an example that counts the number of times a particular character, such as e, appears in a file. The character can be specified at
 * the command line.
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class CharacterCount {

    private static final Logger LOGGER = Logger.getLogger(CharacterCount.class.getName());

    private CharacterCount() {

    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("lorem.txt"))) {
            if (args.length != 1 || args[0].length() != 1)
                showUsage();
            Letters letters = new Letters(args[0].charAt(0));
            String characterCount = letters.getCountOfCharacters(reader);
            LOGGER.log(Level.INFO, "{0}", new Object[] { characterCount });
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", new Object[] { e });
        } catch (ArrayIndexOutOfBoundsException e) {
            LOGGER.log(Level.WARNING, "Process character count through terminal : {0}", new Object[] { e });
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", new Object[] { e });
        }
    }

    /**
     * Shows the usage to display the required output
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void showUsage() {
        LOGGER.log(Level.INFO, "Usage : java com.lftechnology.java.training.alina.io.charactercount.CharacterCount <letter>");
    }
}
