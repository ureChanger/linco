package com.univ.linco.mypage.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.univ.linco.R;
import com.univ.linco.posting.database.Post;

@Database(entities = {Filter.class}, version = 2)
public abstract class AppDatabaseFilter extends RoomDatabase{
    public abstract FilterDao filterDao();
}