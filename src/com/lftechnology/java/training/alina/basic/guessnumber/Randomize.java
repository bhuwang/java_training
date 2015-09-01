package com.lftechnology.java.training.alina.basic.guessnumber;

import java.util.Random;

/**
 * Used to get the random sets of numbers
 *
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class Randomize {

    private Randomize() {

    }

    /**
     * Function that generates the random number
     *
     * @param maxLimit
     *            {@link Integer} maximum number limit
     * @return randomGeneratedNumber random number
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static int generateRandomNumber(int minLimit, int maxLimit) {

        int randomGeneratedNumber = 0;
        Random random = new Random();
        randomGeneratedNumber = random.nextInt(maxLimit - minLimit) + minLimit;
        return randomGeneratedNumber;
    }
}
