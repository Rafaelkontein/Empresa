package com.rafa.empresa.ui.slideshow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.rafa.empresa.Adapters.Adapter_Listi_contatos;
import com.rafa.empresa.Modais.ParteCadastro.usuarios;
import com.rafa.empresa.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

private FragmentSlideshowBinding binding;
    RecyclerView recyclerView;

    List<usuarios > usuariosList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

    binding = FragmentSlideshowBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

       // final TextView textView = binding.textSlideshow;
        //slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        recyclerView =binding.conversas;
        buscacontatos();



        return root;
    }

    private void buscacontatos() {

        FirebaseFirestore.getInstance().collection("/users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
               if(error != null){
                   Log.d("ERRo",error.getMessage());

                   return;

               }

                List<DocumentSnapshot> documentSnapshots = value.getDocuments();

                for (DocumentSnapshot doc :documentSnapshots ) {
                    usuarios usuario = doc.toObject(usuarios.class);

                    Log.d("Users",usuario.getUsername());
                    usuariosList.add(usuario);


                }
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                Adapter_Listi_contatos adapter_listi_contatos = new Adapter_Listi_contatos(usuariosList,getContext());
                recyclerView.setAdapter(adapter_listi_contatos);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}