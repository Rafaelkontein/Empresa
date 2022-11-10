package com.rafa.empresa.View.Activys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rafa.empresa.Firebase.Faz_cadastro;
import com.rafa.empresa.R;

public class Tela_login extends AppCompatActivity {
     private EditText email_login;
     private TextInputEditText senha;
     private TextView cadastrese;
     private CheckBox relembrarsenha;
     private TextView esqeciseha;
     private TextView suporte;
     private Button entrarr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

         email_login    = findViewById(R.id.email);
         senha          = findViewById(R.id.campo_senha);
         cadastrese     = findViewById(R.id.cadastre_se);
         relembrarsenha = findViewById(R.id.checkrelembrar);
         esqeciseha     = findViewById(R.id.esqueci_senha);
         suporte        = findViewById(R.id.suporte);
         entrarr    = findViewById(R.id.entrarr);

         entrarr.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 FirebaseAuth.getInstance().signInWithEmailAndPassword(email_login.getText().toString(),senha.getText().toString()).
                         addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                     @Override
                     public void onSuccess(AuthResult authResult) {
                         Log.d("TesteloginSucesso",authResult.getUser().getUid());
                         Intent intent = new Intent(getApplicationContext(),Telaprincipal.class);
                         startActivity(intent);

                     }
                 }).addOnFailureListener(new OnFailureListener() {
                             @Override
                             public void onFailure(@NonNull Exception e) {
                                 Log.d("fail",e.getMessage());
                             }
                         });


             }
         });

         cadastrese.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(), Dados_pessoais.class);

                 startActivity(intent);
             }
         });





    }
}