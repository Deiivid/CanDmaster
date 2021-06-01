package com.example.candmasterdavidproyecto.Salud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.candmasterdavidproyecto.R;
import com.example.candmasterdavidproyecto.Salud.SaludFragmentos.Salud_Comida;
import com.example.candmasterdavidproyecto.Salud.SaludFragmentos.Salud_Higuiene;
import com.example.candmasterdavidproyecto.Salud.SaludFragmentos.Salud_Vacunas;
import com.example.candmasterdavidproyecto.Salud.SaludFragmentos.Salud_accesorios;

public class Salud_Menu extends AppCompatActivity {
private Button saludcomida,saludvacunas,saludhiguiene,saludaccesorios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud__menu);
        saludaccesorios = findViewById(R.id.btnAccesorios);
        saludcomida = findViewById(R.id.btnComida);
        saludvacunas = findViewById(R.id.btnVacunas);
        saludhiguiene = findViewById(R.id.btnHiguiene);



        //fragmento
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.FragmentSaludcontainer, new Salud_Higuiene())
                .disallowAddToBackStack()
                .commit();



        saludaccesorios.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Fragment fragmentoA = new Salud_accesorios();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.FragmentSaludcontainer, fragmentoA)
                                .disallowAddToBackStack()
                                .commit();
                    }
                });

        saludcomida.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Fragment fragmentob = new Salud_Comida();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.FragmentSaludcontainer, fragmentob)
                                .disallowAddToBackStack()
                                .commit();
                    }
                });
        saludvacunas.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Fragment fragmentoc = new Salud_Vacunas();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.FragmentSaludcontainer, fragmentoc)
                                .disallowAddToBackStack()
                                .commit();
                    }
                });
        saludhiguiene.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Fragment fragmentod = new Salud_Higuiene();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.FragmentSaludcontainer, fragmentod)
                                .disallowAddToBackStack()
                                .commit();
                    }
                });

    }
}