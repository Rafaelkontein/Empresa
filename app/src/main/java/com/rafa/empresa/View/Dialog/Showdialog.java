package com.rafa.empresa.View.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rafa.empresa.Adapters.AdapeterBanco;
import com.rafa.empresa.Adapters.Adapeter_cidade;
import com.rafa.empresa.Adapters.Adapeter_uf;
import com.rafa.empresa.Enuns.Localidades;
import com.rafa.empresa.Interfaces.Deleate;
import com.rafa.empresa.Modais.Banco;
import com.rafa.empresa.Modais.Modal_cidade;
import com.rafa.empresa.R;
import com.rafa.empresa.View.Activys.Dados_pagamento;
import com.rafa.empresa.View.Activys.Endereco_pessoal;
import com.rafa.empresa.View.Fragments.BlankViewModel;

import java.util.ArrayList;
import java.util.List;

public class Showdialog {

    public void showdialgbanco(Context context,List<Banco> list,Deleate deleate){
        final Dialog  dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.blank_fragment);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations =R.style.Dialoganimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        Button  button;
        BlankViewModel mViewModel;
        EditText buscabanco;
        RecyclerView recyclerVie;
        ImageView x;
        List <Banco> listbanco = new ArrayList<>();
        button = dialog.findViewById(R.id.buttonBanco);
        buscabanco = dialog.findViewById(R.id.buscabanco);
        recyclerVie= dialog.findViewById(R.id.recybanco);
        x = dialog.findViewById(R.id.xbanco);
        Dados_pagamento.banco_selecionado = "";

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.onBackPressed();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Dados_pagamento.banco_selecionado.isEmpty()){
                    Toast.makeText(context,"Por favor selecine um banco",Toast.LENGTH_LONG).show();

                }else{
                    deleate.onDismiss();
                    dialog.onBackPressed();
                }
            }
        });



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);

        recyclerVie.setLayoutManager(layoutManager);
        recyclerVie.setHasFixedSize(true);
        AdapeterBanco adapeterBanco = new AdapeterBanco(list, dialog);

        recyclerVie.setAdapter(adapeterBanco);
        buscabanco.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().isEmpty()){

                    AdapeterBanco adapeterBanco = new AdapeterBanco(list,dialog);
                    recyclerVie.setAdapter(adapeterBanco);
                }else{
                    listbanco.clear();
                    for(int j=0;j<list.size();j++){
                        if(list.get(j).getName().toLowerCase().contains(charSequence.toString().toLowerCase())){
                            listbanco.add(list.get(j));

                        }
                        AdapeterBanco adapeterBanco = new AdapeterBanco(listbanco,dialog);
                        recyclerVie.setAdapter(adapeterBanco);
                    }

                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }

    public void showdialogcidade(Context context,List<String> list,Deleate deleate){
        final Dialog  dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.modal_cidade_fragment);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations =R.style.Dialoganimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

         RecyclerView recyclerView;
         ImageView xcidade;
         EditText buscacidade;
         List<String> listclone = new ArrayList<>();
         Button button ;

        recyclerView = dialog.findViewById(R.id.recycidade);
        buscacidade  = dialog.findViewById(R.id.buscacidade);
        xcidade      = dialog.findViewById(R.id.xcidade);
        button       = dialog.findViewById(R.id.buton_cidade);

        xcidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.onBackPressed();

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleate.onDismiss();
                dialog.onBackPressed();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);

        recyclerView.setLayoutManager(layoutManager);
        Adapeter_cidade adapeter_cidade = new Adapeter_cidade(list,deleate, dialog);
        recyclerView.setAdapter(adapeter_cidade);

        buscacidade.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.toString().isEmpty()){
                    Adapeter_cidade adapeterCidade = new Adapeter_cidade(list,deleate,dialog);
                    recyclerView.setAdapter(adapeterCidade);

                }else {
                    listclone.clear();
                    for (int j =0;j<list.size();j++){
                        if(list.get(j).toLowerCase().contains(charSequence.toString().toLowerCase())){
                            listclone.add(list.get(j));
                        }

                    }
                    Adapeter_cidade adapeterCidade = new Adapeter_cidade(listclone,deleate,dialog);
                    recyclerView.setAdapter(adapeterCidade);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    public  void showdialoguf(Context context, List<String>list, Deleate deleate){

        final Dialog  dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.modal_uf_fragment);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations =R.style.Dialoganimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        RecyclerView recyclerView;
        EditText buscauf;
        Button button;


        List<String>listclone = new ArrayList<>();
        ImageView xuf;


        recyclerView = dialog.findViewById(R.id.recyuf);
        buscauf      = dialog.findViewById(R.id.buscauf);
        xuf          = dialog.findViewById(R.id.xuf);
        button       = dialog.findViewById(R.id.buton_uf_selecionar);

        xuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.onBackPressed();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        Adapeter_uf adapeter_uf = new Adapeter_uf(list,dialog,deleate);
        recyclerView.setAdapter(adapeter_uf);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.onBackPressed();
                deleate.onDismiss();
            }
        });

        buscauf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.toString().isEmpty()){
                    Adapeter_uf adapeterUf  = new Adapeter_uf(list,dialog,deleate);
                    recyclerView.setAdapter(adapeterUf);
                }else{
                    Log.d("LEtra",charSequence.toString());
                    listclone.clear();
                    for(int j = 0;j <list.size() ; j++){
                        if(list.get(j).toLowerCase().contains(charSequence.toString().toLowerCase())){
                            listclone.add(list.get(j));
                        }

                        Adapeter_uf adapeter_uf1 = new Adapeter_uf(listclone,dialog,deleate);
                        recyclerView.setAdapter(adapeter_uf1);
                    }


                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}
