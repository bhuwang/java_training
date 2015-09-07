package com.lftechnology.java.training.niraj.genericsum;

/**
 * SumService implementation for Double
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class DoubleSumServiceImpl implements SumService<Double> {

    /**
     * Gets sum of two doubles
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param num1
     *            {@link Double}
     * @param num2
     *            {@link Double}
     */
    @Override
    public Double sum(Double num1, Double num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

}
