package com.rafa.empresa.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.rafa.empresa.Modais.Mensagem;
import com.rafa.empresa.Modais.usuarios;
import com.rafa.empresa.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_chat extends RecyclerView.Adapter<Adapter_chat.MyviewholderChat> {
    List <Mensagem >listmensagem = new ArrayList<>();





    private  final  int tipohum= 1;
    private final  int tipobot2 =2;

    public Adapter_chat(List<Mensagem> listmensagem) {
        this.listmensagem = listmensagem;

    }

    @NonNull
    @Override
    public MyviewholderChat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;

        if(viewType ==tipohum){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mensagem,parent,false);

        }else if(viewType ==tipobot2){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recebendo_mensagem,parent,false);
        }


        return new MyviewholderChat(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyviewholderChat holder, int position) {
        try{
            holder.mensa.setText(listmensagem.get(position).getTextomensagem());

        }catch (Exception e){
            Log.d("Sem","");
        }


    }


    @Override
    public int getItemCount() {
        return listmensagem.size();
    }

    @Override
    public int getItemViewType(int position) {

        String f = FirebaseAuth.getInstance().getUid();



        if (listmensagem.get(position).getMensagem_user1().equals(FirebaseAuth.getInstance().getUid()) ){
            return tipohum;
        }else {
            return tipobot2;
        }




    }

    public  class MyviewholderChat extends RecyclerView.ViewHolder {
        TextView mensa;

        public MyviewholderChat(@NonNull View itemView) {
            super(itemView);
            mensa = itemView.findViewById(R.id.mensagemtexto);
        }
    }
}
