package com.rafa.empresa.View.Activys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rafa.empresa.Foto_de_Perfil;
import com.rafa.empresa.R;
import com.rafa.empresa.Uteis.Capturando_Token;

public class MainActivity extends AppCompatActivity {

    private Button button_cadastro;
    private Button btn_entar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_cadastro = findViewById(R.id.button_cadastro);
        btn_entar       = findViewById(R.id.buton_entrar);

        btn_entar       = findViewById(R.id.buton_entrar);

        Capturando_Token capturando_token = new Capturando_Token();
        capturando_token.capturado();

        btn_entar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Tela_login.class);
                startActivity(intent);
            }
        });

        // Ações de click

        button_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(), Dados_pessoais.class);
               startActivity(intent);

            }
        });
    }

}