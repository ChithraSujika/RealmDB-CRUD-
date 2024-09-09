package com.example.myapplication.RealmClasses;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UsersRealm extends RealmObject {
    @PrimaryKey
    private String userUUID = UUID.randomUUID().toString();
    private String userName;
    private String userMobileNumber;
    private String userEmailId;


    public UsersRealm() {
    }

    public UsersRealm(String userName, String userMobileNumber, String userEmailId) {
        this.userName = userName;
        this.userMobileNumber = userMobileNumber;
        this.userEmailId = userEmailId;

    }



    public String getUserUUID() {
        return userUUID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }
}
