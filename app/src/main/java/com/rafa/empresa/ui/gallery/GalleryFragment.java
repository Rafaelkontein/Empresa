package com.rafa.empresa.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.rafa.empresa.Adapters.Adpter_minhas_conversas;
import com.rafa.empresa.Modais.Chat.Contato;
import com.rafa.empresa.databinding.FragmentGalleryBinding;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

private FragmentGalleryBinding binding;

    RecyclerView recyclerView;
    List<Contato> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

    binding = FragmentGalleryBinding.inflate(inflater, container, false);


                View root = binding.getRoot();


         recyclerView = binding.recyConversas;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        lista_minhas_Conversas();


        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public  void lista_minhas_Conversas(){

        String udi = FirebaseAuth.getInstance().getUid();
        FirebaseFirestore.getInstance().collection("ultima_mensagem").document(udi).collection("contatos").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                List<DocumentChange > documentChangeList  =value.getDocumentChanges();

                if(documentChangeList!=null){
                    for (DocumentChange doc: documentChangeList) {
                       if( doc.getType() == DocumentChange.Type.ADDED){
                          Contato contato = doc.getDocument().toObject(Contato.class);
                          list.add(contato);

                       }
                    }
                    Adpter_minhas_conversas adpter_minhas_conversas = new Adpter_minhas_conversas(list);

                    recyclerView.setAdapter(adpter_minhas_conversas);
                }
            }
        });

    }
}