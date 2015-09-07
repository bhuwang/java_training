package com.lftechnology.java.training.alina.collections.generics.integerdoublesum;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * IntegerDoubleSum Class is used to calculate sum of numbers, Write a program in which Generic method is used to sum Integer or Double.
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class IntegerDoubleSum {

    private static final Logger LOGGER = Logger.getLogger(IntegerDoubleSum.class.getName());
    private static List<Integer> listInteger = new ArrayList<Integer>();
    private static List<Double> listDouble = new ArrayList<Double>();

    private IntegerDoubleSum() {

    }

    /**
     * Main method is used to get sum in terms of integers and doubles
     * 
     * @param args
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void main(String[] args) {

        getSumUsingInteger();
        getSumUsingDouble();
    }

    /**
     * Used to get sum of double numbers
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void getSumUsingDouble() {
        listDouble.add(11.11);
        listDouble.add(22.22);
        CalculateSum<Double> sumDouble = new CalculateSum<Double>();
        Double totalSum = sumDouble.getSumOfNumbers(listDouble, new NumberAdder<Double>() {

            @Override
            public Double initialize() {
                return 0.0;
            }

            @Override
            public Double add(Double firstNumber, Double secondNumber) {
                return firstNumber + secondNumber;
            }
        });
        LOGGER.log(Level.INFO, "Sum of Double numbers is : {0}", totalSum);
    }

    /**
     * Used to get sum of integer numbers
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void getSumUsingInteger() {
        listInteger.add(11);
        listInteger.add(22);
        CalculateSum<Integer> sumInteger = new CalculateSum<Integer>();
        Integer totalSum = sumInteger.getSumOfNumbers(listInteger, new NumberAdder<Integer>() {

            @Override
            public Integer initialize() {

                return 0;
            }

            @Override
            public Integer add(Integer firstNumber, Integer secondNumber) {

                return firstNumber + secondNumber;
            }
        });
        LOGGER.log(Level.INFO, "Sum of Integer numbers is : {0}", totalSum);
    }
}
