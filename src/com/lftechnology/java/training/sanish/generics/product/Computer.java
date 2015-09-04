package com.lftechnology.java.training.sanish.generics.product;

/**
 * Computer product
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Computer {
    private String brandName;
    private String processor;
    private String memorySize;
    private String diskSize;

    public Computer(String brandName, String processor, String memorySize, String diskSize){
        this.brandName = brandName;
        this.processor = processor;
        this.memorySize = memorySize;
        this.diskSize = diskSize;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getProcessor() {
        return processor;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public String getDiskSize() {
        return diskSize;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    public void setDiskSize(String diskSize) {
        this.diskSize = diskSize;
    }

    @Override public String toString() {
        return "Computer{" +
                "brandName='" + brandName + '\'' +
                ", processor='" + processor + '\'' +
                ", memorySize='" + memorySize + '\'' +
                ", diskSize='" + diskSize + '\'' +
                '}';
    }
}
