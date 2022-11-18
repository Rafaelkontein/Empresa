package com.rafa.empresa.Modais.ParteCadastro;

public class usuarios {

    private  String userid;
    private String username;
    private  String sobrenome;
    private String data_nacimento;
    private  String cpf;
    private  String email;
    private String celular;
    private  String cep;
    private  String Rua;
    private  String numero;
    private  String bairro;
    private String uf;
    private  String cidade;

    public usuarios(){

    }

    public usuarios(String userid, String username, String sobrenome,
                    String data_nacimento, String cpf, String email, String celular,
                    String cep, String rua, String numero, String bairro, String uf, String cidade) {
        this.userid = userid;
        this.username = username;
        this.sobrenome = sobrenome;
        this.data_nacimento = data_nacimento;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        this.cep = cep;
        Rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.uf = uf;
        this.cidade = cidade;
    }

    public usuarios(String userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getData_nacimento() {
        return data_nacimento;
    }

    public void setData_nacimento(String data_nacimento) {
        this.data_nacimento = data_nacimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
