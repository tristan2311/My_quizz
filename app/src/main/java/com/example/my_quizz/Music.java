package com.example.my_quizz;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Music {

    public static int musicValue = 0;

    public static void playSound(MediaPlayer musicplayer) {
        if(musicValue == 1)
        {   musicplayer.pause();
            musicValue = 0; }
        else if(musicValue==0)
        {   musicplayer.start();
            musicplayer.setLooping(true);
            musicValue = 1;}
    }

}
