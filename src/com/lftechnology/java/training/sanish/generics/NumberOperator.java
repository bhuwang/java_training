package com.lftechnology.java.training.sanish.generics;

/**
 * Number operator
 *
 * @param <T> {@link Number}
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class NumberOperator<T extends Number> {
    /**
     * Generic function that add two numbers
     *
     * @param num1 {@link Number}
     * @param num2 {@link Integer}
     * @return {@link Number}
     */
    public Number addTwoNumbers(T num1, T num2) {
        Number sumNum;
        if (num1 instanceof Integer) {
            sumNum = num1.intValue() + num2.intValue();
        } else {
            sumNum = num1.doubleValue() + num2.doubleValue();
        }

        return sumNum;
    }
}