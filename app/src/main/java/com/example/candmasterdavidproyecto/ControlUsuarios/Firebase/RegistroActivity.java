package com.example.candmasterdavidproyecto.ControlUsuarios.Firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.candmasterdavidproyecto.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistroActivity extends AppCompatActivity {

    private EditText edtcontraseñaregistrar, edtemailregistrar;
    private Button btnregistrar;
    private TextView txtiniciarsesion;
    //validacion firebase//
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
         txtiniciarsesion = (findViewById(R.id.Tienescuentainiciosesion));
         edtemailregistrar = (findViewById(R.id.emailtxtregistrar));
         edtcontraseñaregistrar = (findViewById(R.id.passwordtxtregistrar));
         btnregistrar = findViewById(R.id.btnregister);

         mAuth = FirebaseAuth.getInstance();

            ////****BOTON REGISTRAR***///
          btnregistrar.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  createUser();

              }
          });

            txtiniciarsesion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }
            });
        }//fIN DE ONCREATE


    private void createUser(){
        String email =  edtemailregistrar.getText().toString();
        String password =  edtcontraseñaregistrar.getText().toString();

        if(TextUtils.isEmpty((email))){
            edtemailregistrar.setError("Email no puede estar vacio");
            edtemailregistrar.requestFocus();
        }else if(TextUtils.isEmpty((password))){
            edtcontraseñaregistrar.setError("La Contraseña no puede estar vacia");
            edtcontraseñaregistrar.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegistroActivity.this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
                    } else {
                        Toast.makeText(RegistroActivity.this, "Usuario NO se ha podido Rergistrar " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            }
        }
    }

