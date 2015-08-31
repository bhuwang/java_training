package com.lftechnology.java.training.alina.basic.calculategpa;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a program that calculates percentage and GPA of 5 students. User will enter the marks of each 5 students from the keyboard. Each of
 * the students has following attributes: name, class, rollnum, and marks obtained in 5 subjects. Calculate the GPA and show the student
 * name and GPA by position.[higher GPA should display on top]
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class CalculateGPA {
    private static final Logger LOGGER = Logger.getLogger(CalculateGPA.class.getName());

    private CalculateGPA() {
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            MarksValidation validation = new MarksValidation();
            int studentNo = validation.numberValidation(input, "Enter number of Students : ");
            Student.getStudentDetails(input, studentNo);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
        }
    }
}