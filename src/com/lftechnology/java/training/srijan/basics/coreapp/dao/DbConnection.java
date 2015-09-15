package com.lftechnology.java.training.srijan.basics.coreapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
	private static final Logger LOGGER = Logger.getLogger(DbConnection.class.getName());
	public static Connection dbConnection(){
		String USER_NAME = "root";
		String PASS = "liferay";
		String URL = "jdbc:mysql://localhost:3306/ems";
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER_NAME, PASS);
		} catch (SQLException e) {
			LOGGER.log(Level.INFO, "SQLException: {0}", e);
		} catch (ClassNotFoundException e) {
			LOGGER.log(Level.INFO, "ClassNotFoundException: {0}", e);
		}
		return connection;
	}
}
