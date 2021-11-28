package com.univ.linco.signup.database;

import android.content.Context;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserClient {
    private Context mCtx;
    private static UserClient mInstance;

    //our app database object
    private AppDatabaseUser appDatabaseUser;

    private UserClient(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        //db-post is the name of the database
        appDatabaseUser = Room.databaseBuilder(mCtx, AppDatabaseUser.class, "user_db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        //데이터베이스에 아무것도 없다면 더미데이터 추가
        if(appDatabaseUser.userDao().getAll().size() == 0){
            User user = new User("admin", "admin", "admin", "");
            appDatabaseUser.userDao().insert(user);
        }
    }

    public static synchronized UserClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new UserClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabaseUser getAppDatabase() {
        return appDatabaseUser;
    }
}
