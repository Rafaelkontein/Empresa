package com.rafa.empresa.Firebase;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rafa.empresa.Modais.usuarios;

public class Faz_cadastro {

    public  void  faz_cadastro(Context context,String email, String senha,String nome){



        if(!email.isEmpty() || !senha.isEmpty()){
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Log.d("FirebaseSucesso", task.getResult().getUser().getUid());

                                String id_usuario = FirebaseAuth.getInstance().getUid();
                                usuarios usuarios = new usuarios(id_usuario,nome);

                                FirebaseFirestore.getInstance().collection("users" ).document(id_usuario).set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Log.d("Sucesso user","");
                                            }
                                        })
                                   .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.d("fail user",e.getMessage());
                                            }
                                        });
                            }

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("Firebase", e.getMessage());
                        }
                    });

        }else{
            Toast.makeText(context,"Por favor , prenchas os campos", Toast.LENGTH_SHORT).show();
        }



    }
}
