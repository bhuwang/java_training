package com.lftechnology.java.training.sanish.application.utility;

/**
 * Created by sanish on 9/11/15.
 */
public class OutputFormatter {
    public static <V> String getStringForListCol(V value, int colSize) {
        String colValue = value.toString();
        int colValueLength = colValue.length();
        if (colValueLength > colSize) {
            return colValue.substring(colSize) + "\t";
        }
        int diffInLength = colSize - colValueLength;
        for (int i = 0; i < diffInLength; i++) {
            colValue += " ";
        }
        return colValue + "\t";
    }
}
