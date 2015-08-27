package com.lftechnology.java.training.srijan.basics.percentage;

import java.util.logging.Logger;

/**
 * Write a program that calculates percentage and GPA of 5 students. User will
 * enter the marks of each 5 students from the keyboard. Each of the students
 * has following attributes: name, class, rollnum, and marks obtained in 5
 * subjects. Calculate the GPA and show the student name and GPA by
 * position.[higher GPA should display on top]
 * 
 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
 *
 */

public class Calculator {
	private float subject1;
	private float subject2;
	private float subject3;
	private float subject4;
	private float subject5;
	private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());

	private String[] nameOfStudent = new String[5];
	private float[] gpaOfStudent = new float[5];
	private int countStudent = 0;
	private int countGpa = 0;

	public Calculator(float subject1, float subject2, float subject3, float subject4, float subject5) {
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.subject4 = subject4;
		this.subject5 = subject5;
	}

	public void setSubjectMarks(float subject1, float subject2, float subject3, float subject4, float subject5) {
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.subject4 = subject4;
		this.subject5 = subject5;
	}

	public float getSubject1Marks() {
		return subject1;
	}

	public float getSubject2Marks() {
		return subject2;
	}

	public float getSubject3Marks() {
		return subject3;
	}

	public float getSubject4Marks() {
		return subject4;
	}

	public float getSubject5Marks() {
		return subject5;
	}

	/**
	 * <p>
	 * Shows Entered marks of a student
	 * </p>
	 * 
	 * @param studentName {@link Float}
	 * @param subjectMarks {@link Float}
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */

	public void showMarksEntered(String studentName, float[] subjectMarks) {
		float sum = 0;
		float percentage;
		float gpa;

		nameOfStudent[countStudent++] = studentName;
		LOGGER.info("Name of Student is:" + studentName);
		for (int i = 1; i <= 5; i++) {
			LOGGER.info("Marks in subject" + i + " " + "is" + " " + subjectMarks[i - 1]);
			sum = sum + subjectMarks[i - 1];
		}
		LOGGER.info("sum = " + sum);

		percentage = calculatePercentage(sum, 500);
		LOGGER.info("The percentage obtained by student is:" + percentage + "%");

		gpa = calculateGPA(percentage);
		gpaOfStudent[countGpa++] = gpa;
		LOGGER.info("The GPA obtained by student is:" + gpa);

	}

	/**
	 * <p>
	 * Calculates percentage of 5 subjects
	 * </p>
	 * 
	 * @param sum {@link Float}
	 * @param total {@link Float}
	 * @return percentage {@link Float}
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */

	public float calculatePercentage(float sum, float total) {
		return (sum / total) * 100;
	}

	/**
	 * <p>
	 * Calculates GPA from obtained Percentage
	 * </p>
	 * 
	 * @param percentage {@link Float}
	 * @return GPA {@link Float}
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */

	public float calculateGPA(float percentage) {
		return (4 * percentage) / 100;
	}

	/**
	 * <p>
	 * Calculates highest GPA and student who obtained highest GPA
	 * </p>
	 * <p>
	 * Displays name and highest GPA obtained
	 * </p>
	 * 
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */

	public void highestGPA() {
		float highestGpa = 0;
		String student = "";
		for (int i = 1; i <= countGpa; i++) {
			if (highestGpa < gpaOfStudent[i - 1]) {
				highestGpa = gpaOfStudent[i - 1];
				student = nameOfStudent[i - 1];
			}
		}
		LOGGER.info("Student obtaining highest GPA is:" + student);
		LOGGER.info("Hightest GPA obtained = " + highestGpa);
	}

}