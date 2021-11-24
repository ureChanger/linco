package com.univ.linco.signup;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Todo {
    @PrimaryKey(autoGenerate = true)
    private String name;
    private String id;
    private String password;
    private String passwordcheck;
    private String keyword;

    public Todo(String name, String id, String password, String passwordcheck, String keyword) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.passwordcheck = passwordcheck;
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", passwordcheck='" + passwordcheck + '\'' +
                '}';
    }

    public String getID(String s) {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPassword(String s) {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
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

    public int getPassword() {
        return 0;
    }

    public int getID() {
        return 0;
    }
}

