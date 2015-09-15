
package com.lftechnology.java.training.dipak.employeemanagement.domain;

/**
 * <p>
 * This class defines attributes that are necessary for the login condition.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class User {

    private int id;
    private String userName;
    private String password;
    private boolean isTerminated;

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public boolean getIsTerminated() {

        return isTerminated;
    }

    public void setIsTerminated(boolean isTerminated) {

        this.isTerminated = isTerminated;
    }

}
