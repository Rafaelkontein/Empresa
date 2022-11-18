package com.rafa.empresa.Interfaces;

import com.rafa.empresa.Modais.ParteCadastro.Banco;
import com.rafa.empresa.Modais.ParteCadastro.CEP;
import com.rafa.empresa.Modais.ParteCadastro.Cidade;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Isyncserveser {

    @GET("{cep}/json/")
    Call<CEP> buscarcep(@Path("cep") String cep);

    @GET("estados/{UF}/municipios")
    Call<List<Cidade>> buscascidade(@Path("UF") String uf);

    @GET("api/banks/v1")
    Call<List<Banco>> getbanco();



}
