package com.lftechnology.java.training.sanish.student;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Calculate GPA of students
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class CalculateGPA {
	private final static Logger LOGGER = Logger.getLogger(CalculateGPA.class
			.getName());
	private int studentNumber = 0;
	private ArrayList<Student> students = new ArrayList<Student>();

	public static void main(String args[]) {
		CalculateGPA calculateGPA = new CalculateGPA();
		try (Scanner scanner = new Scanner(System.in)) {
			LOGGER.log(Level.INFO, "Enter number of students : ");
			calculateGPA.setStudentNumber(UserInput.getNumber(scanner,
					Constants.MIN_STUDENT_NUM, Constants.MAX_STUDENT_NUM));
			calculateGPA.getStudentName(scanner);
		} catch (NumberFormatException e) {
			LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
		}
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	/**
	 * Get student names
	 * @param scanner {@link Scanner}
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public void getStudentName(Scanner scanner){
		String studentName;
		int rollNumber;
		for(int i=0; i< this.studentNumber; i++){
			rollNumber = i+1;
			LOGGER.log(Level.INFO, "Enter roll number {0} student name : ", new Object[] { rollNumber });
			studentName = UserInput.getName(scanner);
			Student student = new Student(studentName, rollNumber);
			students.add(student);
		}
	}
}
