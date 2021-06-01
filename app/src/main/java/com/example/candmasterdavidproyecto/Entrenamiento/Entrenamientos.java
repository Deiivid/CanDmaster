package com.example.candmasterdavidproyecto.Entrenamiento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.candmasterdavidproyecto.Entrenamiento.EntrenamientoVideos.Entrenamiento_Pata;
import com.example.candmasterdavidproyecto.Entrenamiento.EntrenamientoVideos.Entrenamiento_Plaz;
import com.example.candmasterdavidproyecto.Entrenamiento.EntrenamientoVideos.Entrenamiento_Quieto;
import com.example.candmasterdavidproyecto.Entrenamiento.EntrenamientoVideos.Entrenamiento_Sit;
import com.example.candmasterdavidproyecto.MainActivity;
import com.example.candmasterdavidproyecto.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Entrenamientos extends AppCompatActivity {
    CardView cardPata, cardsit, cardplaz, cardquieto;
    ImageButton btnhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamientos);


        cardPata= findViewById(R.id.Entrenamientos_menu_Pata);
        cardsit= findViewById(R.id.Entrenamientos_menu_Sit);
        cardplaz= findViewById(R.id.Entrenamientos_menu_Plaz);

        btnhome = (FloatingActionButton)findViewById(R.id.botonhome);
        cardquieto= findViewById(R.id.Entrenamientos_menu_Quieto);


        //*****************************ACTIVIDAD home*********************************//
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });




        //*****************************ACTIVIDAD PATA*********************************//
        cardPata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Entrenamiento_Pata.class));
            }
        });

        //*****************************ACTIVIDAD SIT*********************************//
        cardsit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Entrenamiento_Sit.class));
            }
        });
        //*****************************ACTIVIDAD PLAZ*********************************//
        cardplaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Entrenamiento_Plaz.class));
            }
        });
        //*****************************ACTIVIDAD QUIETO*********************************//
        cardquieto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Entrenamiento_Quieto.class));
            }
        });
    }
}