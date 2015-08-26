
package com.lftechnology.java.training.dipak.gpa;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * program that calculates percentage and GPA of 5 students. User enters the
 * marks of each 5 students from the keyboard. Each of the students has
 * following attributes: name, class, rollnum, and marks obtained in 5 subjects.
 * Calculates the GPA and shows the student name and GPA by position.[higher GPA
 * should display on top]
 * 
 * @author dipak
 */
public class GPA {

	String studentName;
	int studentRoll;
	String studentClass;
	float studentGpa;
	private static final Logger LOGGER = Logger.getLogger(GPA.class.getName());

	public GPA(String name, int roll, String className, float gpa) {
		studentClass = className;
		studentName = name;
		studentRoll = roll;
		studentGpa = gpa;
	}

	
	
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		String[] subjects = {
			"Maths", "Java", "DBMS", "DSC", "MicroControllers"
		};
		int[] marks = new int[5];
		try (Scanner sc = new Scanner(System.in)) {
			LOGGER.info("Enter the number of students:");
			int numberOfStudents = Integer.parseInt(sc.nextLine());
			GPA[] gp = new GPA[numberOfStudents];
			for (int i = 0; i < numberOfStudents; i++) {
				LOGGER.info("Enter the name of student:");
				String name = sc.nextLine();

				LOGGER.info("Enter the roll number of student:");
				int roll = Integer.parseInt(sc.nextLine());

				LOGGER.info("Enter the class of student:");
				String className = sc.nextLine();

				for (int j = 0; j < 5; j++) {
					LOGGER.log(Level.INFO, "Enter marks in {0}", subjects[j]);
					marks[j] = Integer.parseInt(sc.nextLine());
				}
				float gpa = GpaCalculator.calculateGpa(marks);
				gp[i] = new GPA(name, roll, className, gpa);

			}
			gp=SortStudents.sortStudents(gp);
			Results.displayResults(gp);
		}
		catch (NumberFormatException nfe) {
			LOGGER.info("Characters entered in place of integer values.");
			System.exit(0);
		}
	}

}
