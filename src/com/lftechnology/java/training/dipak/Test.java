package com.lftechnology.java.training.dipak;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter your name with Salutation::");
		String inputName=scanner.nextLine();
		inputName=inputName.trim();
		
		String[] text=inputName.split(" ");
		
		System.out.println("Salutation::"+text[0]);
		String name="";
		
		for(int i=1;i<text.length;i++){			
			if(!(text[i].length()==0)){
				name=name+text[i]+" ";
			}					
			
		}
		System.out.println("Your name::"+name);
		scanner.close();
	}

}
