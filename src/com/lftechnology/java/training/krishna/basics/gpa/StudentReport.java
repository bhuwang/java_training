
package com.lftechnology.java.training.krishna.basics.gpa;

/**
 * StudentReport.java This program stores student information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class StudentReport {

	private String studentName;
	private int subjectMarks;
	private float percentage;
	private char grade;

	public StudentReport(
		String studentName, int subjectMarks, float percentage, char grade) {

		this.studentName = studentName;
		this.subjectMarks = subjectMarks;
		this.percentage = percentage;
		this.grade = grade;
	}

	public String getStudentName() {

		return studentName;
	}

	public void setStudentName(String studentName) {

		this.studentName = studentName;
	}

	public int getSubjectMarks() {

		return subjectMarks;
	}

	public void setSubjectMarks(int subjectMarks) {

		this.subjectMarks = subjectMarks;
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

		return "StudentReport [studentName=" + studentName + ", subjectMarks=" +
			subjectMarks + ", percentage=" + percentage + ", grade=" + grade +
			"]";
	}

}
