package com.android.tp2_quizz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView affichage;
    Handler myHandler;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_second);
        affichage = findViewById(R.id.textViewReponse);
        myHandler = new Handler();
    }

    public void montrerReponse(View v) {
        affichage.setText(Boolean.toString(getIntent().getBooleanExtra("Value", false)));
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 1500);

    }

    @Override
    public void finish() {
        super.finish();
    }

}
