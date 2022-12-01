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

public class MainActivity extends AppCompatActivity {

    EditText mNameEditText;
    Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivityIntent);
            }
        });

        TextView test33;
        //sharedpreference//

            test33 = findViewById(R.id.textView2);
            QuestionAnswer.createEuropeAnswer();
            String test464 = "";
            int zeta=0;
            while (zeta<6){
                for (String Questiontest : QuestionAnswer.EuropeAnswer.keySet()){
//                  test33.setText(QuestionAnswer.EuropeAnswer.toString());
                    test464 = test464 + Questiontest.toString();
                    zeta += 1;
                    }
            }
            test33.setText(test464);
    }
}