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

import com.rafa.empresa.Interfaces.Deleate;
import com.rafa.empresa.R;
import com.rafa.empresa.View.Activys.Endereco_pessoal;

import java.util.ArrayList;
import java.util.List;

public class Adapeter_cidade  extends RecyclerView.Adapter<Adapeter_cidade.Myviewholdercida> {

    List<String> list = new ArrayList<>();
    public Deleate deleate;
    public Dialog modal_cidade;
    int simgle =-1;

    public Adapeter_cidade(List<String> list, Deleate deleate, Dialog modal_cidade) {
        this.list = list;
        this.deleate = deleate;
        this.modal_cidade = modal_cidade;
    }

    @NonNull
    @Override
    public Myviewholdercida onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.cidadees,parent,false);
        return new Myviewholdercida(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholdercida holder, int position) {
        holder.textocidade.setText(list.get(position));

        if(simgle == position){

            holder.textocidade.setTextColor(Color.parseColor("#20A7B4"));
            holder.constraintLayout.setBackgroundColor(Color.parseColor("#B7131B22"));

        }else {
            holder.textocidade.setTextColor(Color.WHITE);
            holder.constraintLayout.setBackgroundColor(Color.parseColor("#FF131B22"));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myviewholdercida extends RecyclerView.ViewHolder {
        private TextView textocidade;
        private ConstraintLayout constraintLayout;
        public Myviewholdercida(@NonNull View itemView) {

            super(itemView);
            constraintLayout = itemView.findViewById(R.id.constraintcidade);
            textocidade = itemView.findViewById(R.id.texticiaddade);

            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setseleciona(getAdapterPosition());
                    Endereco_pessoal.Cidadeselecionada = textocidade.getText().toString();
                }
            });
        }
    }
    private void setseleciona(int adapterPosition) {
        if(adapterPosition == RecyclerView.NO_POSITION)
            return;
        notifyItemChanged(simgle);
        simgle = adapterPosition;
        notifyItemChanged(simgle);


    }
}
