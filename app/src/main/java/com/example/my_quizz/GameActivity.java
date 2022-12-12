package com.example.my_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private AlertDialog endGame;
    private AlertDialog pause;
    private TextView timerdisplay;
    private long timerleft = NumberQuestion.time;
    private TextView totalQuestionsTextView;
    private TextView questionTextView;
    private Button repA,repB,repC,repD,ButtonPause;
    private int score = 0;
    private final Map<Integer, String[][]> CountryAnswer = ChooseCountry.CountryAnswer;
    private final int totalQuestion = CountryAnswer.size();
    private final int numberQuestion = NumberQuestion.maxQuestion;
    private int currentQuestionIndex = 0;
    private String selectedAnswer="";
    private final ArrayList<Integer> randomNumberIndexList = new ArrayList<>();
    {for (int i=1; i<totalQuestion+1; i++) randomNumberIndexList.add(i);
        Collections.shuffle(randomNumberIndexList);}

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
        ButtonPause = findViewById((R.id.parameters));

        ButtonPause.setOnClickListener(this);
        repA.setOnClickListener(this);
        repB.setOnClickListener(this);
        repC.setOnClickListener(this);
        repD.setOnClickListener(this);

        timerdisplay = findViewById(R.id.timer);
        timer();
        loadNewQuestion();
    }
    @SuppressLint("NonConstantResourceId")
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
            case R.id.parameters:
                parameters();
                break;
        }
    }

    public void timer(){
        CountDownTimer countDownTimer = new CountDownTimer(timerleft, 1000) {
            @Override
            public void onTick(long l) {
                timerleft = l;
                int minutes = (int) timerleft / 60000;
                int secondes = (int) timerleft % 60000 / 1000;
                String time;
                time = minutes + ":";
                if (secondes < 10) {
                    time += "0";
                }
                time += secondes;
                timerdisplay.setText(time);
            }
            @Override
            public void onFinish() {
                finishQuiz();
            }
        }.start();
    }

    public void delay(){
        CountDownTimer TimerBetweenQestion = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {}

            @Override
            public void onFinish() {
                loadNewQuestion();
            }
        }.start();
    }

    public void chooseAnswer(Button clickedButton) {
        List<Button> rep = Arrays.asList(repA, repB, repC, repD);
        for (Button choice : rep) {
            if (choice.getText().toString() == CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex))[2][0]) {
                choice.setBackgroundColor(Color.parseColor("#90EE90"));
            } else {
                choice.setBackgroundColor(Color.parseColor("#FF0000"));
            }
        }
        if (selectedAnswer.equals(Objects.requireNonNull(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex)))[2][0]))
            {score++; }
        currentQuestionIndex++;
        delay();
    }

    @SuppressLint("SetTextI18n")
    private void loadNewQuestion() {
        totalQuestionsTextView.setText("Questions restantes: "+ (numberQuestion - currentQuestionIndex));
        if(currentQuestionIndex >= numberQuestion){
            finishQuiz();
            return;
        }
        ArrayList<Integer> randomNumber = new ArrayList<>();
        for (int i=0; i<4; i++) randomNumber.add(i);
        Collections.shuffle(randomNumber);
        questionTextView.setText(Objects.requireNonNull(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex)))[0][0]);
        repA.setText(Objects.requireNonNull(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex)))[1][randomNumber.get(0)]);
        repB.setText(Objects.requireNonNull(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex)))[1][randomNumber.get(1)]);
        repC.setText(Objects.requireNonNull(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex)))[1][randomNumber.get(2)]);
        repD.setText(Objects.requireNonNull(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex)))[1][randomNumber.get(3)]);
        repA.setBackgroundColor(Color.parseColor("#598A2BE2"));
        repB.setBackgroundColor(Color.parseColor("#598A2BE2"));
        repC.setBackgroundColor(Color.parseColor("#598A2BE2"));
        repD.setBackgroundColor(Color.parseColor("#598A2BE2"));
        }

    private void parameters(){
        pause = new AlertDialog.Builder(this,R.style.paramDialog)
                .setTitle("Menu pause")
                .setMessage("                                                                       ")
                .setPositiveButton("Reprendre", ((dialogInterface, i) -> pause.dismiss()))
                .setNeutralButton("Quitter", ((dialogInterface, i) -> returnToHome()))
                .setCancelable(false)
                .show();
        pause.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pause_menu));
    }

    private void returnToHome() {
        Intent MainIntent = new Intent(GameActivity.this, MainActivity.class);
        startActivity(MainIntent);

    }

    private void finishQuiz() {
        String passStatus;
        if (score > numberQuestion*0.60) {
            passStatus = "REUSSI";
        }else{
            passStatus = "RATE";
        }

        endGame = new AlertDialog.Builder(this,R.style.paramDialog)
                .setTitle(passStatus)
                .setMessage(MainActivity.name + " ton score est de "+score+" sur "+ numberQuestion)
                .setPositiveButton("Recommencer",((dialogInterface, i) -> restartQuiz()))
                .setCancelable(false)
                .show();
        endGame.getWindow().setBackgroundDrawable(getDrawable(R.drawable.endgame));

    }

    private void restartQuiz() {
        Intent ChooseCountryIntent = new Intent(GameActivity.this, ChooseCountry.class);
        startActivity(ChooseCountryIntent);

    }
}