package com.example.candmasterdavidproyecto.Carga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.candmasterdavidproyecto.ControlUsuarios.Firebase.LoginActivity;
import com.example.candmasterdavidproyecto.R;

public class Pantalla_Info_2 extends AppCompatActivity {

    private CheckBox terminos ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__info_2);

        terminos = (CheckBox)findViewById(R.id.AceptarTerminos);
        //*********************************Boton que hace cambio de pantalla info 2********************************************//
        terminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminos.isChecked() ) {
                    Intent vitalidad = new Intent(Pantalla_Info_2.this, LoginActivity.class);
                    startActivity(vitalidad);
                    finish();
                }else{
                    Toast.makeText(Pantalla_Info_2.this, "Acepta los terminos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}