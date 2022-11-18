package com.rafa.empresa.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafa.empresa.Modais.ParteCadastro.usuarios;
import com.rafa.empresa.R;
import com.rafa.empresa.View.Activys.Chat_activyt;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Listi_contatos extends RecyclerView.Adapter<Adapter_Listi_contatos.Myviewholdercontatos> {
     List<usuarios> usuariosList = new ArrayList<>();
     usuarios usuarios1 ;
     Context context;


    public Adapter_Listi_contatos(List<usuarios> usuariosList, Context context) {
        this.usuariosList = usuariosList;
        this.context = context;
    }

    @NonNull
    @Override
    public Myviewholdercontatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_contatos,parent,false);
        return new Myviewholdercontatos(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Myviewholdercontatos holder, int position) {

        holder.nome.setText(usuariosList.get(position).getUsername());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 usuarios1 = new usuarios(usuariosList.get(position).getUsername(),usuariosList.get(position).getUserid());
                Intent intent = new Intent (context, Chat_activyt.class);
                intent.putExtra("usersname",usuarios1.getUsername());
                intent.putExtra("userid",usuarios1.getUserid());
                context.startActivity(intent);

            }
        });


    }


    @Override
    public int getItemCount() {
        return usuariosList.size();
    }

    public  class  Myviewholdercontatos extends RecyclerView.ViewHolder {
        View view;
        TextView nome;
        public Myviewholdercontatos(@NonNull View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.view9);
            nome = itemView.findViewById(R.id.nomeuser);
        }
    }
}
