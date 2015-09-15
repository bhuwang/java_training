package com.lftechnology.java.training.alina.io.findinteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Letters class consists of functions like get integer values from a file
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class Letters {
    private String line;
    private static List<Character> listInteger = new ArrayList<Character>();

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    /**
     * Function used to get the integer values from a file
     * 
     * @param reader
     *            {@link BufferedReader}
     * @return {@link String} integer values from file
     * @throws IOException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public String getIntegerValue(BufferedReader reader) throws IOException {
        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    listInteger.add(line.charAt(i));
                }
            }
        }
        return this.toString();
    }

    @Override
    public String toString() {
        return "File has following int piece of data : \n" + listInteger;
    }
}
