package com.krish.schoolerp;

public class User {

    public String userName;
    public String userSchoolName;
    public String userAddress;
    public String userState;
    public String userCity;
    public String userPhoneNo;
    public String userRole;
    public String userEmailId;
    public String userPassword;

    public String userClass;


    public User(String userName, String schoolName, String schoolAddress, String state,
                String city, String phoneNo, String role, String emailId, String password, String className){
     this.userName = userName;
     this.userSchoolName = schoolName;
     this.userAddress = schoolAddress;
     this.userState = state;
     this.userCity = city;
     this.userPhoneNo = phoneNo;
     this.userRole = role;
     this.userEmailId = emailId;
     this.userPassword = password;
     this.userClass = className;
    }

    public User(){

    }

}
