package com.lftechnology.java.training.niraj.ems.utils;

import java.util.Map;

/**
 * Class for Utility methods
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 * 
 * @see StringBuilder
 *
 */
public class Utils {

    /**
     * Implodes the string for a given delimiter
     * 
     * @param s
     * @param delimiter
     * @return
     */
    public static String implode(String[] s, String delimiter) {
        StringBuilder implodedString = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            implodedString.append(s[i]);
            implodedString.append(delimiter);
        }
        String result = implodedString.toString();
        return Utils.trimEnd(result, delimiter).trim();
    }

    /**
     * Trims the occurrence of particular substring from the end of a string
     * 
     * @param str
     * @param remove
     * @return
     */
    public static String trimEnd(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (str.endsWith(remove)) {
            return str.substring(0, str.length() - remove.length());
        }
        return str;
    }

    /**
     * Checks if a string is empty or null
     * 
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * Gets Keys in an array
     * 
     * @param map
     * @return
     */
    public static String[] getKeysArray(Map<String, String> map) {
        String[] keysArray = new String[map.size()];
        int i = 0;
        for (String key : map.keySet()) {
            keysArray[i] = key;
            i++;
        }
        return keysArray;
    }

    /**
     * Checks if the string is an integer
     * 
     * @param s
     * @param radix
     * @return
     */
    public static boolean isInteger(String s, int radix) {
        if (s.isEmpty())
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1)
                    return false;
                else
                    continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0)
                return false;
        }
        return true;
    }

    /**
     * Clears the console
     */
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            // Handle any exceptions.
        }
    }

}
