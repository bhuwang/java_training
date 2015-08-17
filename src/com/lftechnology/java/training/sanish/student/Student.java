package com.lftechnology.java.training.sanish.student;

import java.util.ArrayList;

/**
 * Student Class
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Student {
	private String name;
	private int roll;
	private ArrayList<Mark> marks = new ArrayList<Mark>();

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
	
	public void setMask(String subject, int maskObtain){
		Mark mark = new Mark(subject, maskObtain);
		this.marks.add(mark);
	}
	
	public String toString() {
		return "Name : " + this.name + ", Class : " + this.roll;
	}
}
