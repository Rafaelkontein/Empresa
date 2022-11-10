package com.rafa.empresa.Uteis;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Ouvintes {

    public void ouvinteDadosPagamentos(EditText agencia, EditText conta){

        agencia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2 ==4){
                    conta.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


    public void ouvindeDados(EditText nome, EditText sobrenome, EditText cpf, EditText email, EditText confirma, EditText celular, CheckBox checkBox){
        GradientDrawable nomecor = (GradientDrawable) nome.getBackground();
        nomecor.mutate();

        // capturando cores do stroke

        GradientDrawable sobrenomecor = (GradientDrawable) sobrenome.getBackground();
        sobrenomecor.mutate();


        GradientDrawable cpfcor = (GradientDrawable) cpf.getBackground();
        cpfcor.mutate();

        GradientDrawable emailcor = (GradientDrawable) email.getBackground();
        cpfcor.mutate();

        GradientDrawable confirmaemailcor = (GradientDrawable) confirma.getBackground();
        cpfcor.mutate();

        GradientDrawable Celulara = (GradientDrawable) celular.getBackground();
        Celulara.mutate();


        nome.addTextChangedListener(new TextWatcher() {
            @Override
            public void  beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2>0){
                    nomecor.setStroke(3,Color.parseColor("#20A7B4"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        sobrenome.addTextChangedListener(new TextWatcher() {
            @Override
            public void  beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i1>0){
                    sobrenomecor.setStroke(3,Color.parseColor("#20A7B4"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        cpf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i1 >= 14){
                    cpfcor.setStroke(3,Color.parseColor("#20A7B4"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i1>0){
                    emailcor.setStroke(3,Color.parseColor("#20A7B4"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        confirma.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i1>0){
                    confirmaemailcor.setStroke(3,Color.parseColor("#20A7B4"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        celular.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i1>=14){
                    Celulara.setStroke(3,Color.parseColor("#20A7B4"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischeck) {
                if(ischeck){
                    checkBox.setTextColor(Color.WHITE);
                }else {
                    checkBox.setTextColor(Color.RED);
                }
            }
        });

    }

}
