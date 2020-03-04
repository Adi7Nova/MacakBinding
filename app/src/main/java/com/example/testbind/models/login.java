package com.example.testbind.models;

public class login {
    private String user;
    private String passwd;

    public login(String user,String passwd){
    this.setUser(user);
    this.setPasswd(passwd);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
