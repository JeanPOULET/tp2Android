package com.android.tp2_quizz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Gestion extends AppCompatActivity {


    private RecyclerView vueQuizz;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Quizz quizz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);
        quizz = new Quizz();
        layoutManager = new LinearLayoutManager(this);
        vueQuizz.setLayoutManager(layoutManager);
        adapter = new MyAdapter(this, quizz.getQuestions());
        vueQuizz.setAdapter(adapter);
    }
}
