package com.example.my_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    EditText mNameEditText;
    Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        QuestionAnswer.createEuropeAnswer();
        QuestionAnswer.createAmeriqueAnswer();
        QuestionAnswer.createAfriqueAnswer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEditText = findViewById(R.id.main_challenger_name);
        mStartButton = findViewById(R.id.main_start_button);
        mStartButton.setEnabled(false); //permet de désactiver le bouton

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

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {        // The user just clicked
                Intent ChooseCountryIntent = new Intent(MainActivity.this, ChooseCountry.class);
                startActivity(ChooseCountryIntent);
            }
        });
    }
}