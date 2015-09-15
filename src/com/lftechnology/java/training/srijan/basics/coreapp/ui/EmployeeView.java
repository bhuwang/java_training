package com.lftechnology.java.training.srijan.basics.coreapp.ui;
import com.lftechnology.java.training.srijan.basics.coreapp.controller.EmployeeManagementController;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.UserRole;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeView {
	private static final Logger LOGGER = Logger.getLogger(EmployeeView.class.getName());

	public static void main(String[] args) {
		String userName = "";
		String password = "";
		Scanner input = null;
		UserRole role;
		EmployeeManagementController controller = new EmployeeManagementController();
		try{
			input = new Scanner(System.in);
			LOGGER.info("Enter UserName:");
			userName = input.nextLine();
			LOGGER.info("Enter Password:");
			password = input.nextLine();
			role = controller.save(userName, password);
			if(UserRole.ADMIN.equals(role)){
				LOGGER.log(Level.INFO,"ADMIN");
				adminAccess(controller);
			}
			else if(UserRole.USER.equals(role)){
				LOGGER.log(Level.INFO,"USER");
				normalAccess(controller,userName);
			}
			else{
				LOGGER.log(Level.INFO,"Invalid User Role");
			}
		}catch(Exception ex){
			LOGGER.log(Level.INFO,"Error {0}",ex);
		}finally{
			input.close();
		}
	}
	
	public static void adminAccess(EmployeeManagementController controller){
		int userInput = 0;
		LOGGER.log(Level.INFO,"\n1.Add User\n2.Edit User \n3.Terminate User\n4.View Employee");
		Scanner input = null;
		try{
			input = new Scanner(System.in);
			userInput = input.nextInt();
			controller.adminUserOptionHandler(userInput);
		}catch(Exception ex){
			LOGGER.log(Level.INFO,"Error:{0}",ex);
		}finally{
			input.close();
		}	
	}
	
	public static void normalAccess(EmployeeManagementController controller,String userName){
		int userInput = 0;
		Scanner input = null;
		LOGGER.log(Level.INFO,"\n1.View All User\n2.Edit Personal Details");
		try{
			input = new Scanner(System.in);
			userInput = input.nextInt();
			controller.normalUserOptionHandler(userInput,userName);
		}catch(Exception ex){
			LOGGER.log(Level.INFO,"Error:{0}",ex);
		}finally{
			input.close();
		}
	}
}
