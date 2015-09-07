package com.lftechnology.java.training.niraj.genericsum;

import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * <p>
 * Gets <code>sum</code> of two integer or double
 * </p>
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 * @see java.lang.Integer
 * @see java.lang.Double
 *
 */
public class GenericSum {
    private static final Logger LOGGER = Logger.getLogger(GenericSum.class.getName());

    private GenericSum() {

    }

    public static void main(String[] args) {
        Double doubleSum = GenericSum.getDoubleSum();
        LOGGER.log(Level.INFO, "Double Sum with separate double implementation: {0}", doubleSum);

        Double doubleInstanceSum = GenericSum.getInstanceDoubleSum();
        LOGGER.log(Level.INFO, "Double Sum with checking instance of: {0}", doubleInstanceSum);

        Integer intSum = GenericSum.getIntegerSum();
        LOGGER.log(Level.INFO, "Double Sum with separate integer implementation: {0}", intSum);

        Integer integerInstanceSum = GenericSum.getInstanceIntSum();
        LOGGER.log(Level.INFO, "Integer Sum with checking instance of: {0}", integerInstanceSum);

    }

    /**
     * Gets sum of two double using different implementation as per the Number type
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @return sum of two double
     */
    private static Double getDoubleSum() {
        Double num1 = new Double(12.99);
        Double num2 = new Double(13.01);
        DoubleSumServiceImpl sumDouble = new DoubleSumServiceImpl();
        return sumDouble.sum(num1, num2);
    }

    /**
     * Get sum of two integers using different implementation as per the Number type
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @return sum of two integers
     */
    private static Integer getIntegerSum() {
        Integer num1 = 5;
        Integer num2 = 6;
        IntegerSumServiceImpl sumInteger = new IntegerSumServiceImpl();
        return sumInteger.sum(num1, num2);
    }

    /**
     * Get sum of two numbers by checking the class of the object passed to the method
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param num1
     * @param num2
     * @return sum of two numbers
     */
    private static <T extends Number> T getInstanceSum(T num1, T num2) {

        InstanceSumServiceImpl<T> instanceSum = new InstanceSumServiceImpl<T>();
        return instanceSum.sum(num1, num2);
    }

    /**
     * Gets sum of two integer number using the function that checks the class of the object passed to the method
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @return sum {@link Integer}
     */
    private static Integer getInstanceIntSum() {
        Integer sum = null;
        try {
            Integer num1 = 4;
            Integer num2 = 5;
            sum = GenericSum.<Integer> getInstanceSum(num1, num2);
        } catch (InputMismatchException e) {
            LOGGER.log(Level.SEVERE, "Exception: {0}", e);
        }
        return sum;

    }

    /**
     * Gets sum of two double number using the function that checks the class of the object passed to the method
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @return sum {@link Double}
     */
    private static Double getInstanceDoubleSum() {
        Double sum = null;
        try {
            Double num1 = new Double(51.05);
            Double num2 = new Double(48.95);
            sum = GenericSum.<Double> getInstanceSum(num1, num2);
        } catch (InputMismatchException e) {
            LOGGER.log(Level.SEVERE, "Exception: {0}", e);
        }
        return sum;

    }

}
