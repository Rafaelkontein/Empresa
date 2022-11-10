package com.rafa.empresa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;

public class Foto_de_Perfil extends AppCompatActivity {

    private ImageView foto_de_perfil;
    private Button foto;
    private Button galeria;

    String cuurent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_de_perfil);

        foto_de_perfil = findViewById(R.id.fotodeperfil);
        foto = findViewById(R.id.foto);
        galeria = findViewById(R.id.galeria);

        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galareia = new Intent(Intent.ACTION_GET_CONTENT);
                galareia.setType("image/*");
                startActivityForResult(galareia,2);
                //sdvgadsvghas

            }
        });

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String file ="photo";
                File store= getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                try {
                    File imagefile = File.createTempFile(file,".jpg",store);
                    cuurent = imagefile.getAbsolutePath();
                    Uri uri = FileProvider.getUriForFile(Foto_de_Perfil.this,"com.rafa.myapplication.fileprovider",imagefile);
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                    startActivityForResult(intent,1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode ==RESULT_OK){
            Bitmap bitmap = BitmapFactory.decodeFile(cuurent);
            foto_de_perfil.setImageBitmap(bitmap);

        }
        if(requestCode == 2 && resultCode ==  RESULT_OK){
            Uri galeria =  data.getData();
            try {
                Bitmap galery = MediaStore.Images.Media.getBitmap(this.getContentResolver(),galeria);
                foto_de_perfil.setImageBitmap(galery);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}