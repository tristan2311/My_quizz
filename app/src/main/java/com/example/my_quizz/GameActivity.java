package com.example.my_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private MediaPlayer musicplayer;
    private String selectedAnswer="";
    private AlertDialog endGame; //Alert dialog pour la fin de la partie
    private AlertDialog pause;   //Alert dialog pour le menu pause
    private TextView timerdisplay; //Permet d'afficher le temps restant
    private long timerleft = NumberQuestion.time; //Permet d'avoir le temps totales pour la partie en cours
    private TextView totalQuestionsTextView; //Affiche le nombre total de question
    private TextView questionTextView;       //Affiche la question auquel il faut répondre
    private Button repA,repB,repC,repD,ButtonPause; //Créer les différents boutton
    private int score = 0; //Créer le score du joueur
    private final Map<Integer, String[][]> CountryAnswer = ChooseCountry.CountryAnswer; //Récupère la Hashmap choisi par le joueur
    private final int totalQuestion = CountryAnswer.size(); //Correspond à la taille totale de la Hashmap choisie
    private final int numberQuestion = NumberQuestion.maxQuestion; //Récupère le nombre de question à répondre en fonction du niveau de difficulté choisi
    private int currentQuestionIndex = 0; //permet de savoir a combien de réponse le joueur a déjà répondu
    //Créer une liste mélangé de nombre entre 1 et le nombre total de questions de la HashMap ce qui permettra d'obtenir les questions de manière aléatoire
    private final ArrayList<Integer> randomNumberIndexList = new ArrayList<>();
    {for (int i=1; i<totalQuestion+1; i++) randomNumberIndexList.add(i);
        Collections.shuffle(randomNumberIndexList);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);
        String url = NumberQuestion.urlMusique; //Récupère la String qui contient l'URL vers la musique en fonction du niveaux de difficulté choisi
        this.musicplayer = new MediaPlayer();
        // try catch pour gérer le cas ou on ne peut pas charger la musique
        try {
            musicplayer.setDataSource(url);
            musicplayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Permet de gérer l'activation ou la coupure de la musique en fonction de la valeur d'une variable qui correspond à son état
        if(MainActivity.stateButton == 0)
            Music.musicValue=1;
        else if (MainActivity.stateButton == 1)
            Music.musicValue=0;
        Music.playSound(musicplayer);
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
        // Permet de lancer la fonction chooseAnswer quelque soit le bouton parmis les réponses sur lequel on clique
        switch(clickedButton.getId()) {
            case R.id.in_game_activity_button_1:
            case R.id.in_game_activity_button_2:
            case R.id.in_game_activity_button_3:
            case R.id.in_game_activity_button_4:
                chooseAnswer(clickedButton);
                break;
            case R.id.parameters: //Permet d'afficher la page paramètres
                parameters();
                break;
        }
    }

    //Permet de créer et d'afficher le Timer
    public void timer(){
        //Créer le Timer avec le temps définis par timerleft
        CountDownTimer countDownTimer = new CountDownTimer(timerleft, 1000) {
            @Override
            public void onTick(long l) {
                timerleft = l;
                int minutes = (int) timerleft / 60000; //Récupère les minutes
                int secondes = (int) timerleft % 60000 / 1000; //Récupère les secondes
                String time;
                time = minutes + ":";
                if (secondes < 10) {
                    time += "0";
                }
                time += secondes;
                timerdisplay.setText(time); //Affiche la valeur du Timer
            }
            @Override
            public void onFinish() {finishQuiz();} //Permet de lancer la fonction qui termine le jeu lorsque le Timer est terminé
        }.start(); //Lance le Timer
    }

    //Créer un délai pour l'affichage des couleurs(vert ou rouge) lors du choix d'une réponse
    public void delay(){
        CountDownTimer TimerBetweenQuestion = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {}

            @Override
            public void onFinish() {loadNewQuestion();} //Lance la fontion qui charge une nouvelle question lorsque le délai est finis
        }.start();
    }

    //Permet de changer la couleur des boutons en vert pour la bonne réponse et en rouges pour les mauvaises
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

    //Permet de charger de nouvelle question et de nouvelles réponses de manière aléatoire dans la Hashmap
    private void loadNewQuestion() {
        totalQuestionsTextView.setText("Questions restantes: "+ (numberQuestion - currentQuestionIndex)); //Affiche le nombre de questions restantes
        if(currentQuestionIndex >= numberQuestion){
            finishQuiz();
            return;
        }
        //Créer une liste de 1 à 4 mélanger aléatoirement pour associer les réponses de la Hashmap au bouton
        // et que les réponses ne soit pas tooujours à la même place pour une question données
        ArrayList<Integer> randomNumber = new ArrayList<>();
        for (int i=0; i<4; i++) randomNumber.add(i);
        Collections.shuffle(randomNumber);
        //Associe le bouton à l'indice de la Hashmap qui correpond au différente réponse
        questionTextView.setText(Objects.requireNonNull(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex)))[0][0]);
        repA.setText(Objects.requireNonNull(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex)))[1][randomNumber.get(0)]);
        repB.setText(Objects.requireNonNull(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex)))[1][randomNumber.get(1)]);
        repC.setText(Objects.requireNonNull(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex)))[1][randomNumber.get(2)]);
        repD.setText(Objects.requireNonNull(CountryAnswer.get(randomNumberIndexList.get(currentQuestionIndex)))[1][randomNumber.get(3)]);
        //Remet les bouton à leur couleur initiale
        repA.setBackgroundColor(Color.parseColor("#598A2BE2"));
        repB.setBackgroundColor(Color.parseColor("#598A2BE2"));
        repC.setBackgroundColor(Color.parseColor("#598A2BE2"));
        repD.setBackgroundColor(Color.parseColor("#598A2BE2"));
        }

    //Permet d'afficher le menu pause
    private void parameters(){
        pause = new AlertDialog.Builder(this,R.style.paramDialog)
                .setTitle("Menu pause")
                .setMessage("                                                                       ")
                //Reprendre la partie(correspond à simplement fermé l'alertDialog
                .setPositiveButton("Reprendre", ((dialogInterface, i) -> pause.dismiss()))
                //Permet de coupr la musique
                .setNegativeButton("Musique", ((dialogInterface, i) -> {Music.playSound(musicplayer);MainActivity.stateButton = Music.musicValue;}))
                //Permet de retouner à l'activité de la classe MainActivity
                .setNeutralButton("Quitter", ((dialogInterface, i) -> {returnToHome();}))
                .setCancelable(false)
                .show();
        pause.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pause_menu)); //Change le fond de l'image
    }

    //Permet de retouner à l'activité de la classe MainActivity
    private void returnToHome() {
        Music.musicValue = 1;
        Music.playSound(musicplayer);
        Intent MainIntent = new Intent(GameActivity.this, MainActivity.class);
        startActivity(MainIntent);

    }

    //Permet d'afficher une fenêtre lorsque la partie est finis
    private void finishQuiz() {
        String passStatus;
        //Marque que le joueur a réussi si il a au moins 60% de bonnes réponses
        if (score > numberQuestion*0.60) {
            passStatus = "REUSSI";
        }else{
            passStatus = "RATE";
        }

        endGame = new AlertDialog.Builder(this,R.style.paramDialog)
                .setTitle(passStatus)
                .setMessage(MainActivity.name + " ton score est de "+score+" sur "+ numberQuestion)
                //Permet de relancer une partie en retounant à l'activité de la classe ChooseCountry
                .setPositiveButton("Recommencer",((dialogInterface, i) -> restartQuiz()))
                .setCancelable(false)
                .show();
        endGame.getWindow().setBackgroundDrawable(getDrawable(R.drawable.endgame));

    }

    //Permet de relancer une partie en retounant à l'activité de la classe ChooseCountry
    private void restartQuiz() {
        Music.musicValue=1;
        Music.playSound(musicplayer);
        Intent ChooseCountryIntent = new Intent(GameActivity.this, ChooseCountry.class);
        startActivity(ChooseCountryIntent);

    }
}