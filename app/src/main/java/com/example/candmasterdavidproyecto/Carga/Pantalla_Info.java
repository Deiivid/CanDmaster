package com.example.candmasterdavidproyecto.Carga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.candmasterdavidproyecto.R;

public class Pantalla_Info extends AppCompatActivity {
    private Button infoBotonPrimero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__info);
        infoBotonPrimero = (Button)findViewById(R.id.btnInfoPrimero);


        //*********************************Boton que hace cambio de pantalla info 2********************************************//
        infoBotonPrimero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vitalidad = new Intent(Pantalla_Info.this, Pantalla_Info_2.class);
                startActivity(vitalidad);
                finish();
            }
        });

    }
}