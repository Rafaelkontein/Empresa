package com.rafa.empresa.View.Activys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rafa.empresa.Interfaces.Deleate;
import com.rafa.empresa.Interfaces.Isyncserveser;
import com.rafa.empresa.Enuns.Localidades;
import com.rafa.empresa.Modais.Variavel_cadastro;
import com.rafa.empresa.Uteis.Manipulaçãostr;
import com.rafa.empresa.Modais.ParteCadastro.Cidade;
import com.rafa.empresa.R;
import com.rafa.empresa.Task.RequestCEP;
import com.rafa.empresa.Uteis.Povoar;
import com.rafa.empresa.View.Dialog.Showdialog;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Endereco_pessoal extends AppCompatActivity implements Deleate {

    private EditText cep;
    private EditText rua;
    private EditText bairro;
    private TextView cidade;
    private TextView uf;
    private Button button;
    private Retrofit retrofit;
    private List<String> list = new ArrayList<>();
    private List<String> listuf = new ArrayList<>();
    public Localidades localidades;
    public  static String Ufselecionada;
    public static  String Cidadeselecionada;
    private  GifImageView gifImageView;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco_pessoal);

        cep    = findViewById(R.id.cep);
        rua    = findViewById(R.id.rua);
        bairro = findViewById(R.id.bairro);
        cidade = findViewById(R.id.cidade);
        uf     = findViewById(R.id.uf);
        button = findViewById(R.id.butonend);
        view = findViewById(R.id.view_carregando);
        gifImageView = findViewById(R.id.carregando);

        GradientDrawable corrua= (GradientDrawable) rua.getBackground();
        corrua.mutate();
        GradientDrawable corcep =(GradientDrawable) cep.getBackground();
        corcep.mutate();
        GradientDrawable corbairro = (GradientDrawable) bairro.getBackground();
        corbairro.mutate();
        GradientDrawable corcidade =(GradientDrawable) cidade.getBackground();
        corcidade.mutate();
        GradientDrawable coruf =    (GradientDrawable) uf.getBackground();
        coruf.mutate();
        Povoar povoar = new Povoar();
        povoar.povoando(listuf);
        ouvinte();


        Manipulaçãostr manipulaçãostr = new Manipulaçãostr();

        manipulaçãostr.Maskcep(cep);

        uf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Showdialog showdialog = new Showdialog();
               localidades = Localidades.ufff;
              showdialog.showdialoguf(Endereco_pessoal.this,listuf,Endereco_pessoal.this);

            }
        });

        cidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(uf.getText().toString().equals("UF")){

                  Toast.makeText(getApplicationContext(), "Selecione uma UF", Toast.LENGTH_LONG).show();
                  coruf.setStroke(3,Color.RED);
              }else{
                  localidades = Localidades.cidadeeee;
                  Showdialog showdialog = new Showdialog();
                  showdialog.showdialogcidade( Endereco_pessoal.this, list, Endereco_pessoal.this);
              }
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(rua.getText().toString().length()>1 && cep.getText().toString().length() >= 9
                        && bairro.getText().toString().length() >1 &&
                        !cidade.getText().toString().equals("Cidade") && !uf.getText().toString().equals("UF")) {

                    Variavel_cadastro.rua = rua.getText().toString();
                    Variavel_cadastro.cep = cep.getText().toString();
                    Variavel_cadastro.bairro = bairro.getText().toString();
                    Variavel_cadastro.cidade = cidade.getText().toString();
                    Variavel_cadastro.uf = uf.getText().toString();

                    Intent intent = new Intent(Endereco_pessoal.this, Dados_pagamento.class);
                    startActivity(intent);


                }else{
                    if(rua.getText().toString().length() ==0 ){
                        corrua.setStroke(3, Color.RED);
                        rua.setTextColor(Color.RED);
                        rua.setHintTextColor(Color.RED);

                    }else{
                        corrua.setStroke(3, Color.parseColor("#20A7B4"));
                        rua.setTextColor(Color.WHITE);
                        rua.setHintTextColor(Color.WHITE);

                    }
                    if(bairro.getText().toString().length() ==0){
                        corbairro.setStroke(3, Color.RED);
                        bairro.setTextColor(Color.RED);
                        bairro.setHintTextColor(Color.RED);

                    }else{
                        corbairro.setStroke(3, Color.parseColor("#20A7B4"));
                        bairro.setTextColor(Color.WHITE);
                        bairro.setHintTextColor(Color.WHITE);

                    }
                    if(cep.getText().toString().length()<9){
                        corcep.setStroke(3,Color.RED);
                        cep.setTextColor(Color.RED);
                        cep.setHintTextColor(Color.RED);
                    }else{
                        corcep.setStroke(3,Color.parseColor("#20A7B4"));
                        cep.setTextColor(Color.WHITE);
                        cep.setHintTextColor(Color.WHITE);
                    }
                    if(cidade.getText().toString().equals("Cidade")){
                        corcidade.setStroke(3,Color.RED);
                        cidade.setTextColor(Color.RED);


                    }else{
                        corcidade.setStroke(3,Color.parseColor("#20A7B4"));
                        cidade.setTextColor(Color.WHITE);
                    }
                    if(uf.getText().toString().equals("UF")){
                        coruf.setStroke(3,Color.RED);
                        uf.setTextColor(Color.RED);


                    }else{
                        coruf.setStroke(3,Color.parseColor("#20A7B4"));
                        uf.setTextColor(Color.WHITE);
                    }


                }


            }
        });
    }


    public void ouvinte(){
        GradientDrawable corrua= (GradientDrawable) rua.getBackground();
        corrua.mutate();
        GradientDrawable corcep =(GradientDrawable) cep.getBackground();
        corcep.mutate();
        GradientDrawable corbairro = (GradientDrawable) bairro.getBackground();
        corbairro.mutate();
        GradientDrawable corcidade =(GradientDrawable) cidade.getBackground();
        corcidade.mutate();
        GradientDrawable coruf =    (GradientDrawable) uf.getBackground();
        coruf.mutate();
        cep.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i1 >= 9){
                    RequestCEP requestCEP = new RequestCEP();
                    requestCEP.Resquestcep(cep,rua,cidade,uf,bairro);
                    corcep.setStroke(3,Color.parseColor("#20A7B4"));
                    cep.setTextColor(Color.WHITE);
                    cep.setHintTextColor(Color.WHITE);

                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        rua.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i1>1){
                    corrua.setStroke(3, Color.parseColor("#20A7B4"));
                    rua.setTextColor(Color.WHITE);
                    rua.setHintTextColor(Color.WHITE);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        bairro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i1>1){
                    corcep.setStroke(3,Color.parseColor("#20A7B4"));
                    cep.setTextColor(Color.WHITE);
                    cep.setHintTextColor(Color.WHITE);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    @Override
    public void onDismiss() {


        switch (localidades){
            case ufff:
                view.setVisibility(View.VISIBLE);
                gifImageView.setVisibility(View.VISIBLE);


                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://servicodados.ibge.gov.br/api/v1/localidades/")
                        .addConverterFactory(GsonConverterFactory.create()).build();

                Isyncserveser isyncserveser = retrofit.create(Isyncserveser.class);
                Povoar povoar = new Povoar();

                Call<List<Cidade>> call = isyncserveser.buscascidade(Ufselecionada.substring(0,2));

                call.enqueue(new Callback<List<Cidade>>() {
                    @Override
                    public void onResponse(Call<List<Cidade>> call, Response<List<Cidade>> response) {
                        if(response.isSuccessful()){

                            Log.d("Requestt", "");
                            List<Cidade> cidades = response.body();
                            list.clear();
                            for (int i =0 ; i< cidades.size() ; i++){
                                list.add(cidades.get(i).getNome());
                            }


                        }else{
                            Log.d("Deu ruim",response.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Cidade>> call, Throwable t) {

                    }
                });

                uf.setText(Ufselecionada);
                view.setVisibility(View.GONE);
                gifImageView.setVisibility(View.GONE);
                break;
            case cidadeeee:
                cidade.setText(Cidadeselecionada);
                break;

        }
    }
}