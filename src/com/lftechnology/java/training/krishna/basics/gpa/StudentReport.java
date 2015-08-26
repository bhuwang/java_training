
package com.lftechnology.java.training.krishna.basics.gpa;

/**
 * StudentReport.java This program stores student information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class StudentReport {

	private String name;
	private int marks;
	private float percentage;
	private char grade;

	public StudentReport(String name, int marks, float percentage, char grade) {

		this.name = name;
		this.marks = marks;
		this.percentage = percentage;
		this.grade = grade;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public int getMarks() {

		return marks;
	}

	public void setMarks(int marks) {

		this.marks = marks;
	}

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

	@Override
	public String toString() {

		return "StudentReport [name=" + name + ", marks=" + marks +
			", percentage=" + percentage + ", grade=" + grade + "]";
	}

}