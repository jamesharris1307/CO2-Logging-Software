package com.example.envlog.model;

public class UserInfo {
    private String userId;
    private String name;
    private String username;
    private String password;

    public UserInfo(String userId, String name, String username, String password) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getUserId() {return userId;}

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return userId + "," + name + "," + username + "," + password;
    }
}


