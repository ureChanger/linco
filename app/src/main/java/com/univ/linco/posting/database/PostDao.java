package com.univ.linco.posting.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PostDao {
    @Query("SELECT * FROM Post")
    List<Post> getAll();

    @Insert
    void insert(Post post);

    @Update
    void updatePost(Post post);

    @Delete
    void deletePost(Post post);

    @Query("DELETE FROM Post")
    void clearAll();
}
