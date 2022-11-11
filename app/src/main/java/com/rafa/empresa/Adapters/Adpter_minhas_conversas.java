package com.rafa.empresa.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafa.empresa.Modais.Contato;
import com.rafa.empresa.R;

import java.util.ArrayList;
import java.util.List;

public class Adpter_minhas_conversas extends RecyclerView.Adapter<Adpter_minhas_conversas.Myviewholderrcontatos> {
     List<Contato> contatoList = new ArrayList<>();

    public Adpter_minhas_conversas(List<Contato> contatoList) {
        this.contatoList = contatoList;
    }

    @NonNull
    @Override
    public Myviewholderrcontatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_conversas,parent,false);

        return new Myviewholderrcontatos(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Myviewholderrcontatos holder, int position) {

        holder.ultimaMensagem.setText(contatoList.get(position).getUltima_mensagem());
        holder.nomeusuario.setText(contatoList.get(position).getUsername());

    }

    @Override
    public int getItemCount() {
        return contatoList.size();
    }

    public class Myviewholderrcontatos extends RecyclerView.ViewHolder {

        TextView nomeusuario;
        TextView ultimaMensagem;
        public Myviewholderrcontatos(@NonNull View itemView) {
            super(itemView);

            nomeusuario = itemView.findViewById(R.id.nome_deuser_conversa);
            ultimaMensagem = itemView.findViewById(R.id.ultima_mensagem);
        }
    }
}
