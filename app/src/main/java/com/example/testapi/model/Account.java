package com.example.testapi.model;
import com.google.gson.annotations.SerializedName;
public class Account {
    @SerializedName("Login")
     String login;
    @SerializedName("Password")
     String password;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
