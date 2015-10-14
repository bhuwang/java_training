
package com.lftechnology.java.training.krishna.employeemanagement.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.jdbc.ScriptRunner;

import com.lftechnology.java.training.krishna.employeemanagement.jdbc.DbConnectionFactory;
import com.mysql.jdbc.PreparedStatement;

/**
 * This program is used create table and default user.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class MigrationUtils {

	private static final Logger LOGGER =
		Logger.getLogger(MigrationUtils.class.getName());
	Connection connection = DbConnectionFactory.getDbConnection();
	PreparedStatement preparedStatement = null;
	private static final String SQL_SCRIPT_FILE_PATH =
		"/home/krishna/Projects/JAVA-PROJECT/java_training/main/resources/db/migration/createUserTable.sql";

	// constructor
	public MigrationUtils() {

	}

	/**
	 * This method is used to run sql query.
	 *
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 * @version 1.0
	 */
	public void migrate() {

		try {
			// Initialize object for ScripRunner
			ScriptRunner sr = new ScriptRunner(connection);
			Reader reader =
				new BufferedReader(new FileReader(SQL_SCRIPT_FILE_PATH));
			sr.runScript(reader);
			reader.close();

		}
		catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Failed to execute " +
				SQL_SCRIPT_FILE_PATH + " {0}", e);
		}
		
		finally {
			DbConnectionFactory.closePreparedStatement();
		}
	}
}
