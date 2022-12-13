package com.example.my_quizz;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Music {

    private static MediaPlayer musicplayer;
    public static int musicValue = 0;

    public static void createMediaPlayer(String url) {
    musicplayer =new MediaPlayer();
    try
    {   musicplayer.setDataSource(url);
        musicplayer.prepare();
    } catch( IOException e)
        { e.printStackTrace(); }
}

    public static void playSound() {
        if(musicValue == 1)
        {   musicplayer.pause();
            musicValue = 0; }
        else if(musicValue==0)
        {   musicplayer.start();
            musicplayer.setLooping(true);
            musicValue = 1;}
    }

}
