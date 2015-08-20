package com.lftechnology.java.training.krishna.basics.gpa;

import java.util.ArrayList;

public class Student {
	private int studentId;
	private String name;
	private int classDomain;
	private int rollNumber;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();

	public Student(int studentId, String name, int classDomain, int rollNumber) {
		this.studentId = studentId;
		this.name = name;
		this.classDomain = classDomain;
		this.rollNumber = rollNumber;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public int getClassDomain() {
		return classDomain;
	}

	public void setClassDomain(int classDomain) {
		this.classDomain = classDomain;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjectMarks) {
		this.subjects = subjectMarks;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name
				+ ", classDomain=" + classDomain + ", rollNumber=" + rollNumber
				+ ", subjects=" + subjects + "]";
	}

}
