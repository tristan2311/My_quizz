package com.example.my_quizz;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Music extends AppCompatActivity {

    private MediaPlayer musicplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        String url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
        this.musicplayer = new MediaPlayer();
        try {
            musicplayer.setDataSource(url);
            musicplayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playSound(View view) {
        if(musicplayer.isPlaying())
        {musicplayer.pause();}
        else {musicplayer.start();}
    }

}