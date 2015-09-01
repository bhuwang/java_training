package com.lftechnology.java.training.alina.collections.generics.integerdoublesum;

public interface NumberAdder<T extends Number> {

    /**
     * Used to initialize the number
     * 
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    T initialize();

    /**
     * Used to add two numbers
     * 
     * @param firstNumber
     * @param secondNumber
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    T add(T firstNumber, T secondNumber);
}
