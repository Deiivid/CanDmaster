package com.example.candmasterdavidproyecto.Carga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import com.example.candmasterdavidproyecto.MainActivity;
import com.example.candmasterdavidproyecto.R;
import com.google.firebase.auth.FirebaseAuth;

public class Pantalla_Carga extends AppCompatActivity {

    FirebaseAuth mAuth;

    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__carga);
        init();
        mAuth = FirebaseAuth.getInstance();
        //sumulamos inicio
        progressBar.setVisibility(View.VISIBLE);
        //simulamos fin proceso
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }, 3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //ccomprobamos si usuario ya existe y si es asi realiza login
                if (mAuth.getCurrentUser()!=null){
                    startActivity(new Intent(Pantalla_Carga.this, MainActivity.class));

                    //sino llevame a todo el tutorial
                }else {
                    Intent intent = new Intent(Pantalla_Carga.this, Pantalla_Info.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 3000);

    }
    //Barra de progreso
    private void init() {
        this.progressBar = findViewById(R.id.barradeprogesoID);
    }



}
