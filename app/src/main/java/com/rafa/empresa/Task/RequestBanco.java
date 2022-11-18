package com.rafa.empresa.Task;

import android.content.Context;
import android.util.Log;

import com.rafa.empresa.Interfaces.Deleate;
import com.rafa.empresa.Interfaces.Isyncserveser;
import com.rafa.empresa.Modais.ParteCadastro.Banco;
import com.rafa.empresa.View.Dialog.Showdialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestBanco {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(" https://brasilapi.com.br/").
            addConverterFactory(GsonConverterFactory.create()).build();
    public void requestbanco(Context context, Deleate activity){
        Isyncserveser isyncserveser = retrofit.create(Isyncserveser.class);

        Call<List<Banco>> call = isyncserveser.getbanco();

        call.enqueue(new Callback<List<Banco>>() {
            @Override
            public void onResponse(Call<List<Banco>> call, Response<List<Banco>> response) {
                if(response.isSuccessful()){
                    List <Banco> banco1 = new ArrayList<>();
                    banco1 = response.body();
                    for (int i=0;i <banco1.size();i++){
                        banco1.get(i).getName();
                    }
                    Showdialog showdialog = new Showdialog();
                    showdialog.showdialgbanco(context,banco1,activity);
                    Log.d("ADAADDA","aadad");
                }else {
                    Log.d("BBBBBB","BBBBB");
                }
            }
            @Override
            public void onFailure(Call<List<Banco>> call, Throwable t) {

            }
        });
    }
}
