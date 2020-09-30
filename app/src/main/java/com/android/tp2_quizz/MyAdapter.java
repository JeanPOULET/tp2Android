package com.android.tp2_quizz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> questions;
    private List<Boolean> reponses;
    Context ctx;

    public MyAdapter(Context context, List<String> qs, List<Boolean> rs) {
        this.questions = qs;
        this.reponses = rs;
        ctx = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView question;
        public TextView reponse;

        public ViewHolder(View v) {
            super(v);
            question = v.findViewById(R.id.textViewQuestion);
            reponse = v.findViewById(R.id.textViewReponse);
        }
    }

    public MyAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_quizz, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final String name = questions.get(position);
        final String rep = reponses.get(position).toString();
        holder.question.setText(name);
        holder.reponse.setText(rep);
    }

    public int getItemCount() {
        return questions.size();
    }
}
