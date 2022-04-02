package com.example.openmrs_app;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FormLogin extends AppCompatActivity {

    public TextView tela_Cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        getSupportActionBar().hide();
    }
    @SuppressLint("WrongViewCast")
    private void IniciarComponents(){
        tela_Cadastro = findViewById(R.id.tela_Cadastro);
    }
}