package com.android.tp2_quizz;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        vueQuizz = (RecyclerView) findViewById(R.id.vue_questions);


        layoutManager = new LinearLayoutManager(this);
        vueQuizz.setLayoutManager(layoutManager);


        adapter = new MyAdapter(this, quizz.getQuestions(), quizz.getReponses());
        vueQuizz.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallBack =
                new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source,
                                          RecyclerView.ViewHolder target) {
                        if (source.getItemViewType() != target.getItemViewType()) {
                            return false;
                        }
                        moveQuestion(source.getAdapterPosition(), target.getAdapterPosition());
                        return true;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        quizz.remove(viewHolder.getAdapterPosition());
                        if (adapter.hasObservers())
                            adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallBack);
        itemTouchHelper.attachToRecyclerView(vueQuizz);
    }

    public void moveQuestion(int indexSource, int indexCible) {
        String qs = quizz.getQuestions().get(indexSource);
        Boolean re = quizz.getReponses().get(indexSource);
        quizz.remove(indexSource);
        quizz.addQuestion(indexCible, qs);
        quizz.addReponse(indexCible, re.toString());
        if (adapter.hasObservers()) adapter.notifyItemMoved(indexSource, indexCible);
    }

    public void addQuestion(View v) {
        final EditText question = findViewById(R.id.editTextQuestion);
        quizz.addQuestion(question.getText().toString());
        addReponse(v);

    }

    public void addReponse(View v) {
        final EditText reponse = findViewById(R.id.editTextReponse);
        quizz.addReponse(reponse.getText().toString());
        if (adapter.hasObservers()) adapter.notifyItemInserted(quizz.size()) ;
    }


}

