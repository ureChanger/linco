package com.univ.linco.mypage;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MypageDao {
    @Query("SELECT * FROM Filter")
    List<Filter> getAll();

    @Insert
    void insert(Filter filter);

    @Update
    void updatePost(Filter filter);

    @Delete
    void deletePost(Filter filter);

}
