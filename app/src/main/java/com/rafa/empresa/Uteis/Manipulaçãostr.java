package com.rafa.empresa.Uteis;

import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class Manipulaçãostr {



    public void  Maskcpf(EditText editText){
        SimpleMaskFormatter simpleMaskFormatter = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher maskTextWatcher = new MaskTextWatcher(editText, simpleMaskFormatter);

        editText.addTextChangedListener(maskTextWatcher);

    }

    public void Maskcel(EditText editText){

        SimpleMaskFormatter simpleMaskFormatter= new SimpleMaskFormatter("(NN)N NNNN-NNNN");
        MaskTextWatcher maskTextWatcher = new MaskTextWatcher(editText,simpleMaskFormatter);
        editText.addTextChangedListener(maskTextWatcher);

    }

    public void Maskcep(EditText editText){
        SimpleMaskFormatter simpleMaskFormatter = new SimpleMaskFormatter("NNNNN-NNN");
        MaskTextWatcher maskTextWatcher = new MaskTextWatcher(editText, simpleMaskFormatter);
        editText.addTextChangedListener(maskTextWatcher);
    }
}
