package com.example.aar92_22.calculadoracientifica.History;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutor {

    private static final Object LOCK = new Object();
    private static AppExecutor sInstance;
    private final Executor mainIO;

    private AppExecutor(Executor mainIO){
        this.mainIO = mainIO;
    }

    public static AppExecutor getInstance(){
        if(sInstance == null){
            synchronized (LOCK){
                sInstance = new AppExecutor(Executors.newSingleThreadExecutor());
            }
        }
        return sInstance;
    }

    public Executor mainIO(){
        return mainIO;
    }

}
