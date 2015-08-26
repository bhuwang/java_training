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

            calculateGPA.setStudentInformation(scanner);
            ResultCalculation.calculateResult(calculateGPA.students);
            ResultCalculation.orderByTotalMarks(calculateGPA.students,
                    Constants.DESCENDING);
            calculateGPA.listOutStudents(calculateGPA.students);
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
     * Set student names and marks
     *
     * @param scanner {@link Scanner}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void setStudentInformation(Scanner scanner) {
        String studentName;
        int rollNumber;
        Student student;
        for (int i = 0; i < this.studentNumber; i++) {
            rollNumber = i + 1;
            LOGGER.log(Level.INFO, "Enter roll number {0} student name : ",
                    new Object[]{rollNumber});
            studentName = UserInput.getName(scanner);
            student = new Student(studentName, rollNumber);
            setStudentMarks(scanner, student);
            students.add(student);
        }
    }

    /**
     * Set mark of all subjects of student
     *
     * @param scanner {@link Scanner}
     * @param student {@link Student} Student
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void setStudentMarks(Scanner scanner, Student student) {
        int markObtain;
        for (String subject : Constants.SUBJECT_LIST) {
            LOGGER.log(Level.INFO, "Enter marks obtain in {0} : ",
                    new Object[]{subject});
            markObtain = UserInput.getNumber(scanner, Constants.MIN_MARK,
                    Constants.MAX_MARK);
            student.setMark(subject, markObtain);
        }
    }

    /**
     * Display students list in console
     *
     * @param students {@link ArrayList} list of students
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public void listOutStudents(ArrayList<Student> students) {
        for (Student student : students) {
            LOGGER.log(Level.INFO, student.toString());
        }
    }
}
