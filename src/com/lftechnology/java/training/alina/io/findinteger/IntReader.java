package com.lftechnology.java.training.alina.io.findinteger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A file which has some int value among with other string value . Write a program that gets the int piece of data. What is the int data?
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class IntReader {
    private static final Logger LOGGER = Logger.getLogger(IntReader.class.getName());

    /**
     * Main Method consists of displaying of int values from a file
     * 
     * @param args
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("intreader.txt"))) {
            Letters letters = new Letters();
            String integerValue = letters.getIntegerValue(reader);
            LOGGER.log(Level.INFO, "{0}", new Object[] { integerValue });
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "IOException Message : ", new Object[] { e });
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Exception Message : ", new Object[] { e });
        }
    }
}
