package com.lftechnology.java.training.sanish.sumnumber;

/**
 * Provide functions to sum multiplies
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class SumMultiples {
    private SumMultiples() {

    }

    /**
     * Return sum of multiples of number within given limit
     *
     * @param num   {@link Integer} number
     * @param limit {@link Integer} below which have to found sum of multiples of
     *              number
     * @return sum {@link Integer} of multiples
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static int getMultiples(int num, int limit) {
        int maxMultipleNum = limit / num;
        return (maxMultipleNum * (maxMultipleNum + 1) / 2) * num;
    }
}
