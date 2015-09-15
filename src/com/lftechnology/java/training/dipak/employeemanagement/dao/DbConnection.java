
package com.lftechnology.java.training.dipak.employeemanagement.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>This class has a static method for establishing database connection.</p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class DbConnection {

	private static final Logger LOGGER =
		Logger.getLogger(DbConnection.class.getName());

	private DbConnection() {
	}

	/**
	 * <p>This method is used to set database connection.</p>
	 * 
	 * @return connection
	 */
	public static Connection setConnection() {

		String userName = "root";
		String password = "liferay";
		String url = "jdbc:mysql://localhost:3306/ems";

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(url, userName, password);

		}
		catch (ClassNotFoundException e) {
			LOGGER.log(Level.INFO, "{0}", e);
		}
		catch (SQLException e) {
			LOGGER.log(Level.INFO, "{0}", e);
		}
		return connection;
	}

}
