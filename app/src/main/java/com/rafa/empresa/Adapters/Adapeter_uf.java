package com.rafa.empresa.Adapters;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.recyclerview.widget.RecyclerView;

import com.rafa.empresa.Interfaces.Deleate;
import com.rafa.empresa.View.Activys.Endereco_pessoal;
import com.rafa.empresa.View.Dialog.Modal_uf;
import com.rafa.empresa.R;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;

public class Adapeter_uf extends RecyclerView.Adapter<Adapeter_uf.Myviewholder> {

    private List<String> list = new ArrayList<>();
    private Dialog modal_uf;
    private Deleate deleate;
    int simgle =-1;

    public Adapeter_uf(List<String> list, Dialog modal_uf, Deleate deleate) {
        this.list = list;
        this.modal_uf = modal_uf;
        this.deleate = deleate;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ufs,parent,false);

        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {

        holder.uf.setText(list.get(position));
        if(simgle == position){

            holder.uf.setTextColor(Color.parseColor("#20A7B4"));
            holder.constraints.setBackgroundColor(Color.parseColor("#B7131B22"));

        }else {
            holder.uf.setTextColor(Color.WHITE);
            holder.constraints.setBackgroundColor(Color.parseColor("#FF131B22"));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class Myviewholder extends RecyclerView.ViewHolder {
        private TextView uf;
        private ConstraintLayout constraints;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);

            uf =itemView.findViewById(R.id.textoouf);
            constraints = itemView.findViewById(R.id.ufcontrain);
            constraints.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setseleciona(getAdapterPosition());
                    Endereco_pessoal.Ufselecionada = uf.getText().toString();
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
