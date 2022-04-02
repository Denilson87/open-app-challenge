package com.example.openmrs_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FormLogin extends AppCompatActivity {

    public TextView telaCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        getSupportActionBar().hide();
    }
    private void IniciarComponents(){
        telaCadastro = findViewById(R.id.telaCadastro);
    }
}