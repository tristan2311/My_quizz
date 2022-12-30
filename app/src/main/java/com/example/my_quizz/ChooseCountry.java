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

    //Cette classe permet de choisir quel continent va affronter le joueur
    public static Map<Integer, String[][]> CountryAnswer = new HashMap<Integer, String[][]>(); //Variable qui stockera la bonne HashMap en fonction du choix que fait le joueur
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
        String url = "http://docs.google.com/uc?export=open&id=13fTNUaMd7FhYJxh8eZPdW06OdIgSb_xu"; //lien qui permet d'accéder à la musique qui est stocké sur un drive personnel
        this.musicplayer = new MediaPlayer();
        // try catch pour gérer le cas ou on ne peut pas charger la musique
        try {
            musicplayer.setDataSource(url);
            musicplayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Permet de gérer l'activation ou la coupure de la musique en fonction de la valeur d'une variable qui correspond à son état
        if(MainActivity.stateButton == 0)
            Music.musicValue=1;
        else if (MainActivity.stateButton == 1)
            Music.musicValue=0;
        Music.playSound(musicplayer);
        ButtonEurope = findViewById(R.id.buttonEurope); // associe le bouton de la classe avec le bouton du fichier xml
        ButtonAmerique = findViewById(R.id.buttonAmerique);
        ButtonAfrique = findViewById(R.id.buttonAfrique);
        ButtonAll = findViewById(R.id.buttonAll);
        ButtonEurope.setOnClickListener(this); //Rend les bouton cliquable
        ButtonAmerique.setOnClickListener(this);
        ButtonAfrique.setOnClickListener(this);
        ButtonAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {        // The user just clicked
        Button clickedButton = (Button) view;
        // switch qui permet d'éviter une série de if et qui gère la HashMap en fonction du bouton sur lequel le joueur clique
        switch(clickedButton.getId()) {
            case R.id.buttonEurope:
                CountryAnswer = QuestionAnswer.EuropeAnswer; //Permet d'associer la Hashmap de l'Europe à la variable créer plus haut pour que les questions dans la partie soit issue de cette Hashmap
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
