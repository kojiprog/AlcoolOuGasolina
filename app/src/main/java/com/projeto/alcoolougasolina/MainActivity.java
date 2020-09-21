package com.projeto.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool     = findViewById(R.id.editAlcool);
        editPrecoGasolina   = findViewById(R.id.editGasolina);
        textResultado       =findViewById(R.id.textResultado);


    }


    public void calcularPreco(View view) {

//        recupera valores digitados
        String precoAlcool      = editPrecoAlcool.getText().toString();
        String precoGasolina    = editPrecoGasolina.getText().toString();

//        Validar os campos digitados
        Boolean camposValidados = validarCampo(precoAlcool, precoGasolina);
    if (camposValidados){

        double valorAlcool      = Double.parseDouble(precoAlcool);
        double valorGasolina    = Double.parseDouble(precoGasolina);

        if ((valorAlcool / valorGasolina) >= 0.7){
            textResultado.setText("É melhor usar gasolina");
        } else {
            textResultado.setText("É melhor usar Alcool");
        }


    }else {
        textResultado.setText("Por favor, preencha os preços corretamente.");
    }

    }

    public Boolean validarCampo(String pAlcool, String pGasolina){

    Boolean camposValidados = true;

    if (pAlcool == null || pAlcool.equals("")){
        camposValidados = false;

    }else if (pGasolina == null || pGasolina.equals("")) {
        camposValidados = false;

    }
    return camposValidados;

    }

}