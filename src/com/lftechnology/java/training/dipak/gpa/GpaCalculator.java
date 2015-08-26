package com.lftechnology.java.training.dipak.gpa;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GpaCalculator {
	private GpaCalculator(){
		
	}
	/**
	 * This method computes the gpa.
	 * @param marks
	 * @return sum
	 */
	public static float calculateGpa(int[] marks) {
		float sum=0;
		for(int i=0;i<marks.length;i++){
			sum+=marks[i];
		}
		sum=(sum/500)*100;
		sum=BigDecimal.valueOf(sum/25).setScale(1, RoundingMode.HALF_UP).floatValue();
		return sum;
	}

}
