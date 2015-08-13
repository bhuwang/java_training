package com.lftechnology.java.training.srijan.basics;

public class PalindromeTest {
	
	public static void main(String[] args){
		
		Palindrome palindromeNumber = new Palindrome(100 , 999);
		
		palindromeNumber.setRange(100 , 999);
		
		palindromeNumber.calculatePalindrome(100,999);
	}
}
