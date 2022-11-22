package com.example.my_quizz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GameActivity extends AppCompatActivity{

    Button mAnswer1Button;
    Button mAnswer2Button;
    Button mAnswer3Button;
    Button mAnswer4Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        mAnswer1Button = findViewById((R.id.in_game_activity_button_1));
        mAnswer2Button = findViewById((R.id.in_game_activity_button_2));
        mAnswer3Button = findViewById((R.id.in_game_activity_button_3));
        mAnswer4Button = findViewById((R.id.in_game_activity_button_4));

    }
}
