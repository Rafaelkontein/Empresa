package com.rafa.empresa.View.Activys;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.rafa.empresa.Adapters.Adapter_chat;
import com.rafa.empresa.Modais.Chat.Contato;
import com.rafa.empresa.Modais.Chat.Mensagem;
import com.rafa.empresa.Modais.ParteCadastro.usuarios;
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
    usuarios me;
    Adapter_chat adapter_chat;



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

         adapter_chat = new Adapter_chat(mensagemList );

        FirebaseFirestore.getInstance().collection("/users").
                document(FirebaseAuth.getInstance().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                         me = documentSnapshot.toObject(usuarios.class);
                         fetMessege();


                    }
                });

        recyclerView.setAdapter(adapter_chat);



        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tocou","");
                evniamensagem();
            }
        });
    }



    private void fetMessege() {

        if(me!= null){

            String useratual =me.getUserid();
            String destinatario =usuariosname;

            FirebaseFirestore.getInstance().collection("/conversas").document(useratual).collection(destinatario).
                    orderBy("tempodamensagem", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                   List<DocumentChange> documentChanges = value.getDocumentChanges();


                   if(documentChanges!=null){

                       for (DocumentChange doc:documentChanges) {
                           if(doc.getType()==DocumentChange.Type.ADDED){

                              Mensagem mensagem = doc.getDocument().toObject(Mensagem.class);
                              Log.d("mensage",mensagem.getTextomensagem());
                              mensagemList.add(mensagem);
                              adapter_chat.notifyDataSetChanged();

                           }
                       }

                   }
                }
            });

        }
    }

    private void evniamensagem() {

        String cap = editMensagem.getText().toString();
        editMensagem.setText("");

        String useratual = FirebaseAuth.getInstance().getUid();
        Long tempo =System.currentTimeMillis();

        Mensagem mensagem = new Mensagem(cap,tempo,useratual,usuariosname);
        if(!mensagem.getTextomensagem().isEmpty()){
            FirebaseFirestore.getInstance().collection("/conversas").document(useratual).collection(usuariosname).add(mensagem).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Log.d("SucessoChat",documentReference.getId());

                    Contato contato = new Contato();
                    contato.setUltima_mensagem(mensagem.getTextomensagem());
                    contato.setUudi(usuariosname);
                    contato.setUsername(usuarioid);
                    contato.setTempo_ultima_hora(mensagem.getTempodamensagem());

                    FirebaseFirestore.getInstance().collection("/ultima_mensagem")
                            .document(useratual).collection("contatos")
                            .document(usuariosname).set(contato);



                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("failChat","");
                }
            });

            FirebaseFirestore.getInstance().collection("/conversas").document(usuariosname).collection(useratual).add(mensagem).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Log.d("SucessoChat","");

                    Contato contato = new Contato();
                    contato.setUltima_mensagem(mensagem.getTextomensagem());
                    contato.setUsername(usuarioid);
                    contato.setUudi(usuariosname);
                    contato.setTempo_ultima_hora(mensagem.getTempodamensagem());

                    FirebaseFirestore.getInstance().collection("/ultima_mensagem")
                            .document(usuariosname).collection("contatos")
                            .document(useratual).set(contato);
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