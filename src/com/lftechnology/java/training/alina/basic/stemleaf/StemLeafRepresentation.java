package com.lftechnology.java.training.alina.basic.stemleaf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java program to present data in stem and leaf form
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class StemLeafRepresentation {

    public static final int MIN_VALUE = 3;
    public static final int MAX_VALUE = 99;
    private static final Logger LOGGER = Logger.getLogger(StemLeafRepresentation.class.getName());
    private static int dataPoints;
    private static DataSet[] data;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            getDataPoints(scanner);
            getStemLeaf();
        } catch (InputMismatchException e) {
            LOGGER.log(Level.WARNING, "Invalid number.");
        }
    }

    /**
     * Function used to get data points and display data in order
     * 
     * @param scanner
     *            {@link Scanner}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void getDataPoints(Scanner scanner) {
        NumberValidation validation = new NumberValidation();
        dataPoints = validation.numberValidation(scanner, "Enter number of data points : ", MIN_VALUE, MAX_VALUE);
        data = new DataSet[dataPoints];
        for (int i = 0; i < dataPoints; i++) {
            data[i] = new DataSet(validation.numberValidation(scanner, "[" + i + "]:", 10, MAX_VALUE));
        }
        Arrays.sort(data);
        LOGGER.log(Level.INFO, "The sorted array is : ");
        for (DataSet dataList : data) {
            LOGGER.log(Level.INFO, "{0}", dataList);
        }

    }

    /**
     * Gets and displays stem leaf
     * 
     * @param data
     *            {@link Arrays} list of data
     * @param dataPoints
     *            ({@link Integer} number of data points
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void getStemLeaf() {
        Map<Integer, Integer> dictionary = new HashMap<Integer, Integer>();
        int stem, leaf, second;
        for (int i = 0; i < dataPoints; i++) {
            stem = data[i].getDataSet() / 10;
            if (dictionary.containsKey(stem)) {
                leaf = (int) dictionary.get(stem);
                second = data[i].getDataSet() % 10;
                leaf = leaf * 10 + second;
            } else {
                leaf = data[i].getDataSet() % 10;
            }
            dictionary.put(stem, leaf);
        }
        LOGGER.log(Level.INFO, "Stem and Leaf Display of size : {0}", dictionary.size());
        for (Object key : dictionary.keySet()) {
            LOGGER.log(Level.INFO, "Frequency : {0}, Stem : {1}, Leaf : {2}", new Object[] { dictionary.get(key).toString().length(), key,
                    dictionary.get(key) });
        }

    }
}
