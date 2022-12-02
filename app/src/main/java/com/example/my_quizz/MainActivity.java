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
                Intent numberQuestionIntent = new Intent(MainActivity.this, NumberQuestion.class);
                startActivity(numberQuestionIntent);
            }
        });

//        TextView test33;
//        //sharedpreference//
//        test33 = findViewById(R.id.textView2);
//        QuestionAnswer.createEuropeAnswer();
//        String test464 = "";
//        ThreadLocalRandom aléatoire = ThreadLocalRandom.current();
//        int randomNumber = 0;
//            for(int i =0; i<6; i++){
//                randomNumber = aléatoire.nextInt(0,QuestionAnswer.EuropeAnswer.size()+1);
//                test464 = test464 + randomNumber + QuestionAnswer.EuropeAnswer.get(randomNumber)[2][0].toString();
//                    }
//        test33.setText(String.valueOf(QuestionAnswer.EuropeAnswer.size()));
    }
}