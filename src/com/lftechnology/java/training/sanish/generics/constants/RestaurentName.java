package com.lftechnology.java.training.sanish.generics.constants;

/**
 * Provide restaurant name
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public enum RestaurentName {
    ID_1("Cafe Time"), ID_2("Launch Hour"), ID_3("Thakali Restaurant");
    private String restaurantName;
    RestaurentName(String restaurantName){
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName(){
        return  this.restaurantName;
    }
}
