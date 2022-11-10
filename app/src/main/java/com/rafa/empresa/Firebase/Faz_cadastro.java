package com.rafa.empresa.Firebase;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Faz_cadastro {

    public  void  faz_cadastro(Context context,EditText email, EditText senha){

        String email_cap = email.getText().toString();
        String senha_cap     = senha.getText().toString();

        if(!email_cap.isEmpty() || !senha_cap.isEmpty()){

        }else{
            Toast.makeText(context,"Por favor , prenchas os campos", Toast.LENGTH_SHORT).show();
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email_cap, senha_cap).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d("Firebase", task.getResult().getUser().getUid());
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("Firebase", e.getMessage());
                    }
                });

    }
}
