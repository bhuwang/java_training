package com.lftechnology.java.training.srijan;

import java.util.Scanner;
import java.util.logging.Logger;

public class FirstTutorial {
	private static final Logger LOGGER = Logger.getLogger(FirstTutorial.class.getName());
public static void main(String[] args){
		Scanner input = null;
		try{
			input = new Scanner(System.in);
			System.out.println("Enter your Name with Salutation");
			String nameWithSalutation = input.nextLine();
			nameWithSalutation=nameWithSalutation.trim();
			LOGGER.info("Name with salutation"+ nameWithSalutation);
			
			String[] text = nameWithSalutation.split(" ");
			LOGGER.info("Salutation:" + text[0]);
			//System.out.println("Name:" + text[1] +" "+ text[2]);
			LOGGER.info("Name:");
			for(int i=1;i<text.length;i++){
				System.out.print(text[i] +" ");
			}
		}catch(Exception e){
			LOGGER.info("There is an exception" + e);
		}finally{
			input.close();
		}
	}
}
