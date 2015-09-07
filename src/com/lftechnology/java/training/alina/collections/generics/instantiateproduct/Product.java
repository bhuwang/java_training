package com.lftechnology.java.training.alina.collections.generics.instantiateproduct;

/**
 * Product Class consists of products of different data types
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 * @param <T1>
 * @param <T2>
 */
public class Product<T, K> {

    private T product1;
    private K product2;

    public Product(T product1, K product2) {

        this.setProduct1(product1);
        this.setProduct2(product2);
    }

    public T getProduct1() {

        return product1;
    }

    public void setProduct1(T product1) {

        this.product1 = product1;
    }

    public K getProduct2() {

        return product2;
    }

    public void setProduct2(K product2) {

        this.product2 = product2;
    }

    @Override
    public String toString() {

        return "\tProduct1" + "\tType : " + product1.getClass().getName() + "\t\tValue : " + getProduct1() + "\n\tProduct2" + "\tType : "
                + product2.getClass().getName() + "    \tValue : " + getProduct2();
    }
}
