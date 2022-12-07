package com.example.my_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;


public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button repA,repB,repC,repD;

    String Answer;
    String Message;
    int score = 0;
    Map<Integer, String[][]> CountryAnswer = ChooseCountry.CountryAnswer;
    int totalQuestion = CountryAnswer.size();
    int numberQuestion = NumberQuestion.maxQuestion;
    int currentQuestionIndex = 0;
    String selectedAnswer="";
    ArrayList<Integer> randomNumberIndexList = new ArrayList<Integer>();
    {for (int i=1; i<totalQuestion+1; i++) randomNumberIndexList.add(i);
        Collections.shuffle(randomNumberIndexList);}

    public void chooseAnswer(Button clickedButton) {
        if (selectedAnswer.equals(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex))[2][0].toString())) {
            clickedButton.setBackgroundColor(Color.parseColor("#90EE90"));
            Answer = "Right";
            Message = "Tu as trouvé la bonne capitale !";
            score++;
        } else {
            clickedButton.setBackgroundColor(Color.parseColor("#FF0000"));
            Answer = "Wrong";
            Message = "Et non la bonne capital est " + String.valueOf(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex))[2][0]);
        }
        currentQuestionIndex++;
        new AlertDialog.Builder(this)
                .setTitle(Answer)
                .setMessage(Message)
                .setPositiveButton("Continue", ((dialogInterface, i) -> loadNewQuestion()))
                .setCancelable(false)
                .show();
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
        totalQuestionsTextView.setText("Questions restantes: "+ String.valueOf(numberQuestion-currentQuestionIndex));
        if(currentQuestionIndex == numberQuestion){
            finishQuiz();
            return;
        }
        ArrayList<Integer> randomNumber = new ArrayList<Integer>();
        for (int i=0; i<4; i++) randomNumber.add(i);
        Collections.shuffle(randomNumber);
        questionTextView.setText(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex))[0][0].toString());
        repA.setText(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex))[1][randomNumber.get(0)].toString());
        repB.setText(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex))[1][randomNumber.get(1)].toString());
        repC.setText(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex))[1][randomNumber.get(2)].toString());
        repD.setText(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex))[1][randomNumber.get(3)].toString());
        repA.setBackgroundColor(Color.parseColor("#8A2BE2"));
        repB.setBackgroundColor(Color.parseColor("#8A2BE2"));
        repC.setBackgroundColor(Color.parseColor("#8A2BE2"));
        repD.setBackgroundColor(Color.parseColor("#8A2BE2"));
        }

    private void finishQuiz() {
        String passStatus = "";
        if (score > numberQuestion*0.60) {
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score "+score+" sur "+String.valueOf(numberQuestion))
                .setPositiveButton("Recommencer",((dialogInterface, i) -> restartQuiz()))
                .setCancelable(false)
                .show();

    }

    private void restartQuiz() {
        Intent ChooseCountryIntent = new Intent(GameActivity.this, ChooseCountry.class);
        startActivity(ChooseCountryIntent);

    }
}