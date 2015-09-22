package com.lftechnology.java.training.sanish.generics.constants;

/**
 * Provide restaurant name
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public enum RestaurentName {
    ID_1("Cafe Time"), ID_2("Launch Hour"), ID_3("Thakali Restaurant");
    private String restaurant;
    RestaurentName(String restaurant){
        this.restaurant = restaurant;
    }

    public String getRestaurantName(){
        return  this.restaurant;
    }
}
