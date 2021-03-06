package com.example.openmrs_app.activities;

package com.example.openmrs_app;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.openmrs_app.R;
import com.example.openmrs_app.SearchPatient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class rest_service extends AppCompatActivity implements View.OnClickListener {

    private final String URL = "https://mail.ccsaude.org.mz:5458/junho/ws/rest/v1/";
    private Retrofit retrofitCEP;
    private Button btnSearchPatient;
    private TextInputEditText txtIdentificador;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPerson = findViewById(R.id.txtPerson);
        btnSearchPatient = findViewById(R.id.btnSearchPatient);
        progressBar = findViewById(R.id.ProgressBar);
        //configurando como invisível
        progressBar.setVisibility(View.GONE);
        //configura os recursos do retrofit
        retrofitPatient = new Retrofit.Builder()
                .baseUrl(URL)                                       //endereço do webservice
                .addConverterFactory(GsonConverterFactory.create()) //conversor
                .build();
        btnSearchPatient.setOnClickListener(this);
    }

    private Boolean validarCampos() {

        Boolean status = true;
        String patient = txtPatient.getText().toString().trim();

        if (id.isEmpty()) {
            txtPatient.setError("Digite um codigo ou nome válido");
            status = false;
        }
        return status;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSearchPatient:
                if (validarCampos()) {
                    esconderTeclado();
                    SearchPatient();
                }
                break;
        }
    }

    private void esconderTeclado() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void pesquisarPaciente() {
        String Patient = txtNome.getText().toString().trim();
        //instanciando a interface
        rest_service rest_service = retrofitCEP.create(rest_service.class);
        //passando os dados para consulta
        Call<Patient> call = rest_service.consultarPatient(Patient);
        //exibindo a progressbar
        progressBar.setVisibility(View.VISIBLE);
        //colocando a requisição na fila para execução
        call.enqueue(new Callback<result>() {
            @Override
            public void onResponse(Call<result> call, Response<result> response) {
                if (response.isSuccessful()) {
                    SearchPatient patient = response.body();
                    display.setText(patient.getDisply());
                    birthdate.setText(patient.getBithday());
                    gender.setText(patient.getGender());
                    attributes.display.setText(patient.getUf());
                    imageurl.setImageUrl(patient.getImage());
                    Toast.makeText(getApplicationContext(), "Paciente consultado com sucesso", Toast.LENGTH_LONG).show();
                    //escondendo a progressbar after succeess response
                    progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<result> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro ao consultar o paciente. Erro: " + t.getMessage(), Toast.LENGTH_LONG).show();
                //escondendo a progressbar
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}

