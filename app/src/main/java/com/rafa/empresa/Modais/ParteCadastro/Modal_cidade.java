package com.rafa.empresa.Modais.ParteCadastro;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.rafa.empresa.Adapters.Adapeter_cidade;
import com.rafa.empresa.Interfaces.Deleate;
import com.rafa.empresa.R;

import java.util.ArrayList;
import java.util.List;

public class Modal_cidade extends Fragment {


  /*  private RecyclerView recyclerView;
    public Deleate dalete;
    public ImageView xcidade;
    private EditText buscacidade;
    private List <String> list = new ArrayList<>();
    private List<String> listclone = new ArrayList<>();
    public Modal_cidade() {

    }

    public static Modal_cidade newInstance() {
        return new Modal_cidade();
    }

    public Modal_cidade(List<String> list) {
        this.list = list;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.modal_cidade_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycidade);
        buscacidade  = view.findViewById(R.id.buscacidade);
        xcidade      = view.findViewById(R.id.xcidade);

        xcidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();

            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        Adapeter_cidade adapeter_cidade = new Adapeter_cidade(list,dalete,Modal_cidade.this);
        recyclerView.setAdapter(adapeter_cidade);

        buscacidade.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.toString().isEmpty()){
                    Adapeter_cidade adapeterCidade = new Adapeter_cidade(list,dalete,Modal_cidade.this);
                    recyclerView.setAdapter(adapeterCidade);

                }else {
                    listclone.clear();
                    for (int j =0;j<list.size();j++){
                        if(list.get(j).toLowerCase().contains(charSequence.toString().toLowerCase())){
                            listclone.add(list.get(j));
                        }

                    }
                    Adapeter_cidade adapeterCidade = new Adapeter_cidade(listclone,dalete,Modal_cidade.this);
                    recyclerView.setAdapter(adapeterCidade);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }*/



}