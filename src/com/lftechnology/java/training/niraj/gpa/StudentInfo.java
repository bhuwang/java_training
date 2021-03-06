package com.lftechnology.java.training.niraj.gpa;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Student Personal and Academic Information
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class StudentInfo implements Comparable<StudentInfo> {

	private static final Logger LOGGER = Logger.getLogger(StudentInfo.class
			.getName());
	private String name;
	private int roll;
	private int standard;
	private int markObtained;
	private float percentage;
	private char grade;
	private Map<String, Integer> marks = new HashMap<String, Integer>();

	public StudentInfo() {

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

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public Map<String, Integer> getMarks() {
		return marks;
	}

	public void setMarks(String key, int value) {
		this.marks.put(key, value);
	}

	public int getMarkObtained() {
		return markObtained;
	}

	public void setMarkObtained(int markObtained) {
		this.markObtained = markObtained;
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
		return "\n name=" + name + "\n roll=" + roll + "\n class=" + standard
				+ "\n markObtained=" + markObtained + "\n percentage="
				+ percentage + "%\n grade=" + grade + "\n marks=" + marks
				+ "\n\n";
	}

	@Override
	public int compareTo(StudentInfo studentInfo) {

		int markToCompare = studentInfo.getMarkObtained();
		return this.getMarkObtained() - markToCompare;
	}


	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + markObtained;
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentInfo other = (StudentInfo) obj;
		if (markObtained != other.markObtained)
			return false;
		return true;
	}

	/**
	 * Sets student information
	 * 
	 * @param scanner
	 *            {@link Scanner}
	 * @author Niraj Rajbhandari@lftechnology.com
	 */
	public void setStudentInfo(Scanner scanner) {

		LOGGER.log(Level.INFO, "Name: ");
		setName(scanner.next());

		LOGGER.log(Level.INFO, "Class: ");
		while (!scanner.hasNextInt()) {
			LOGGER.log(Level.WARNING, "Please provide a number :");
			scanner.next();
		}
		setStandard(scanner.nextInt());

		LOGGER.log(Level.INFO, "Roll No: ");
		while (!scanner.hasNextInt()) {
			LOGGER.log(Level.WARNING, "Please provide a number :");
			scanner.next();
		}
		setRoll(scanner.nextInt());
		Grade.setSubjectMarks(scanner, this);
	}

	/**
	 * Get sorted list of student information by total marks obtained
	 * 
	 * @param studentInfo
	 *            {@link StudentInfo}
	 * @param order
	 *            {@link Constants} ASCENDING | DESCENDING
	 * @return {@link List}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public static List<StudentInfo> getSortedStudentInfoList(
			List<StudentInfo> studentInfo, String order) {

		if (order.equals(Constants.ASCENDING)) {
			Collections.sort(studentInfo);
		} else {
			Comparator<StudentInfo> comparator = Collections.reverseOrder();
			Collections.sort(studentInfo, comparator);
		}

		return studentInfo;
	}

}
