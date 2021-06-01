package com.example.candmasterdavidproyecto.ControlUsuarios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.candmasterdavidproyecto.ControlUsuarios.Firebase.LoginActivity;
import com.example.candmasterdavidproyecto.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Usuarios_Configuracion extends AppCompatActivity {
    FirebaseAuth mAuth;
    Snackbar snackbar;
    ProgressBar accountSettingProgress;
    Button cerrarsesion, eliminarcuenta;


    ConstraintLayout constraintLayout;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios__configuracion);
        eliminarcuenta =findViewById(R.id.btn_eliminarcuenta);
        cerrarsesion =findViewById(R.id.btn_cerrarsesion);

        mAuth = FirebaseAuth.getInstance();
        ConstraintLayout constraintLayout = null;
        constraintLayout = findViewById(R.id.settingContainer);
        accountSettingProgress = findViewById(R.id.accountsettin_progress);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(Usuarios_Configuracion.this, LoginActivity.class));
                finish();
            }
        });

        ConstraintLayout finalConstraintLayout = constraintLayout;
        eliminarcuenta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    accountSettingProgress.setVisibility(View.VISIBLE);

                    if(user != null){

                        user.delete()
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        AlertDialog.Builder builder = new AlertDialog.Builder(Usuarios_Configuracion.this);
                                        builder.setTitle("¿ Estas seguro que quieres eliminar tu cuenta ?");
                                        builder.setMessage("Si eliminas tu cuenta perderas todos los datos");

                                        builder.setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                snackbar = Snackbar.make(finalConstraintLayout, "Tu cuenta ha sido eliminada con exito.", Snackbar.LENGTH_SHORT);
                                                snackbar.show();
                                                accountSettingProgress.setVisibility(View.GONE);

                                                Intent i = new Intent(Usuarios_Configuracion.this, LoginActivity.class);
                                                startActivity(i);
                                                finish();
                                            }
                                        });

                                        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                snackbar = Snackbar.make(finalConstraintLayout, "La cuenta no se ha eliminado.", Snackbar.LENGTH_SHORT);
                                                snackbar.show();
                                                accountSettingProgress.setVisibility(View.GONE);
                                            }
                                        });
                                        builder.show();
                                    }
                                });

                    }

                }
            });




    }
}