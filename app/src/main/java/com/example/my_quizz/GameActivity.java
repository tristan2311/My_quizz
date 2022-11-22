package com.example.my_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button repA,repB,repC,repD;

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer="";


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
        if (clickedButton.getId()==R.id.in_game_activity_button_1) {
            if(selectedAnswer.equals(QuestionAnswer.Bonnereponse[currentQuestionIndex])){
                score ++;
            }
        if (clickedButton.getId()==R.id.in_game_activity_button_2)
            if(selectedAnswer.equals(QuestionAnswer.Bonnereponse[currentQuestionIndex])) {
                score++;
            }
        if(clickedButton.getId()==R.id.in_game_activity_button_3){
            if (selectedAnswer.equals(QuestionAnswer.Bonnereponse[currentQuestionIndex])){
                score++;
            }
        if(clickedButton.getId()==R.id.in_game_activity_button_4){
            if(selectedAnswer.equals(QuestionAnswer.Bonnereponse[currentQuestionIndex])){
                score++;
            }
        }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            selectedAnswer = clickedButton.getText().toString();
        }

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
