
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
	private float studentPercentage;
	private char studentGrade;

	public StudentReport(
		String studentName, int subjectMarks, float studentPercentage,
		char studentGrade) {

		this.studentName = studentName;
		this.subjectMarks = subjectMarks;
		this.studentPercentage = studentPercentage;
		this.studentGrade = studentGrade;
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

	public float getStudentPercentage() {

		return studentPercentage;
	}

	public void setStudentPercentage(float studentPercentage) {

		this.studentPercentage = studentPercentage;
	}

	public char getStudentGrade() {

		return studentGrade;
	}

	public void setStudentGrade(char studentGrade) {

		this.studentGrade = studentGrade;
	}

	@Override
	public String toString() {

		return "StudentReport [studentName=" + studentName + ", subjectMarks=" +
			subjectMarks + ", studentPercentage=" + studentPercentage +
			", studentGrade=" + studentGrade + "]";
	}

}
