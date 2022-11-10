package com.rafa.empresa.View.Activys;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.rafa.empresa.Uteis.Manipulaçãostr;
import com.rafa.empresa.R;
import com.rafa.empresa.Uteis.Ouvintes;

public class Dados_pessoais extends AppCompatActivity {
    private TextView datanacimento;
    private EditText nome;
    private EditText sobrenome;
    private EditText cpf;
    private EditText email;
    private EditText confirmaemail;
    private EditText Celular;
    private CheckBox checkBox;
    private DatePickerDialog datePicker;
    private Calendar calendar;
    private Button btnconfitunar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_pessoais);

        datanacimento = findViewById(R.id.datadenacimento);
        nome          = findViewById(R.id.nome);
        sobrenome     = findViewById(R.id.sobrenome);
        cpf           = findViewById(R.id.cpf);
        email         = findViewById(R.id.email);
        confirmaemail = findViewById(R.id.confirmaemail);
        Celular       = findViewById(R.id.celular);
        checkBox      = findViewById(R.id.checkBox);
        btnconfitunar = findViewById(R.id.btnconfitunar);

        // data picker

        datanacimento.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                final  int dia = calendar.get(Calendar.DAY_OF_MONTH);
                final  int mes = calendar.get(Calendar.MONTH);
                final  int ano = calendar.get(Calendar.YEAR);
                datePicker = new DatePickerDialog(Dados_pessoais.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String ano = String.valueOf(i);
                        if(i <1000){
                            ano = "20"+i;
                        }
                        datanacimento.setText(i2 +"/"+(i1+1)+"/"+ano);
                    }
                },dia, mes, ano);
                datePicker.getDatePicker().setMinDate(calendar.getTimeInMillis());
                final Calendar calendar2 = Calendar.getInstance();
                //Set Minimum date of calendar
                calendar2.set(1940, 1, 1);
                datePicker.getDatePicker().setMinDate(calendar2.getTimeInMillis());
                datePicker.show();
                datePicker.show();

            }

        });
        // fim do datapicker
        // mascaras
        Manipulaçãostr manipulaçãostr = new Manipulaçãostr();
        Ouvintes ouvintes = new Ouvintes();

        ouvintes.ouvindeDados( nome,  sobrenome, cpf,  email, confirmaemail, Celular,checkBox);
        manipulaçãostr.Maskcpf(cpf);
        manipulaçãostr.Maskcel(Celular);
        GradientDrawable nomecor = (GradientDrawable) nome.getBackground();
        nomecor.mutate();

        // capturando cores do stroke

        GradientDrawable sobrenomecor = (GradientDrawable) sobrenome.getBackground();
        sobrenomecor.mutate();


        GradientDrawable cpfcor = (GradientDrawable) cpf.getBackground();
        cpfcor.mutate();

        GradientDrawable emailcor = (GradientDrawable) email.getBackground();
        cpfcor.mutate();

        GradientDrawable confirmaemailcor = (GradientDrawable) confirmaemail.getBackground();
        cpfcor.mutate();

        GradientDrawable Celulara = (GradientDrawable) Celular.getBackground();
        Celulara.mutate();
        
        GradientDrawable datanacimentoa = (GradientDrawable) datanacimento.getBackground();
        datanacimentoa.mutate();

        // fim das mascara

        btnconfitunar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomecap= nome.getText().toString();
                String sobrenomecap = sobrenome.getText().toString();
                String cpfcap = cpf.getText().toString();
                String emailcap = email.getText().toString();
                String confirmaemailcap= confirmaemail.getText().toString();
                String celcap= Celular.getText().toString();

                if(nomecap.length()>= 3 && sobrenomecap.length() >= 3 && cpfcap.length() >= 10 &&
                        emailcap.equals(confirmaemailcap) && celcap.length() >10   &&
                        confirmaemailcap.contains("@") && confirmaemailcap.contains(".com") &&
                        emailcap.contains("@") && emailcap.contains(".com") && checkBox.isChecked()
                        && !datanacimento.getText().toString().equals("dd/MM/AAAAA")){


                    SharedPreferences prefs;
                    prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor ed = prefs.edit();
                    ed.putString("nomeuser", nomecap);
                    ed.putString("emailuser",emailcap);
                    ed.apply();

                    Intent intent = new Intent(Dados_pessoais.this, Endereco_pessoal.class);
                    startActivity(intent);
                }else{
                    if(datanacimento.getText().toString().equals("dd/MM/AAAAA")){

                        datanacimentoa.setStroke(3,Color.RED);

                    }else {
                        datanacimentoa.setStroke(3,Color.parseColor("#20A7B4"));
                    }
                    if(nomecap.length()<3){
                        nomecor.setStroke(3,Color.RED);
                    }else{
                        nomecor.setStroke(3, Color.parseColor("#20A7B4"));
                    }
                    if(sobrenomecap.length()<3){
                        sobrenomecor.setStroke(3,Color.RED);
                    }else{
                        sobrenomecor.setStroke(3,Color.parseColor("#20A7B4"));
                    }
                    if(cpfcap.length()<14){
                        cpfcor.setStroke(3, Color.RED);
                    }else{
                        cpfcor.setStroke(3,Color.parseColor("#20A7B4"));
                    }
                    if(!emailcap.equals(confirmaemailcap)){
                        confirmaemailcor.setStroke(3,Color.RED);
                        emailcor.setStroke(3,Color.RED);
                    }else{
                        emailcor.setStroke(3,Color.parseColor("#20A7B4"));
                        confirmaemailcor.setStroke(1,Color.parseColor("#20A7B4"));
                    }
                    if(!emailcap.contains("@") && !emailcap.contains(".com")){
                        emailcor.setStroke(3,Color.RED);
                    }else{
                        emailcor.setStroke(3,Color.parseColor("#20A7B4"));
                    }
                    if(celcap.length()<15){
                        Celulara.setStroke(3,Color.RED);
                    }else{
                        Celulara.setStroke(3,Color.parseColor("#20A7B4"));
                    }
                    if(!checkBox.isChecked()){
                        checkBox.setTextColor(Color.RED);
                    }else{
                        checkBox.setTextColor(Color.parseColor("#20A7B4"));
                    }
                }
            }
        });
    }
}