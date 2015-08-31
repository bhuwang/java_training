package com.lftechnology.java.training.sanish.numberprinter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Print number for 1-10
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class NumberPrinter {
    private static final Logger LOGGER = Logger.getLogger(NumberPrinter.class.getName());

    private NumberPrinter() {
    }

    public static void main(String[] agrs) {
        printNumber(1, 10);
    }

    /**
     * Print number from min to max parameter provided
     *
     * @param min {@link Integer} minimum number of number series
     * @param max {@link Integer}  maximum number of number series
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void printNumber(int min, int max) {
        String numberSeries = Integer.toString(min);
        for (int i = min + 1; i <= max; i++) {
            numberSeries += ", " + i;
        }

        LOGGER.log(Level.INFO, "Number from 1-10 : {0}", new Object[]{numberSeries});
    }
}
