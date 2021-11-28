package com.univ.linco.signup.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema=false)
public abstract class AppDatabaseUser extends RoomDatabase {
    public  abstract UserDao userDao();
}
