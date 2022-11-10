package com.rafa.empresa.View.Dialog;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.rafa.empresa.Adapters.Adapeter_uf;
import com.rafa.empresa.Interfaces.Deleate;
import com.rafa.empresa.R;

import java.util.ArrayList;
import java.util.List;

public class Modal_uf extends Fragment {


  /*  private RecyclerView recyclerView;
    private EditText buscauf;
    private List<String> list = new ArrayList<>();
    private List<String>listclone = new ArrayList<>();
    private ImageView xuf;
    public Deleate deleate;

    public Modal_uf() {

    }


    public static Modal_uf newInstance() {
        return new Modal_uf();
    }

    public Modal_uf(List<String> list) {
        this.list = list;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.modal_uf_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyuf);
        buscauf      = view.findViewById(R.id.buscauf);
        xuf          = view.findViewById(R.id.xuf);

        xuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        Adapeter_uf adapeter_uf = new Adapeter_uf(list,Modal_uf.this,deleate);
        recyclerView.setAdapter(adapeter_uf);
        buscauf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.toString().isEmpty()){
                    Adapeter_uf adapeterUf  = new Adapeter_uf(list,Modal_uf.this,deleate);
                    recyclerView.setAdapter(adapeterUf);
                }else{
                    Log.d("LEtra",charSequence.toString());
                    listclone.clear();
                    for(int j = 0;j <list.size() ; j++){
                        if(list.get(j).toLowerCase().contains(charSequence.toString().toLowerCase())){
                            listclone.add(list.get(j));
                        }

                        Adapeter_uf adapeter_uf1 = new Adapeter_uf(listclone,Modal_uf.this,deleate);
                        recyclerView.setAdapter(adapeter_uf1);
                    }


                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }*/



}