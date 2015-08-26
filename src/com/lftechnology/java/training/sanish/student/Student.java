package com.lftechnology.java.training.sanish.student;

import java.util.ArrayList;
import java.util.List;

/**
 * Provide student information
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Student implements Comparable<Student> {
    private String name;
    private int roll;
    private List<Mark> marks = new ArrayList<Mark>();
    private Result result = new Result();

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setMark(String subject, int markObtain) {
        Mark mark = new Mark(subject, markObtain);
        this.marks.add(mark);
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public int compareTo(Student student) {
        return getResult().getTotalMarks() - student.getResult().getTotalMarks();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        if (roll == student.roll)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result1 = name != null ? name.hashCode() : 0;
        result1 = 31 * result1 + roll;
        result1 = 31 * result1 + (marks != null ? marks.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override

    public String toString() {
        return "Student [name=" + name + ", roll=" + roll + ", marks=" + marks
                + ", result=" + result + "]";
    }
}
