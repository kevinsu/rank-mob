package com.rankmob.service.api;

public class RegisterContext {
    String email;
    String username;
    String password;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return email + " : " + username + " : " + password;
    }
}
