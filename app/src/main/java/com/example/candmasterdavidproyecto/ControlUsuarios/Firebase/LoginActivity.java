package com.example.candmasterdavidproyecto.ControlUsuarios.Firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.candmasterdavidproyecto.MainActivity;
import com.example.candmasterdavidproyecto.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private Button bntLogin, btnRegister,GMAILboton;

    //  private ImageButton btnGoogle, btnTwitter, btnFacebook;
    private EditText etEmailUser, etPasswordsUser;
    FirebaseAuth mAuth;
    private TextView passolvidada,sinlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ///********BUTTON *********//
        bntLogin = (Button) findViewById(R.id.login);
        btnRegister = (Button) findViewById(R.id.register);

        etEmailUser = findViewById(R.id.emailtxt);
        etPasswordsUser = findViewById(R.id.passwordtxt);
        sinlogin = findViewById(R.id.Iniciarsincuenta);
        passolvidada = findViewById(R.id.hasolvidadopass);
        mAuth = FirebaseAuth.getInstance();
        bntLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        //*********************************BOTON REGISTRAR NOS LLEVA A Registrar_Activity*******************************************//
        sinlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        //*********************************BOTON REGISTRAR NOS LLEVA A Registrar_Activity*******************************************//
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
            }
        });
        //*********************************TXT OLVIDADO PASS*******************************************//
        passolvidada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecuperarPass.class));
            }
        });



    }















    private void loginUser(){
        String email =  etEmailUser.getText().toString();
        String password =  etPasswordsUser.getText().toString();

        if(TextUtils.isEmpty((email))){
            etEmailUser.setError("Email no puede estar vacio");
            etEmailUser.requestFocus();
        }else if(TextUtils.isEmpty((password))){
            etPasswordsUser.setError("La Contraseña no puede estar vacia");
            etPasswordsUser.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Login Correcto", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Usuario no registrado", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }



}