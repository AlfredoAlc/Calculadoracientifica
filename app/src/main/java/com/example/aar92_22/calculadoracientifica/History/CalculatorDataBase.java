package com.example.aar92_22.calculadoracientifica.History;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


@Database(entities = {NumberEntry.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class CalculatorDataBase extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "calculatorDB";
    private static CalculatorDataBase sInstance;


    public static CalculatorDataBase getsInstance(Context context){

        if(sInstance == null){
            synchronized (LOCK){
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        CalculatorDataBase.class, CalculatorDataBase.DATABASE_NAME).build();
            }
        }
        return sInstance;
    }

    public abstract NumberDao numberDao();



}
