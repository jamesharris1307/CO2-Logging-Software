package com.example.envlog.model;

public class UserInfo {
    private String name;
    private String username;
    private String password;

    public UserInfo(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

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
        return  name + "," + username+"," + password;
    }
}


