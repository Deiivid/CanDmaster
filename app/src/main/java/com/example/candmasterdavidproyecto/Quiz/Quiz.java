package com.example.candmasterdavidproyecto.Quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.candmasterdavidproyecto.MainActivity;
import com.example.candmasterdavidproyecto.R;

import java.util.Random;

public class Quiz extends AppCompatActivity {
Button respuesta1, respuesta2,respuesta3,respuesta4;
TextView score, question;


private  Questions mQuestions =  new Questions();
private String mAnswer;
private int mScore=0;
private int mQyuestionsLenght = mQuestions.mQuestions.length;
 Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        r =  new Random();
        respuesta1= findViewById(R.id.botonquiz1);
        respuesta2= findViewById(R.id.botonquiz2);
        respuesta3= findViewById(R.id.botonquiz3);
        respuesta4= findViewById(R.id.botonquiz4);


        score= findViewById(R.id.Puntuacion);
        question= findViewById(R.id.questions);

        updateQuestions(r.nextInt(mQyuestionsLenght));

        ////*************boton 1***********////
        respuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        if(respuesta1.getText() == mAnswer){
            mScore ++;
            score.setText("Puntiación " + mScore);
            updateQuestions(r.nextInt(mQyuestionsLenght));
        }else{
            gameOver();

        }
            }
        });
        ////*************boton 2***********////
        respuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(respuesta2.getText() == mAnswer){
                    mScore ++;
                    score.setText("Puntiación " + mScore);
                    updateQuestions(r.nextInt(mQyuestionsLenght));
                }else{
                    gameOver();

                }
            }
        });

        ////*************boton 3***********////
        respuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(respuesta3.getText() == mAnswer){
                    mScore ++;
                    score.setText("Puntiación " + mScore);
                    updateQuestions(r.nextInt(mQyuestionsLenght));
                }else{
                    gameOver();

                }
            }
        });
        ////*************boton 4***********////
        respuesta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(respuesta4.getText() == mAnswer){
                    mScore ++;
                    score.setText("Puntiación " + mScore);
                    updateQuestions(r.nextInt(mQyuestionsLenght));
                }else{
                    gameOver();

                }
            }
        });
    }

    private  void updateQuestions(int num){
        question.setText(mQuestions.getQuestions(num));
        respuesta1.setText(mQuestions.getChoice1(num));
        respuesta2.setText(mQuestions.getChoice2(num));
        respuesta3.setText(mQuestions.getChoice3(num));
        respuesta4.setText(mQuestions.getChoice4(num));


        mAnswer = mQuestions.getCorrectAnswer(num);
    }

    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Quiz.this);
        alertDialogBuilder
                .setMessage("Game Over!! Tu puntuación es de " + mScore + " Puntos.")
                .setCancelable(false)
                .setPositiveButton("Nuevo Quiz", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(getApplicationContext(), Quiz.class));
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}