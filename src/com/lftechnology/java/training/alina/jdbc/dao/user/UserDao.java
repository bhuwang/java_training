package com.lftechnology.java.training.alina.jdbc.dao.user;

import com.lftechnology.java.training.alina.jdbc.api.CrudService;
import com.lftechnology.java.training.alina.jdbc.domain.User;

public interface UserDao extends CrudService<User, Integer, Boolean> {
    void searchEmployee();

    void searchEmployee(String username);
}
