package com.example.aar92_22.calculadoracientifica.History;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aar92_22.calculadoracientifica.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {


    private Context mContext;
    private List<NumberEntry> numberEntries;
    final private NumberClickListener numberClickListener;


    public HistoryAdapter(Context mContext, NumberClickListener numberClickListener){
        this.mContext = mContext;
        this.numberClickListener = numberClickListener;
    }

    public void setNumberEntries( List<NumberEntry> numberEntries){
        this.numberEntries = numberEntries;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.item_view, parent, false);

        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        NumberEntry number = numberEntries.get(position);
        holder.item.setText(number.getValue());

    }

    @Override
    public int getItemCount() {
        if(numberEntries == null){
            return 0;
        } else {
            return numberEntries.size();
        }
    }

    public interface NumberClickListener{
        void NumberSelected(int id);
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView item;

        HistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            item = itemView.findViewById(R.id.item_text_view);

            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = numberEntries.get(getAdapterPosition()).getId();
            String value = numberEntries.get(getAdapterPosition()).getValue();
            if(value.matches(".*\\d.*")) {
                numberClickListener.NumberSelected(id);
            }
        }
    }
}
