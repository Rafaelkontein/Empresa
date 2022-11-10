package com.rafa.empresa.Modais;

public class Mensagem {

    private String textomensagem;
    private long tempodamensagem;
    private  String mensagem_user1;
    private String mensagem_user2;

    public Mensagem(String textomensagem, long tempodamensagem, String mensagem_user1, String mensagem_user2) {
        this.textomensagem = textomensagem;
        this.tempodamensagem = tempodamensagem;
        this.mensagem_user1 = mensagem_user1;
        this.mensagem_user2 = mensagem_user2;
    }

    public String getTextomensagem() {
        return textomensagem;
    }

    public void setTextomensagem(String textomensagem) {
        this.textomensagem = textomensagem;
    }

    public long getTempodamensagem() {
        return tempodamensagem;
    }

    public void setTempodamensagem(long tempodamensagem) {
        this.tempodamensagem = tempodamensagem;
    }

    public String getMensagem_user1() {
        return mensagem_user1;
    }

    public void setMensagem_user1(String mensagem_user1) {
        this.mensagem_user1 = mensagem_user1;
    }

    public String getMensagem_user2() {
        return mensagem_user2;
    }

    public void setMensagem_user2(String mensagem_user2) {
        this.mensagem_user2 = mensagem_user2;
    }
}
