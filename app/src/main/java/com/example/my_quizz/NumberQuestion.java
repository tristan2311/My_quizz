package com.example.my_quizz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class NumberQuestion extends AppCompatActivity implements View.OnClickListener{

    public static long time = 0;
    public static int maxQuestion = 0;
    public static String urlMusique = "";
    private Button Button25Q;
    private Button Button50Q;
    private Button Button75Q;
    private Button ButtonAllQ;
    private MediaPlayer musicplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_question);
        String url = "http://docs.google.com/uc?export=open&id=1jbOLx63r3qgWcRM-pITJXmBfY19a_4yy";
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
                urlMusique = "http://docs.google.com/uc?export=open&id=1mXtW6KsFwKrP_n40Jcibi6p2aIsFdwbO";
                break;
            case R.id.button50Q:
                maxQuestion = ChooseCountry.CountryAnswer.size()/2;
                urlMusique = "http://docs.google.com/uc?export=open&id=1MgY17JQiy041a1K8PUmva7A1JXmsz5pt";
                break;
            case R.id.button75Q:
                maxQuestion = (ChooseCountry.CountryAnswer.size()/4)*3;
                urlMusique = "http://docs.google.com/uc?export=open&id=1FfDXKmGLoNoD7ZGKcujD8yyKzQx_HaL3";
                break;
            case R.id.buttonAllQ:
                maxQuestion = ChooseCountry.CountryAnswer.size();
                urlMusique = "http://docs.google.com/uc?export=open&id=11OpkstQVs4alOVWMfir4haCnL-yOz2_7";
                break;}
        time = maxQuestion * 5000;
        Music.musicValue=1;
        Music.playSound(musicplayer);
        Intent gameActivityIntent = new Intent(NumberQuestion.this, GameActivity.class);
        startActivity(gameActivityIntent);
    }
}