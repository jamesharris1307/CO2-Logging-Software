package com.example.envlog.model;

public class UserInfo {

    private String name;
    private String username;
    private String password;

    // Constructor
    public UserInfo(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // Get (Name)
    public String getName() {
        return name;
    }
    // Get (Username)
    public String getUsername() {
        return username;
    }
    // Get (Password)
    public String getPassword() {
        return password;
    }

}
