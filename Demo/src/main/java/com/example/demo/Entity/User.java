package com.example.demo.Entity;

import com.example.demo.Util.BaseParam;

public class User extends BaseParam {
    private int user_id;
    private String user_name;
    private String user_pwd;
    private String user_telphone;
    private int user_role;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_telphone() {
        return user_telphone;
    }

    public void setUser_telphone(String user_telphone) {
        this.user_telphone = user_telphone;
    }

    public int getUser_role() {
        return user_role;
    }

    public void setUser_role(int user_role) {
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_telphone='" + user_telphone + '\'' +
                ", user_role=" + user_role +
                '}';
    }
}