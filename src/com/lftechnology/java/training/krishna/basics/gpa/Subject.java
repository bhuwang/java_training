package com.lftechnology.java.training.krishna.basics.gpa;

/**
 * Subject.java
 * 
 * This program store subject and marks information
 * 
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class Subject {
	private String subject;
	private int marks;

	public Subject(String subject, int marks) {
		this.subject = subject;
		this.marks = marks;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Subject [subject=" + subject + ", marks=" + marks + "]";
	}

}
