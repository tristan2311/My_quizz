package com.example.my_quizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class ChooseCountry extends AppCompatActivity implements View.OnClickListener{

    public static Map<Integer, String[][]> CountryAnswer = new HashMap<Integer, String[][]>();
    Button ButtonAmerique;
    Button ButtonEurope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_country);
        ButtonEurope = findViewById(R.id.buttonEurope);
        ButtonAmerique = findViewById(R.id.buttonAmerique);
        ButtonEurope.setOnClickListener(this);
        ButtonAmerique.setOnClickListener(this);

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
                break;}
        Intent numberQuestionIntent = new Intent(ChooseCountry.this, NumberQuestion.class);
        startActivity(numberQuestionIntent);
    }
}
