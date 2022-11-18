package com.rafa.empresa.Adapters;

import android.app.Dialog;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rafa.empresa.Modais.ParteCadastro.Banco;
import com.rafa.empresa.View.Activys.Dados_pagamento;
import com.rafa.empresa.R;

import java.util.List;

public class AdapeterBanco  extends RecyclerView.Adapter<AdapeterBanco.Myviewholderr> {

    List <Banco> list ;
    Dialog dialog;
    int cormuda = -1;


    public AdapeterBanco(List<Banco> list, Dialog dialog1) {
        this.list = list;
        this.dialog = dialog1;
    }

    @NonNull
    @Override
    public Myviewholderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.bancos,parent,false);

        return new Myviewholderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholderr holder, int position) {
        if(list.get(position).getName().contains("BCO")){
            holder.bancoo.setText(list.get(position).getName().toUpperCase().replace("BCO","Banco"));
        }else{
            holder.bancoo.setText(list.get(position).getName());
        }

        if(cormuda ==position){
            holder.bancoo.setTextColor(Color.parseColor("#20A7B4"));
            holder.constraintLayout.setBackgroundColor(Color.parseColor("#B7131B22"));
        }else{
            holder.bancoo.setTextColor(Color.WHITE);
            holder.constraintLayout.setBackgroundColor(Color.parseColor("#FF131B22"));
        }

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myviewholderr extends RecyclerView.ViewHolder {
        TextView bancoo ;
        ConstraintLayout constraintLayout ;
        public Myviewholderr(@NonNull View itemView) {
            super(itemView);
            bancoo = itemView.findViewById(R.id.textbancoo);
            constraintLayout = itemView.findViewById(R.id.contraintbanco);

            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setseleciona(getAdapterPosition());
                    Dados_pagamento.banco_selecionado = bancoo.getText().toString();
                }
            });
        }
    }

    private void setseleciona(int adapterPosition) {
        if(adapterPosition == RecyclerView.NO_POSITION)
            return;
        notifyItemChanged(cormuda);
        cormuda = adapterPosition;
        notifyItemChanged(cormuda);


    }


}
