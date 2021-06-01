package com.example.candmasterdavidproyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.candmasterdavidproyecto.ControlUsuarios.Firebase.LoginActivity;
import com.example.candmasterdavidproyecto.ControlUsuarios.Usuarios_Configuracion;
import com.example.candmasterdavidproyecto.Entrenamiento.Entrenamientos;
import com.example.candmasterdavidproyecto.Quiz.Quiz;
import com.example.candmasterdavidproyecto.Salud.Salud_Menu;
import com.example.candmasterdavidproyecto.Vacunas.Vacunas;
import com.example.candmasterdavidproyecto.mapas.GoogleMapsActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    CardView cardSalud, cardTiendaAnimales, cardVeterinarios, cardUsuarios, cardEntrenamientos,cardVacunas;


    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardSalud= findViewById(R.id.salud);
        cardTiendaAnimales= findViewById(R.id.tiendaanimales);
        cardVeterinarios= findViewById(R.id.veterinarios);
        mAuth = FirebaseAuth.getInstance();
        cardEntrenamientos= findViewById(R.id.entrenamientos);

        cardUsuarios= findViewById(R.id.UsuariosConfig);
        cardVacunas= findViewById(R.id.Vacunas);

        //*****************************ACTIVIDAD Vacunas*********************************//
        cardVacunas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAuth.getCurrentUser()!=null) {
                    startActivity(new Intent(getApplicationContext(), Vacunas.class));
                }else{
                    startActivity(new Intent(MainActivity.this, UsuarioNoRegistrado.class));
                }

            }
        });

        //*****************************ACTIVIDAD cardEntrenamientos*********************************//
        cardEntrenamientos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAuth.getCurrentUser()!=null) {
                    startActivity(new Intent(getApplicationContext(), Entrenamientos.class));
                }else{
                    startActivity(new Intent(MainActivity.this, UsuarioNoRegistrado.class));
                }

            }
        });
        //*****************************ACTIVIDAD Usuarios*********************************//
        cardUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //ccomprobamos si usuario ya existe y si es asi realiza login
                if (mAuth.getCurrentUser()!=null) {
                    startActivity(new Intent(MainActivity.this, Usuarios_Configuracion.class));
                }else{
                    startActivity(new Intent(MainActivity.this, UsuarioNoRegistrado.class));
                }

            }
        });


        //*****************************ACTIVIDAD tiendas*********************************//
        cardTiendaAnimales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Quiz.class));
            }
        });

//*****************************ACTIVIDAD cardVeterinarios*********************************//
        cardVeterinarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GoogleMapsActivity.class));
            }
        });


        //*****************************ACTIVIDAD SALUD*********************************//
        cardSalud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Salud_Menu.class));
            }
        });






    }
}