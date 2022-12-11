package com.example.my_quizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NumberQuestion extends AppCompatActivity implements View.OnClickListener{

    public static int maxQuestion = 0;
    private Button Button5Q;
    private Button Button10Q;
    private Button Button20Q;
    private Button ButtonAllQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_question);
        Button5Q = findViewById(R.id.button5Q);
        Button10Q = findViewById(R.id.button10Q);
        Button20Q = findViewById(R.id.button20Q);
        ButtonAllQ = findViewById(R.id.buttonAllQ);
        Button5Q.setOnClickListener(this);
        Button10Q.setOnClickListener(this);
        Button20Q.setOnClickListener(this);
        ButtonAllQ.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {        // The user just clicked
        Button clickedButton = (Button) view;
        switch(clickedButton.getId()) {
            case R.id.button5Q:
                maxQuestion = 5;
                break;
            case R.id.button10Q:
                maxQuestion = 10;
                break;
            case R.id.button20Q:
                maxQuestion = 20;
                break;
            case R.id.buttonAllQ:
                maxQuestion = ChooseCountry.CountryAnswer.size();
                break;}
        Intent gameActivityIntent = new Intent(NumberQuestion.this, GameActivity.class);
        startActivity(gameActivityIntent);
    }
}
