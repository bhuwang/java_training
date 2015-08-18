package com.lftechnology.java.training.krishna.basics.stemleaf;

import java.util.List;

public class Utils {
	
	public static StringBuilder implode(List<Integer> array, String separator){

		int arraySize = array.size();
		// StringBuilder to store comma separated string
		StringBuilder output = new StringBuilder();
		// iterate over list,append numbers and comma until last element
		for (int k = 0; k < arraySize; k++) {
			output.append(array.get(k));
			if (k != arraySize - 1) {
				output.append(separator);
			}
		}
		return output;
	}

}
