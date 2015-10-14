
package com.lftechnology.java.training.krishna.employeemanagement.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.krishna.employeemanagement.utils.ConstantUtils;

/**
 * This program is used to connect database.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class DbConnectionFactory {

	private static final Logger LOGGER =
		Logger.getLogger(DbConnectionFactory.class.getName());
	public static final String DB_URL =
		"jdbc:mysql://localhost/employee_management";
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";

	private static Connection connection = null;
	private static PreparedStatement preparedStatement;

	// constructor
	private DbConnectionFactory() {

	}

	/**
	 * This method is used to connect database.
	 *
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 * @return connection
	 * @version 1.0
	 */
	public static Connection getDbConnection() {

		if (connection == null) {
			try {
				Class.forName(JDBC_DRIVER);
				connection =
					DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			}
			catch (SQLException | ClassNotFoundException e) {
				LOGGER.log(
					Level.SEVERE,
					"DBConnectionException: Unable to Connect to Database. {0}",
					e);

			}
		}
		return connection;

	}
	/**
	 * This method is used to close prepared statement.
	 *
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 * @version 1.0
	 */
	public static void closePreparedStatement() {

		try {

			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
		catch (SQLException e) {
			LOGGER.log(Level.SEVERE, ConstantUtils.ERROR_STATEMENT, e);
		}
	}

}
