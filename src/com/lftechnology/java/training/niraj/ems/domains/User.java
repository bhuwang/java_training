package com.lftechnology.java.training.niraj.ems.domains;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.lftechnology.java.training.niraj.ems.enums.Status;

public class User extends Pojo {
    private static final String TABLE = "users";
    protected String username = null;
    protected String password = null;
    protected String isTerminated = null;
    protected String status = null;

    protected List<String> attributeList;

    public User() {
        super();
        super.setTable(TABLE);
        super.setPrimaryKey("id");
        setAttributeList();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsTerminated() {
        return isTerminated;
    }

    public void setIsTerminated(Status isTerminated) {
        this.isTerminated = isTerminated.getStatus();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status.getStatus();
    }

    public List<String> getAttributeList() {
        return attributeList;
    }

    private void setAttributeList() {
        this.attributeList = new ArrayList<String>();
        this.attributeList.add("id");
        this.attributeList.add("username");
        this.attributeList.add("password");
        this.attributeList.add("isTerminated");
        this.attributeList.add("status");
    }

    @Override
    public List<String> getAttributes() {
        return getAttributeList();
    }

    @Override
    public Map<String, String> getInfo() {
        Map<String, String> userInfo = new LinkedHashMap<String, String>();
        userInfo.put("id", getId());
        userInfo.put("username", getUsername());
        userInfo.put("password", getPassword());
        userInfo.put("status", getStatus());
        userInfo.put("isTerminated", getIsTerminated());

        return userInfo;
    }
}
