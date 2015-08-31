package com.lftechnology.java.training.sanish.numberseries;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provide number series operation functions
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class NumberSeriesOperator {
    private static final Logger LOGGER = Logger.getLogger(NumberSeriesOperator.class.getName());

    private NumberSeriesOperator() {
    }

    /**
     * Display number series values
     *
     * @param series {@link List} number series
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void displaySeries(List<String> series) {
        String seriesListText = "";
        for (String value : series) {
            if (seriesListText.isEmpty()) {
                seriesListText += value.toString();
            } else {
                seriesListText += ", " + value.toString();
            }
        }

        LOGGER.log(Level.INFO, seriesListText);
    }

    /**
     * Remove event position element form number series and return new list
     *
     * @param series {@link List} number series
     * @return {@link List}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static List<String> removeEventPosElement(List<String> series) {
        List<String> tempSeries = series;
        int index = 0;
        int count = 1;
        int seriesLength = series.size();
        while (count < seriesLength) {
            if (count % 2 == 0) {
                tempSeries.remove(index);
            } else {
                index++;
            }

            count++;
        }

        return tempSeries;
    }

    /**
     * Remove elements form seriesOne which content in seriesTwo and return new list
     *
     * @param seriesOne {@link List}
     * @param seriesTwo {@link List}
     * @return {@link List}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static List<String> removeSeriesElement(List<String> seriesOne, List<String> seriesTwo) {
        List<String> firstSeries = seriesOne;
        List<String> secondSeries = seriesTwo;
        int firstSeriesLength = firstSeries.size();
        int count = 1;
        int index = 0;
        while (count < firstSeriesLength) {
            if (secondSeries.contains(firstSeries.get(index))) {
                firstSeries.remove(index);
            } else {
                index++;
            }
            count++;
        }

        return firstSeries;
    }
}
