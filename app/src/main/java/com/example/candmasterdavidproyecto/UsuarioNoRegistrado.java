package com.example.candmasterdavidproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.candmasterdavidproyecto.ControlUsuarios.Firebase.LoginActivity;
import com.example.candmasterdavidproyecto.ControlUsuarios.Firebase.RegistroActivity;
import com.example.candmasterdavidproyecto.mapas.GoogleMapsActivity;

public class UsuarioNoRegistrado extends AppCompatActivity {
Button iniciarsesion , registrarse ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_no_registrado);

        iniciarsesion= findViewById(R.id.idiniciarsesion);
        registrarse= findViewById(R.id.registrarse);

        //*****************************ACTIVIDAD tiendas*********************************//
        iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
        //*****************************ACTIVIDAD tiendas*********************************//
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
                finish();
            }
        });
    }
}