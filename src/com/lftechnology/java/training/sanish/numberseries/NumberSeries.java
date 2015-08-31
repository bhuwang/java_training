package com.lftechnology.java.training.sanish.numberseries;

import java.util.ArrayList;
import java.util.List;

/**
 * Array list merge, remove and display
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class NumberSeries {
    private static List<String> seriesOne = new ArrayList<String>();
    private static List<String> seriesTwo = new ArrayList<String>();

    private NumberSeries() {
    }

    public static void main(String[] args) {
        //add seriesOne values
        addSeriesOneValues();
        NumberSeriesOperator.displaySeries(seriesOne);

        //add seriesTwo values
        addSeriesTwoValues();
        NumberSeriesOperator.displaySeries(seriesTwo);

        //merge seriesTwo with seriesOne
        seriesOne.addAll(seriesTwo);
        NumberSeriesOperator.displaySeries(seriesOne);

        //remove event position element form list of seriesTow
        seriesTwo = NumberSeriesOperator.removeEventElement(seriesTwo);
        NumberSeriesOperator.displaySeries(seriesTwo);

        //remove seriesTwo elements form seriesOne list
        seriesOne = NumberSeriesOperator.removeSeriesElement(seriesOne, seriesTwo);
        NumberSeriesOperator.displaySeries(seriesOne);
    }

    /**
     * Set seriesOne list values
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void addSeriesOneValues() {
        NumberSeries.seriesOne.add("One");
        NumberSeries.seriesOne.add("Two");
        NumberSeries.seriesOne.add("Three");
        NumberSeries.seriesOne.add("Four");
        NumberSeries.seriesOne.add("Five");
    }

    /**
     * Set seriesTwo list values
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void addSeriesTwoValues() {
        NumberSeries.seriesTwo.add("Six");
        NumberSeries.seriesTwo.add("Seven");
        NumberSeries.seriesTwo.add("Eight");
        NumberSeries.seriesTwo.add("Nine");
        NumberSeries.seriesTwo.add("Ten");
    }
}
