package com.univ.linco.mypage.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FilterDao {
    @Query("SELECT * FROM Filter")
    List<Filter> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Filter filter);

    @Update
    void updateFilter(Filter filter);

    @Delete
    void deleteFilter(Filter filter);

}
