package com.univ.linco.mypage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.univ.linco.posting.database.Post;
import com.univ.linco.posting.database.PostDao;

@Database(entities = {Filter.class}, version = 1)
public abstract class MypageDatabase extends RoomDatabase {
    public abstract MypageDao mypageDao();
}
