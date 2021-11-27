package com.univ.linco.posting.database;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;

public class PostClient {
    private Context mCtx;
    private static PostClient mInstance;

    //our app database object
    private AppDatabase appDatabase;

    private PostClient(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        //db-post is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, "post_database").allowMainThreadQueries().build();

        //데이터베이스에 아무것도 없다면 더미데이터 추가
        if(appDatabase.postDao().getAll().size() == 0){
            PostDummyData postDummyData = new PostDummyData();
            ArrayList<Post> dummyData = postDummyData.getPostDummyData();

            for (int i=0; i<dummyData.size(); i++){
                appDatabase.postDao().insert(dummyData.get(i));
            }
        }
    }

    public static synchronized PostClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new PostClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
