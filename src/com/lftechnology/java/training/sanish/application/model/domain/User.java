package com.lftechnology.java.training.sanish.application.model.domain;

import com.lftechnology.java.training.sanish.application.component.Constants;
import com.lftechnology.java.training.sanish.application.model.Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User model
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class User implements Model<User> {
    private static final Logger LOGGER = Logger.getLogger(User.class.getName());
    private int userId;
    private String userName;
    private String password;
    private String email;
    private boolean isTerminated;
    private String createdAt;
    private String modifiedAt;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsTerminated(boolean isTerminated) {
        this.isTerminated = isTerminated;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public int getUserId() {
        return userId;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    @Override public String getTable() {
        return "users";
    }

    @Override public <V> V getAttribute(String key) {
        try {
            return (V) User.class.getDeclaredField(key).get(this);
        } catch (NoSuchFieldException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", e);
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", e);
        }
        return null;
    }

    @Override public <V> void setAttribute(String key, V value) {
        try {
            User.class.getDeclaredField(key).set(this, value);
        } catch (NoSuchFieldException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", e);
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", e);
        }
    }

    @Override public boolean equals(User userModel) {
        if (userModel == null || getClass() != userModel.getClass()) {
            return false;
        } else if (this == userModel) {
            return true;
        } else {
            if (userId == userModel.userId || userName == userModel.userName) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override public void setResultSetAttributes(ResultSet rs) {
        String[] colWithStringDataType = { "userName", "password", "email", "createdAt", "modifiedAt" };
        String[] colWithIntDataType = { "userId" };
        String[] colWithBooleanDataType = { "isTerminated" };
        try {
            ResultSetMetaData metadata = rs.getMetaData();
            int colCount = metadata.getColumnCount();
            String column;
            for (int i = 1; i <= colCount; i++) {
                column = metadata.getColumnName(i);
                if (Arrays.asList(colWithStringDataType).contains(column)) {
                    setAttribute(column, rs.getString(i));
                } else if (Arrays.asList(colWithIntDataType).contains(column)) {
                    setAttribute(column, rs.getInt(i));
                } else if (Arrays.asList(colWithBooleanDataType).contains(column)) {
                    setAttribute(column, rs.getBoolean(i));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", e);
        }
    }

    @Override public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isTerminated=" + isTerminated +
                ", createdAt='" + createdAt + '\'' +
                ", modifiedAt='" + modifiedAt + '\'' +
                '}';
    }
}
