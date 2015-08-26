package com.lftechnology.java.training.dipak.leafandstem;

/**
 *This is a bubble sort program that sorts the integer array in ascending order.
 *@param int[] array
 *@return array (Sorted array)
 *@author Dipak Thapa <dipakthapa@lftechnology.com>
 *
 */
public class BubbleSort {
	private BubbleSort(){
		
	}
	public static final int[] sortArray(int[] array) {
		int temp;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

		return array;
	}
}
