package com.univ.linco.mypage.database;

import android.content.Context;

import androidx.room.Room;

public class FilterClient {
    private Context mCtx;
    private static FilterClient mInstance;

    //our app database object
    private AppDatabaseFilter appDatabaseFilter;

    private FilterClient(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        //db-post is the name of the database
        appDatabaseFilter = Room.databaseBuilder(mCtx, AppDatabaseFilter.class, "filter_db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        //데이터베이스에 아무것도 없다면 더미데이터 추가
        if(appDatabaseFilter.filterDao().getAll().size() == 0){
            Filter filter = new Filter(true,true,true,true,true,true,true,true, true);
            appDatabaseFilter.filterDao().insert(filter);
        }
    }

    public static synchronized FilterClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new FilterClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabaseFilter getAppDatabase() {
        return appDatabaseFilter;
    }
}
