package com.rafa.empresa.View.Activys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
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

                 String email_cap = email_login.getText().toString();
                 String sena_cap = senha.getText().toString();
                 Faz_cadastro faz_cadastro = new Faz_cadastro();
                 faz_cadastro.faz_cadastro(Tela_login.this, email_login,senha);
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