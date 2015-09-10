package com.lftechnology.java.training.sanish.application.model.domain;

import com.lftechnology.java.training.sanish.application.model.Model;

/**
 * User model
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class User implements Model {
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
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override public <V> void setAttribute(String key, V value) {
        try {
            User.class.getDeclaredField(key).set(this, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override public <M extends Model> boolean equals(M model) {
        if (model == null || getClass() != model.getClass()) {
            return false;
        } else if (this == model) {
            return true;
        } else {
            User user = (User) model;
            if (userId == user.userId || userName == user.userName) {
                return false;
            } else {
                return true;
            }
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
