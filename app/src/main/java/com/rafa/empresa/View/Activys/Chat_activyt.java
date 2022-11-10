package com.rafa.empresa.View.Activys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rafa.empresa.Adapters.Adapter_chat;
import com.rafa.empresa.Modais.Mensagem;
import com.rafa.empresa.Modais.usuarios;
import com.rafa.empresa.R;

import java.util.ArrayList;
import java.util.List;

public class Chat_activyt extends AppCompatActivity {

    ImageView enviar;
    EditText editMensagem;
    RecyclerView recyclerView;
    List<Mensagem >mensagemList = new ArrayList<>();
    String usuariosname ;
    String usuarioid ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_activyt);

        enviar = findViewById(R.id.enviar);
        editMensagem = findViewById(R.id.editMensagem);
        recyclerView = findViewById(R.id.recychat);

       usuariosname = getIntent().getStringExtra("usersname");
       usuarioid = getIntent().getStringExtra("userid");




        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        String useratual = FirebaseAuth.getInstance().getUid();

        Adapter_chat adapter_chat = new Adapter_chat(mensagemList,useratual );

        recyclerView.setAdapter(adapter_chat);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evniamensagem();
            }
        });
    }

    private void evniamensagem() {

        String cap = editMensagem.getText().toString();
        editMensagem.setText("");

        String useratual = FirebaseAuth.getInstance().getUid();
        Long tempo =System.currentTimeMillis();

        Mensagem mensagem = new Mensagem(cap,tempo,useratual,usuarioid);
        if(!mensagem.getTextomensagem().isEmpty()){
            FirebaseFirestore.getInstance().collection("/conversas").document(useratual).collection(usuarioid).add(mensagem).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Log.d("SucessoChat",documentReference.getId());
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("failChat","");
                }
            });

            FirebaseFirestore.getInstance().collection("/conversas").document(usuarioid).collection(useratual).add(mensagem).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Log.d("SucessoChat","");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("failChat","");
                }
            });
        }
    }


}