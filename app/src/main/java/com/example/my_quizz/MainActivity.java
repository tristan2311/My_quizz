package com.example.my_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String name; //Nom du joueur
    public static int stateButton = 1;
    private EditText mNameEditText;
    private Button mStartButton;
    private Button musicButton;
    private ImageView musicView;
    private MediaPlayer musicplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://docs.google.com/uc?export=open&id=1MEoxdE7tf_RDUcRNZnpViQ2-eaIatfeB"; //Url pour accéder à la musique
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
        stateButton = Music.musicValue;
        QuestionAnswer.createHashmap(); //Lance la fonction qui permet de créer les différentes Hashmap
        mNameEditText = findViewById(R.id.main_challenger_name);
        mStartButton = findViewById(R.id.main_start_button);
        musicButton = findViewById(R.id.music_button);
        musicView = findViewById(R.id.imageView);
        mStartButton.setEnabled(false); //permet de désactiver le bouton
        musicButton.setOnClickListener(this);
        mStartButton.setOnClickListener(this);


        //Permet de choisir la reaction de l'EditText en fonction du moment ou le texte est saisi ou non par le joueur
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charsequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charsequence, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mStartButton.setEnabled(!editable.toString().isEmpty()); //active le bouton start
            }
        });
    }

    @Override
    public void onClick(View view) {        // Le joueur a cliqué
        Button clickedButton = (Button) view;
        switch (clickedButton.getId()) {
            case R.id.main_start_button: {
                name = mNameEditText.getText().toString();
                Intent ChooseCountryIntent = new Intent(MainActivity.this, ChooseCountry.class); //Accède à la classe ChooseCountry
                startActivity(ChooseCountryIntent);
                Music.musicValue = 1;
                Music.playSound(musicplayer);
            }
            break;

            case R.id.music_button:
                if (Music.musicValue == 1){
                    //Change la couleur du bouton pour indiquer que la musique est coupé
                    musicView.setBackgroundColor(Color.parseColor("#33FF0000"));
                }
                else if (Music.musicValue == 0){
                    //Change la couleur du bouton pour indiquer que la musique n'est pas coupé
                    musicView.setBackgroundColor(Color.parseColor("#3390EE90"));}
                Music.playSound(musicplayer);
                stateButton = Music.musicValue;
                break;
        }
    }
}