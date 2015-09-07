package com.lftechnology.java.training.niraj.genericsum;

/**
 * SumService Implementation for Integer
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class IntegerSumServiceImpl implements SumService<Integer> {

    /**
     * Get sum of two integers
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param num1
     *            {@link Integer}
     * @param num2
     *            {@link Integer}
     */
    @Override
    public Integer sum(Integer num1, Integer num2) {
        return num1 + num2;
    }

}
