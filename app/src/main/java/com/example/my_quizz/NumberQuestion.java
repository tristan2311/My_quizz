package com.example.my_quizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NumberQuestion extends AppCompatActivity implements View.OnClickListener{

    public static long time = 0;
    public static int maxQuestion = 0;
    public static String urlMusique = "";
    private Button Button25Q;
    private Button Button50Q;
    private Button Button75Q;
    private Button ButtonAllQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_question);
        Music.createMediaPlayer("http://docs.google.com/uc?export=open&id=1jbOLx63r3qgWcRM-pITJXmBfY19a_4yy");
        if(MainActivity.stateButton == 0)
            Music.musicValue=1;
        else if (MainActivity.stateButton == 1)
            Music.musicValue=0;
        Music.playSound();
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
                urlMusique = "";
                break;
            case R.id.button50Q:
                maxQuestion = ChooseCountry.CountryAnswer.size()/2;
                urlMusique = "";
                break;
            case R.id.button75Q:
                maxQuestion = (ChooseCountry.CountryAnswer.size()/4)*3;
                urlMusique = "";
                break;
            case R.id.buttonAllQ:
                maxQuestion = ChooseCountry.CountryAnswer.size();
                urlMusique = "";
                break;}
        time = maxQuestion * 5000;
        Music.musicValue=1;
        Music.playSound();
        Intent gameActivityIntent = new Intent(NumberQuestion.this, GameActivity.class);
        startActivity(gameActivityIntent);
    }
}