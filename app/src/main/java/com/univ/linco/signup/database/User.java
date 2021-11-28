package com.univ.linco.signup.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.univ.linco.mypage.database.Filter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String user_id;
    private String user_password;
    private String keyword;

    public User(String name, String user_id, String user_password, String keyword) {
        this.name = name;
        this.user_id = user_id;
        this.user_password = user_password;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_password='" + user_password + '\'' +
                ", keyword=" + keyword +
                '}';
    }
}

