package com.rafa.empresa.Task;

import android.widget.EditText;
import android.widget.TextView;

import com.rafa.empresa.Interfaces.Isyncserveser;
import com.rafa.empresa.Modais.CEP;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RequestCEP {
    public void Resquestcep(EditText cep, EditText rua , TextView cidade, TextView uf, EditText bairro){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://viacep.com.br/ws/").addConverterFactory(GsonConverterFactory.create()).build();

        String cepp = cep.getText().toString();

        Isyncserveser cepService = retrofit.create( Isyncserveser.class );
        Call<CEP> call = cepService.buscarcep(cepp);

        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if( response.isSuccessful() ){
                    CEP cep = response.body();
                    rua.setText(cep.getLogradouro());
                    cidade.setText(cep.getLocalidade());
                    uf.setText(cep.getUf());
                    bairro.setText(cep.getBairro());
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {

            }
        });



    }
}
