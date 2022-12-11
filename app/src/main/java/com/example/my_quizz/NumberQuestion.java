package com.example.my_quizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NumberQuestion extends AppCompatActivity implements View.OnClickListener{

    public static long time = 0;
    public static int maxQuestion = 0;
    private Button Button25Q;
    private Button Button50Q;
    private Button Button75Q;
    private Button ButtonAllQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_question);
        Button25Q = findViewById(R.id.button25Q);
        Button50Q = findViewById(R.id.button50Q);
        Button75Q = findViewById(R.id.button75Q);
        ButtonAllQ = findViewById(R.id.buttonAllQ);
        Button25Q.setOnClickListener(this);
        Button50Q.setOnClickListener(this);
        Button75Q.setOnClickListener(this);
        ButtonAllQ.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {        // The user just clicked
        Button clickedButton = (Button) view;
        switch(clickedButton.getId()) {
            case R.id.button25Q:
                maxQuestion = ChooseCountry.CountryAnswer.size()/4;
                break;
            case R.id.button50Q:
                maxQuestion = ChooseCountry.CountryAnswer.size()/2;
                break;
            case R.id.button75Q:
                maxQuestion = (ChooseCountry.CountryAnswer.size()/4)*3;
                break;
            case R.id.buttonAllQ:
                maxQuestion = ChooseCountry.CountryAnswer.size();
                break;}
        time = maxQuestion * 5000;
        Intent gameActivityIntent = new Intent(NumberQuestion.this, GameActivity.class);
        startActivity(gameActivityIntent);
    }
}