package com.android.tp2_quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView affichage;


    private List<String> questions = new ArrayList<>();
    String correct = "Correct!";
    String inCorrect = "Incorrect!";
    Quizz quizz;
    private boolean reponseLu = false;
    int index = 0;
    int nbJustes = 0;
    private static final int CODE_SECOND = 1;
    private static final int CODE_GESTION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quizz = new Quizz();
        setContentView(R.layout.activity_main);
        affichage = findViewById(R.id.affichage);
        affichage.setText(quizz.getQuestions().get(0));
    }

    public void nextQuestion(View v) {
        reponseLu = false;
        if (index != quizz.size() - 1) {
            index++;
            affichage.setText(quizz.getQuestions().get(index));
        } else {
            affichage.setText(String.format(Locale.FRANCE, "Votre score : %d/%d", nbJustes, quizz.size()));
        }

    }

    public void isTrue(View v) {
        if (reponseLu) {
            Toast.makeText(this, "Vous avez vu la réponse !", Toast.LENGTH_LONG).show();
            return;
        }

        if (quizz.getReponses().get(index)) {
            Toast.makeText(this, correct, Toast.LENGTH_SHORT).show();
            nbJustes++;
        } else {
            Toast.makeText(this, inCorrect, Toast.LENGTH_SHORT).show();
        }
        nextQuestion(v);
    }

    public void isFalse(View v) {
        if (reponseLu) {
            Toast.makeText(this, "Vous avez vu la réponse !", Toast.LENGTH_LONG).show();
            return;
        }

        if (!quizz.getReponses().get(index)) {
            Toast.makeText(this, correct, Toast.LENGTH_SHORT).show();
            nbJustes++;
        } else {
            Toast.makeText(this, inCorrect, Toast.LENGTH_SHORT).show();
        }
        nextQuestion(v);
    }

    public void voirReponse(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("Value", quizz.getReponses().get(index));
        startActivityForResult(intent, CODE_SECOND);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        reponseLu = true;
    }

    public void gestion(View v){
        Intent intent = new Intent(MainActivity.this, Gestion.class);
        startActivityForResult(intent, CODE_GESTION);
    }

}