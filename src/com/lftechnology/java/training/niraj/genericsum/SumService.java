package com.lftechnology.java.training.niraj.genericsum;

/**
 * Interface that defines the contract for adding two object that is object of parent class Number
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 * @param <T>
 */
public interface SumService<T extends Number> {

    public T sum(T num1, T num2);
}
