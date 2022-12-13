package com.example.my_quizz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChooseCountry extends AppCompatActivity implements View.OnClickListener{

    public static Map<Integer, String[][]> CountryAnswer = new HashMap<Integer, String[][]>();
    private Button ButtonAmerique;
    private Button ButtonEurope;
    private Button ButtonAfrique;
    private Button ButtonAll;
    private MediaPlayer musicplayer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_country);
        String url = "http://docs.google.com/uc?export=open&id=13fTNUaMd7FhYJxh8eZPdW06OdIgSb_xu";
        this.musicplayer = new MediaPlayer();
        try {
            musicplayer.setDataSource(url);
            musicplayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(MainActivity.stateButton == 0)
            Music.musicValue=1;
        else if (MainActivity.stateButton == 1)
            Music.musicValue=0;
        Music.playSound(musicplayer);
        ButtonEurope = findViewById(R.id.buttonEurope);
        ButtonAmerique = findViewById(R.id.buttonAmerique);
        ButtonAfrique = findViewById(R.id.buttonAfrique);
        ButtonAll = findViewById(R.id.buttonAll);
        ButtonEurope.setOnClickListener(this);
        ButtonAmerique.setOnClickListener(this);
        ButtonAfrique.setOnClickListener(this);
        ButtonAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {        // The user just clicked
        Button clickedButton = (Button) view;
        switch(clickedButton.getId()) {
            case R.id.buttonEurope:
                CountryAnswer = QuestionAnswer.EuropeAnswer;
                break;
            case R.id.buttonAmerique:
                CountryAnswer = QuestionAnswer.AmeriqueAnswer;
                break;
            case R.id.buttonAfrique:
                CountryAnswer = QuestionAnswer.AfriqueAnswer;
                break;
            case R.id.buttonAll:
                CountryAnswer = QuestionAnswer.AllAnswer;
                break;
        }
        Music.musicValue=1;
        Music.playSound(musicplayer);
        Intent numberQuestionIntent = new Intent(ChooseCountry.this, NumberQuestion.class);
        startActivity(numberQuestionIntent);
    }
}
