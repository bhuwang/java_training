package com.lftechnology.java.training.niraj.ems.utils;

import java.util.Scanner;

/**
 * Interface related to services for user input
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 * @param <T>
 */
public interface UserInput<T> {

    /**
     * Get the input from the user
     * 
     * @author Niraj Rajbhandari <nirajrajbahndari@lftechnology.com>
     * @param min
     * @param max
     * @return int input provided by the user
     */
    public T getInput(Scanner scanner);
}
