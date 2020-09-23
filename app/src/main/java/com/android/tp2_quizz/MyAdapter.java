package com.android.tp2_quizz;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> values;
    Context ctx;

    public MyAdapter(Context context, List<String> myDataset) {
        values = myDataset;
        ctx = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView texte;

        public ViewHolder(View v) {
            super(v);
            texte = (TextView) v.findViewById(R.id.affichage);
        }
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}