package com.lftechnology.java.training.sanish.multiplenumber;

/**
 * Provide functions to get multiples of number
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Multiplier {
    private Multiplier() {

    }

    /**
     * Return smaller multiple number form given range
     *
     * @param from {@link Integer}first number that have to find multiple
     * @param to   {@link Integer} last number that have to find multiple
     * @return smaller {@link Integer} multiple number
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static int getSmallerMultipleNum(int from, int to) {
        int smallerMultipleNum = from;
        int sumNumber;
        for (int i = from; i <= to; i++) {
            sumNumber = smallerMultipleNum;
            while (sumNumber % i != 0) {
                sumNumber += smallerMultipleNum;
            }

            smallerMultipleNum = sumNumber;
        }
        return smallerMultipleNum;
    }
}
