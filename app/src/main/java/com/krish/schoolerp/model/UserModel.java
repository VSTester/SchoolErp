package com.krish.schoolerp.model;

public class UserModel {

    private String userName;
    private String schoolName;
    private String address;
    private String State;
    private String city;
    private String phone;

    private  String password;

    private String role;

    public UserModel(String userName, String schoolName, String address, String state, String city, String phone, String emilId,String password, String className, String role) {
        this.userName = userName;
        this.schoolName = schoolName;
        this.address = address;
        this.State = state;
        this.city = city;
        this.phone = phone;
        this.emilId = emilId;
        this.className = className;
        this.role = role;
        this.password = password;
    }

    private String emilId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmilId() {
        return emilId;
    }

    public void setEmilId(String emilId) {
        this.emilId = emilId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    private String className;

    public UserModel() {
    }
}
