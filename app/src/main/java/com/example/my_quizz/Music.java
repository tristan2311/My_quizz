package com.example.my_quizz;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Music {

    public static int musicValue = 0;

    //Permet la gestion de la musique
    public static void playSound(MediaPlayer musicplayer) {
        if(musicValue == 1)
        {   musicplayer.pause(); //met en pause la musique
            musicValue = 0; }
        else if(musicValue==0)
        {   musicplayer.start(); //Lance la musique
            musicplayer.setLooping(true); //Fait se répéter la musique à l'infinie
            musicValue = 1;}
    }

}
