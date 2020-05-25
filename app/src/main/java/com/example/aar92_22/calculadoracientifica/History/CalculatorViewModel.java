package com.example.aar92_22.calculadoracientifica.History;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CalculatorViewModel extends AndroidViewModel {

    private LiveData<List<NumberEntry>> number;


    public CalculatorViewModel(@NonNull Application application) {
        super(application);
        CalculatorDataBase calculatorDataBase = CalculatorDataBase.getsInstance(application);
        number = calculatorDataBase.numberDao().loadAllNumbers();
    }

    public LiveData<List<NumberEntry>> getNumber(){
        return number;
    }
}
