package com.lftechnology.java.training.sanish.Shufflenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Shuffle number series
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class ShuffleNumber {
    private static final Logger LOGGER = Logger.getLogger(ShuffleNumber.class.getName());

    private ShuffleNumber() {
    }

    public static void main(String[] args) {
        List<Integer> numberList = getNumberSeries(1, 49);
        Collections.shuffle(numberList);
        List<Integer> subNumberList = numberList.subList(0, 5);
        printNumberSeries(subNumberList);
        Collections.sort(numberList);
        printNumberSeries(numberList);
    }

    /**
     * Get number series in range of min and max number
     *
     * @param min {@link Integer} min number of series
     * @param max {@link Integer} max number of series
     * @return {@link ArrayList}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static List getNumberSeries(int min, int max) {
        List<Integer> numberSeries = new ArrayList<Integer>();
        for (int i = min; i <= max; i++) {
            numberSeries.add(i);
        }

        return numberSeries;
    }

    /**
     * Print number series
     * @param series {@link List} number series
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void printNumberSeries(List series) {
        LOGGER.log(Level.INFO, "Number series \n" +
                "==================================== \n" +
                "{0}", new Object[]{series});
    }


}
