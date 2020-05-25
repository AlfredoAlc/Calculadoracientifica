package com.example.aar92_22.calculadoracientifica.History;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "calculator")
public class NumberEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String value;
    @ColumnInfo(name = "dateAdded")
    private Date dateAdded;


    @Ignore
    public NumberEntry(String value, Date dateAdded) {
        this.value = value;
        this.dateAdded = dateAdded;
    }

    public NumberEntry(int id, String value, Date dateAdded) {
        this.id = id;
        this.value = value;
        this.dateAdded = dateAdded;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Date getDateAdded() {
        return dateAdded;
    }
}
