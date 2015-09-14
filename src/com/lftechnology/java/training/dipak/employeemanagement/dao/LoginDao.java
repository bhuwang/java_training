package com.lftechnology.java.training.dipak.employeemanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.api.UserApi;
import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.User;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;

public class LoginDao implements UserApi{
	private static final Logger LOGGER=Logger.getLogger(LoginDao.class.getName());
	
	@Override
	public Employee validateLogin(User u) {
		LOGGER.info("Inside LoginDao #validateLogin");
		Employee employee=new Employee();
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		//Statement st=null;
		
		con=DbConnection.setConnection();
		//String sql="Select * from employee where username = '"+u.getUserName()+"' and password='"+u.getPassword()+"'";
		
		String sql="select * from employee where username= ? and password= ? and isTerminated=false";
		
		if(con!=null) {
			try {
				//st=con.createStatement();
				
				//rs=st.executeQuery(sql);
										
				
				
				
//				con.setAutoCommit(false);
				
				pst=con.prepareStatement(sql);
				
				pst.setString(1, u.getUserName());
				pst.setString(2, u.getPassword());
				
				rs=pst.executeQuery();
							
							
				
				
				
				LOGGER.info("here");
//				con.commit();
				
				if(rs.next()) {
						employee.setId(rs.getInt("eid"));
						employee.setUserName(rs.getString("username"));
						employee.setPassword(rs.getString("password"));
						employee.setAddress(rs.getString("address"));
						employee.setIsTerminated(rs.getBoolean("isTerminated"));
						employee.setDepartment(rs.getString("department"));
						employee.setFullName(rs.getString("fullname"));
						UserType ut=UserType.valueOf(rs.getString("role"));
						employee.setRole(ut);
					
				}else {
					employee.setId(0);
				}
				
			}
			catch (SQLException e) {
				LOGGER.log(Level.INFO,"{0}",e);
			}finally {
				try {
					con.close();
					pst.close();
					rs.close();
				}
				catch (SQLException e) {
					LOGGER.log(Level.INFO,"{0}",e);
				}
			}
			
		}else {
			LOGGER.info("Database Connection failed");
		}
		return employee;
	}
}
