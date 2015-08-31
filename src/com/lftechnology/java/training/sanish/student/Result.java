package com.lftechnology.java.training.sanish.student;

/**
 * Provide result information
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Result {
    private int totalMarks;
    private float percentage;
    private char grade;

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    @Override
    public String toString() {
        return "Result [totalMarks=" + totalMarks + ", percentage="
                + percentage + ", grade=" + grade + "]";
    }

}
