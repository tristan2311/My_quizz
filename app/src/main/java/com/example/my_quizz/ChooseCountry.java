package com.example.my_quizz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class ChooseCountry extends AppCompatActivity implements View.OnClickListener{

    public static Map<Integer, String[][]> CountryAnswer = new HashMap<Integer, String[][]>();
    private Button ButtonAmerique;
    private Button ButtonEurope;
    private Button ButtonAfrique;
    private Button ButtonAll;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_country);
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
        Intent numberQuestionIntent = new Intent(ChooseCountry.this, NumberQuestion.class);
        startActivity(numberQuestionIntent);
    }
}
