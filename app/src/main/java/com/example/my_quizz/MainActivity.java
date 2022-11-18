package com.example.my_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mUpperTextView;
    private EditText mNameEditText;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = findViewById(R.id.main_challenger_name);
        mStartButton = findViewById(R.id.main_start_button);
        mStartButton.setEnabled(false); //permet de désactiver le bouton

        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mStartButton.setEnabled(!s.toString().isEmpty()); //détecte si il y a au moins une lettre de rentrée
            }
        });
    }
}