package com.lftechnology.java.training.niraj.genericsum;

import java.util.InputMismatchException;

/**
 * 
 * Implementation of Sum Service with checking the instance of the object passed to the function to get the sum
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 * @see Generics
 *
 */
public class InstanceSumServiceImpl<T extends Number> implements SumService<T> {

    /**
     * Gets sum of two Numbers
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param num1
     * @param num2
     * @return sum of two numbers
     * @throws InputMismatchException
     */
    @Override
    public T sum(T num1, T num2) throws InputMismatchException {
        if (num1 instanceof Double) {
            Double sumValue;
            sumValue = num1.doubleValue() + num2.doubleValue();
            return (T) sumValue;
        } else if (num1 instanceof Integer) {
            Integer sumValue;
            sumValue = num1.intValue() + num2.intValue();
            return (T) sumValue;
        } else {
            throw new InputMismatchException("Please provide a valid input");
        }
    }

}
