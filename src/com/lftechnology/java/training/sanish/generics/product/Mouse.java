package com.lftechnology.java.training.sanish.generics.product;

/**
 * Mouse product
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Mouse {
    private String brandName;
    private String type;

    public Mouse(String brandName, String type){
        this.brandName = brandName;
        this.type = type;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getType() {
        return type;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override public String toString() {
        return "Mouse{" +
                "brandName='" + brandName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
