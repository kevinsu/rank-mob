package com.rankmob.service.api;

public class LoginContext {
    public String username;
    public String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return username + " : " + password;
    }
}
