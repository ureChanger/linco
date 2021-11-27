package com.univ.linco.posting.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.univ.linco.R;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@Database(entities = {Post.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PostDao postDao();
}
