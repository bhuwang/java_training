package com.lftechnology.java.training.sanish.student;

import java.util.logging.Logger;

/**
 * Student Class
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Student {
	private static final Logger LOGGER = Logger.getLogger(Student.class
			.getName());
	private String name;
	private int roll;

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

	public String toString() {
		return "Name : " + this.name + ", Class : " + this.roll;
	}
}
