package com.example.candmasterdavidproyecto.Vacunas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.candmasterdavidproyecto.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
EditText nombreperro,nombrevacuna,fecha;
Button guardar,volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nombreperro=findViewById(R.id.txtnombreperroguardar);
        nombrevacuna=findViewById(R.id.txtnombrevacunaguardar);
        fecha=findViewById(R.id.txtFechaguardar);

        guardar=findViewById(R.id.btnGuardar);
        volver=findViewById(R.id.btnVolver);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            insertDate();
                clearAll();
            }
        });


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });
    }


    private void insertDate(){

        Map<String,Object> map  = new HashMap<>();
        map.put("nombreperro",nombreperro.getText().toString());
        map.put("fecha",fecha.getText().toString());
        map.put("nombrevacuna",nombrevacuna.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("vacunas_perros_2021").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AddActivity.this, "Vacuna Insertada Con exito", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddActivity.this, "Error al Insertar", Toast.LENGTH_SHORT).show();
                    }
                });


        }
    private void clearAll(){
        nombreperro.setText("");
        nombrevacuna.setText("");
        fecha.setText("");
    }
}
