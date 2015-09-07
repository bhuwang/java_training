package com.lftechnology.java.training.sanish.generics.product;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generic product class
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Product<T> {
    private static final Logger LOGGER = Logger.getLogger(Product.class.getName());
    private T product;

    private Product() {
    }

    public Product(T product) {
        this.product = product;
    }

    /**
     * Display product information
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void displayProductInfo() {
        LOGGER.log(Level.INFO, "Product Information : \n" +
                "==================================== \n" +
                "{0}", new Object[] { product.toString() });
    }
}
