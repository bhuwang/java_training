
package com.lftechnology.java.training.dipak.employeemanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.api.EmployeeApi;
import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * <p>This class implements the EmployeeApi and has definition to all the
 * overwritten methods.</p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class EmployeeDao implements EmployeeApi {

	private static final Logger LOGGER =
		Logger.getLogger(EmployeeDao.class.getName());

	/**
	 * <p>This method is used to add a row in database. The data is obtained
	 * from the Employee object. This method returns the number of rows affected
	 * in the database</p>
	 * 
	 * @param e
	 * @return count
	 */
	@Override
	public int addEmployee(Employee e) {

		Connection con = DbConnection.setConnection();
		int count = 0;
		if (con == null) {
			LOGGER.info("Connection Setup Failed");
			return count;
		}
		PreparedStatement pst = null;
		String sql =
			"insert into employee (username,password,isTerminated,fullname,department,address,role) values(?,?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);

			pst.setString(1, e.getUserName());
			pst.setString(2, e.getPassword());
			pst.setBoolean(3, e.getIsTerminated());
			pst.setString(4, e.getFullName());
			pst.setString(5, e.getDepartment());
			pst.setString(6, e.getAddress());
			pst.setString(7, e.getRole().toString());

			System.out.println(pst);

			count = pst.executeUpdate();

		}
		catch (MySQLIntegrityConstraintViolationException e1) {
			LOGGER.severe(
				"User name already exits. Please enter another username.");
		}
		catch (SQLException sq) {
			LOGGER.log(Level.SEVERE, "Exception::{0}", sq);
		}

		return count;
	}

	/**
	 * <p>This method is used to view records present in database. The filters
	 * are used for filtering the records. It return the result set.</p>
	 * 
	 * @param e
	 * @return rs
	 */
	@Override
	public ResultSet viewEmployee(Employee e) {

		ResultSet rs = null;
		StringBuilder sql = null;
		Connection con = DbConnection.setConnection();
		if (con == null) {
			LOGGER.info("Connection Setup Failed");
			return rs;
		}
		PreparedStatement pst = null;

		sql = new StringBuilder("select * from employee where 1=1 ");
		if (!e.getFullName().equals("")) {
			sql.append("and fullname='");
			sql.append(e.getFullName());
			sql.append("'");
		}
		if (!e.getAddress().equals("")) {
			sql.append(" and address='");
			sql.append(e.getAddress());
			sql.append("'");
		}
		if (!e.getDepartment().equals("")) {
			sql.append(" and department='");
			sql.append(e.getDepartment());
			sql.append("'");
		}

		try {
			pst = con.prepareStatement(sql.toString());
			rs = pst.executeQuery();

		}
		catch (SQLException e1) {
			LOGGER.log(Level.SEVERE, "Exception::{0}", e1);
		}

		// sql="select * from employee where fullname=? and department=? and
		// address=?";
		//
		// try {
		// pst=con.prepareStatement(sql);
		// if(!e.getFullName().equals("")) {
		// pst.setString(1, e.getFullName());
		// }else {
		// pst.setString(1, "?");
		// }
		// if(!e.getAddress().equals("")) {
		// pst.setString(3, e.getAddress());
		// }else {
		// pst.setString(3, "?");
		// }
		// if(!e.getDepartment().equals("")) {
		// pst.setString(2, e.getDepartment());
		// }else {
		// pst.setString(2, "?");
		// }
		//
		// System.out.println(pst);
		//
		// rs=pst.executeQuery();
		//
		// }catch(SQLException sq) {
		// LOGGER.log(Level.SEVERE,"Exception::{0}",sq);
		// }

		return rs;
	}

	// @Override
	// public int deleteEmployee(Employee e) {
	// Connection con=DbConnection.setConnection();
	// int count=0;
	// if(con==null) {
	// LOGGER.info("Connection Setup Failed");
	// return count;
	// }
	// PreparedStatement pst = null;
	// String sql="delete from employee where username=?";
	// try {
	// pst=con.prepareStatement(sql);
	//
	// pst.setString(1, e.getFullName());
	//
	// count=pst.executeUpdate();
	// }catch(SQLException sq) {
	// LOGGER.log(Level.INFO,"Exception::{0}",sq);
	// }
	//
	// return count;
	// }

	/**
	 * <p>This method terminates the employee present in the database based on
	 * the fullname. This method returns the number of employees terminated.</p>
	 * 
	 * @param e
	 * @return count
	 */
	@Override
	public int terminateEmployee(Employee e) {

		Connection con = DbConnection.setConnection();
		int count = 0;
		if (con == null) {
			LOGGER.info("Connection Setup Failed");
			return count;
		}
		PreparedStatement pst = null;
		String sql = "update employee set isTerminated=true where username=? ";
		try {
			pst = con.prepareStatement(sql);

			pst.setString(1, e.getFullName());

			count = pst.executeUpdate();

		}
		catch (SQLException sq) {
			LOGGER.log(Level.SEVERE, "Exception::{0}", sq);
		}

		return count;
	}

	/**
	 * <p>This method edits the data of the current user in the database and
	 * returns the number of rows affected.</p>
	 * 
	 * @param e
	 * @return e
	 */
	@Override
	public Employee editEmployeeDetails(Employee e) {

		Connection con = DbConnection.setConnection();
		int count = 0;
		if (con == null) {
			LOGGER.info("Connection Setup Failed");
			return e;
		}
		PreparedStatement pst = null;
		String sql =
			"update employee set username=?,password=?,fullname=?,department=?,address=? where isTerminated=false and eid=?";
		try {
			pst = con.prepareStatement(sql);

			pst.setString(1, e.getUserName());
			pst.setString(2, e.getPassword());
			pst.setString(3, e.getFullName());
			pst.setString(4, e.getDepartment());
			pst.setString(5, e.getAddress());
			pst.setInt(6, e.getId());

			count = pst.executeUpdate();

			if (count == 0) {
				LOGGER.info("The entered data was not updated. Please re-try.");
			}
			else {
				LOGGER.info("Edit complete..");
			}
		}
		catch (SQLException sq) {
			LOGGER.log(Level.SEVERE, "Exception: {0}", sq);
		}
		return e;
	}

}
