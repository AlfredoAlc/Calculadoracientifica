package com.example.aar92_22.calculadoracientifica.History;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aar92_22.calculadoracientifica.R;


public class HistoryFragment extends Fragment {

    private HistoryAdapter mAdapter;

    public HistoryFragment(HistoryAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history, container, false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);

        RecyclerView historyRv = view.findViewById(R.id.history_rv);
        historyRv.setLayoutManager(linearLayoutManager);
        historyRv.setAdapter(mAdapter);

        return view;
    }


}
