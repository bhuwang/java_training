package com.lftechnology.java.training.sanish.generics.product;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sanish on 9/4/15.
 */
public class Product<T> {
    private static final Logger LOGGER = Logger.getLogger(Product.class.getName());
    private T product;
    public Product(T product){
        this.product = product;
    }

    /**
     * Display product information
     * @author <
     */
    public void displayProductInfo(){
        LOGGER.log(Level.INFO, "Product Information : \n" +
                "==================================== \n" +
                "{0}", new Object[] { product.toString() });
    }
}
