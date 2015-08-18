package com.lftechnology.java.training.sanish.student;

import java.util.ArrayList;

/**
 * Provide student information
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Student implements Comparable<Student> {
	private String name;
	private int roll;
	private ArrayList<Mark> marks = new ArrayList<Mark>();
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

	public ArrayList<Mark> getMarks() {
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
		return (this.getResult().getTotalMarks() - student.getResult()
				.getTotalMarks());
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + ", marks=" + marks
				+ ", result=" + result + "]";
	}
}
