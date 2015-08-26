
package com.lftechnology.java.training.krishna.basics.gpa;

/**
 * Subject.java This program store subject and marks information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class Subject {

	private String subjectName;
	private int marks;

	public Subject(String subjectName, int marks) {

		this.subjectName = subjectName;
		this.marks = marks;
	}

	public String getSubjectName() {

		return subjectName;
	}

	public void setSubjectName(String subjectName) {

		this.subjectName = subjectName;
	}

	public int getMarks() {

		return marks;
	}

	public void setMarks(int marks) {

		this.marks = marks;
	}

	@Override
	public String toString() {

		return "Subject [subjectName=" + subjectName + ", marks=" + marks + "]";
	}

}
