package com.example.candmasterdavidproyecto.Entrenamiento.EntrenamientoVideos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.candmasterdavidproyecto.MainActivity;
import com.example.candmasterdavidproyecto.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Entrenamiento_Quieto extends AppCompatActivity {
    Button siguientetruco;
    ImageButton btnhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento__quieto);
        siguientetruco = findViewById(R.id.siguienteTruco);
        btnhome = (FloatingActionButton)findViewById(R.id.botonhomequieto);
//*****************************ACTIVIDAD home*********************************//
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        siguientetruco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Entrenamiento_Quieto.this, Entrenamiento_Pata.class));
                finish();
            }
        });

    }
}