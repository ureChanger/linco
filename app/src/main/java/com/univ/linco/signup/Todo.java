package com.univ.linco.signup;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Todo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String user_id;
    private String user_password;
    private String passwordcheck;
    private String keyword;

    public Todo(String name, String user_id, String user_password, String passwordcheck, String keyword) {
        this.name = name;
        this.user_id = user_id;
        this.user_password = user_password;
        this.passwordcheck = passwordcheck;
        this.keyword = keyword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setPassword(String user_password) {
        this.user_password = user_password;
    }

    public String getPasswordcheck() {
        return passwordcheck;
    }

    public void setPasswordcheck(String passwordcheck) {
        this.passwordcheck = passwordcheck;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}

