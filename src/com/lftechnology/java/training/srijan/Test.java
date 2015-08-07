package com.lftechnology.java.training.srijan;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args){
		
		Scanner input = null;
		
		try{
			input = new Scanner(System.in);
			System.out.println("Enter your Name with Salutation");
			String nameWithSalutation = input.nextLine();
			System.out.printf("%n%s%n", nameWithSalutation);
			
			String[] text = nameWithSalutation.split(" ");
			System.out.println("Salutation:" + text[0]);
			//System.out.println("Name:" + text[1] +" "+ text[2]);
			System.out.println("Name:");
			for(int i=1;i<text.length;i++){
				System.out.print(text[i] +" ");
			}
		}catch(Exception e){
			System.out.println("There is an exception" + e);
		}finally{
			input.close();
		}
	}
}
