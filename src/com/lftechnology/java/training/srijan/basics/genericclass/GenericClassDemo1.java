package com.lftechnology.java.training.srijan.basics.genericclass;

public class GenericClassDemo1 {
	public static <T extends Comparable<T>> T maximum (T x, T y, T z){
		T max = x;
		if(y.compareTo(max)>0){
			max = y;
		}
		if(z.compareTo(max)>0){
			max = z;
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.printf("Maximum of %d %d %d is %d\n",6,5,7,maximum(6,5,7));
		System.out.printf("Maximum of %f %f %f is %f\n",6.6,8.8,7.7,maximum(6.6,8.8,7.7));
		System.out.printf("Maximum of %s %s %s is %s\n","pear","apple","orange",maximum("pear","apple","orange"));
	}
}
