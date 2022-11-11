package com.rafa.empresa.Modais;

public class Contato {
    private String uudi;
    private String username;
    private String ultima_mensagem;
    private long tempo_ultima_hora;

    public String getUudi() {
        return uudi;
    }

    public void setUudi(String uudi) {
        this.uudi = uudi;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUltima_mensagem() {
        return ultima_mensagem;
    }

    public void setUltima_mensagem(String ultima_mensagem) {
        this.ultima_mensagem = ultima_mensagem;
    }

    public long getTempo_ultima_hora() {
        return tempo_ultima_hora;
    }

    public void setTempo_ultima_hora(long tempo_ultima_hora) {
        this.tempo_ultima_hora = tempo_ultima_hora;
    }
}
