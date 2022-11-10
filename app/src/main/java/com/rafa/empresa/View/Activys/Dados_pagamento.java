package com.rafa.empresa.View.Activys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rafa.empresa.Interfaces.Deleate;
import com.rafa.empresa.R;
import com.rafa.empresa.Task.RequestBanco;
import com.rafa.empresa.Uteis.Ouvintes;

public class Dados_pagamento extends AppCompatActivity implements Deleate {
    TextView textView ;
    private EditText pix;
    public  TextView banco;
    private EditText agencia;
    private EditText conta;
    private Button buttonfinalizar;
    public  static  String banco_selecionado;
    RequestBanco requestBanco = new RequestBanco();
    private Ouvintes ouvintes = new Ouvintes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_pagamento);

        pix= findViewById(R.id.chavepix);
        banco = findViewById(R.id.banco);
        agencia = findViewById(R.id.agencia);
        conta = findViewById(R.id.conta);
        buttonfinalizar = findViewById(R.id.buttonfinalizar);
        ouvintes.ouvinteDadosPagamentos(agencia,conta);

        GradientDrawable corbanco = (GradientDrawable) banco.getBackground();
        corbanco.mutate();
        GradientDrawable coragencia = (GradientDrawable) agencia.getBackground();
        coragencia.mutate();
        GradientDrawable corconta = (GradientDrawable) conta.getBackground();
        corconta.mutate();




        buttonfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(banco_selecionado.isEmpty()|| agencia.getText().toString().isEmpty() || conta.getText().toString().isEmpty()){
                    if (banco_selecionado.isEmpty()){
                        corbanco.setStroke(3, Color.RED);
                    }else {
                        corbanco.setStroke(3, Color.parseColor("#20A7B4"));
                    }
                    if(agencia.getText().toString().isEmpty()){
                        coragencia.setStroke(3,Color.RED);
                    }else {
                        coragencia.setStroke(3, Color.parseColor("#20A7B4"));
                    }
                    if(conta.getText().toString().isEmpty()){
                        corconta.setStroke(3,Color.RED);
                    }else {
                        corconta.setStroke(3, Color.parseColor("#20A7B4"));
                    }
                }else {
                    corbanco.setStroke(3, Color.parseColor("#20A7B4"));
                    coragencia.setStroke(3, Color.parseColor("#20A7B4"));
                    corconta.setStroke(3, Color.parseColor("#20A7B4"));
                    Intent in = new Intent(Dados_pagamento.this, Tela_login.class);
                    startActivity(in);
                }


            }
        });
        banco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              requestBanco.requestbanco(Dados_pagamento.this,Dados_pagamento.this);

            }
        });
    }

    @Override
    public void onDismiss() {
        banco.setText(banco_selecionado);
    }
}