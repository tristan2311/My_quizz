package com.example.my_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button repA,repB,repC,repD;

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer="";

    public void chooseAnswer(Button clickedButton) {
        if (selectedAnswer.equals(QuestionAnswer.Bonnereponse[currentQuestionIndex])) {
            clickedButton.setBackgroundColor(Color.parseColor("#90EE90"));
            score++;}
        else {clickedButton.setBackgroundColor(Color.parseColor("#FF0000"));}
        currentQuestionIndex++;
        loadNewQuestion();
        clickedButton.setBackgroundResource(android.R.drawable.btn_default);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);
        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);

        repA = findViewById((R.id.in_game_activity_button_1));
        repB = findViewById((R.id.in_game_activity_button_2));
        repC = findViewById((R.id.in_game_activity_button_3));
        repD = findViewById((R.id.in_game_activity_button_4));

        repA.setOnClickListener(this);
        repB.setOnClickListener(this);
        repC.setOnClickListener(this);
        repD.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);
        loadNewQuestion();
    }
    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        selectedAnswer = clickedButton.getText().toString();
        switch(clickedButton.getId()) {
            case R.id.in_game_activity_button_1:
            case R.id.in_game_activity_button_2:
            case R.id.in_game_activity_button_3:
            case R.id.in_game_activity_button_4:
                chooseAnswer(clickedButton);
                break;
        }
    }

    private void loadNewQuestion() {
        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        repA.setText(QuestionAnswer.choix[currentQuestionIndex][0]);
        repB.setText(QuestionAnswer.choix[currentQuestionIndex][1]);
        repC.setText(QuestionAnswer.choix[currentQuestionIndex][2]);
        repD.setText(QuestionAnswer.choix[currentQuestionIndex][3]);
    }

    private void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestion*0.60) {
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score"+score+"sur"+totalQuestion)
                .setPositiveButton("Recommencer",((dialogInterface, i) -> restartQuiz()))
                .setCancelable(false)
                .show();

    }

    private void restartQuiz() {
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();

    }
}
