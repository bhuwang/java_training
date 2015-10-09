package com.lftechnology.java.training.alina.jdbc.dao;

import com.lftechnology.java.training.alina.jdbc.dao.employee.EmployeeDao;
import com.lftechnology.java.training.alina.jdbc.dao.employee.impl.EmployeeDaoImpl;
import com.lftechnology.java.training.alina.jdbc.dao.user.UserDao;
import com.lftechnology.java.training.alina.jdbc.dao.user.impl.UserDaoImpl;

public class DaoFactory {

    private DaoFactory() {

    }

    public static EmployeeDao getEmployeeDao() {
        return new EmployeeDaoImpl();
    }

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
