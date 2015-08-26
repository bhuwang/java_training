package com.lftechnology.java.training.krishna.basics.gpa;

import java.util.Comparator;
import java.util.Map;

/**
 * CheckComparator.java
 * 
 * This program sort the dataset list
 * 
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class CheckComparator implements Comparator {
	private Map<Integer, Object> mp;

	public CheckComparator(Map<Integer, Object> studentData) {
		this.mp = studentData;
	}

	@Override
	public int compare(Object o1, Object o2) {

		StudentReport studentReport1 = (StudentReport) mp.get(o1);
		StudentReport studentReport2 = (StudentReport) mp.get(o2);
		if (studentReport1.getPercentage() > studentReport2.getPercentage()) {
			return -1;
		} else if (studentReport1.getPercentage() < studentReport2
				.getPercentage()) {
			return 1;
		} else {
			return 0;
		}

	}

}
