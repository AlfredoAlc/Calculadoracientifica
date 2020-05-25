package com.example.aar92_22.calculadoracientifica.History;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NumberDao {

    @Insert
    void insert(NumberEntry numberEntry);

    @Query("SELECT * FROM calculator ORDER BY dateAdded")
    LiveData<List<NumberEntry>> loadAllNumbers();

    @Query("SELECT * FROM calculator WHERE id = :id")
    NumberEntry getNumberById(int id);

    @Query("SELECT * FROM calculator ORDER BY dateAdded DESC")
    List<NumberEntry> loadNumbersForDelete();

    @Delete
    void deleteNumber(NumberEntry numberEntry);

}
