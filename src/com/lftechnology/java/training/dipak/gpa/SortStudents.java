
package com.lftechnology.java.training.dipak.gpa;

public class SortStudents {
	
	/**
	 * This method sorts the students based on the gpa value.
	 * @param gp
	 * @return gp array of objects
	 */
	public static GPA[] sortStudents(GPA[] gp) {

		GPA temp;
		for (int i = gp.length; i >= 0; i--) {
			for (int j = gp.length - 1 - i; j > 0; j--) {
				if (gp[j].studentGpa > gp[j - 1].studentGpa) {
					temp = gp[j];
					gp[j] = gp[j - 1];
					gp[j - 1] = temp;
				} 
			}
		}
		return gp;
	}
}
