package com.example.openmrs_app.api;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface restService {

        //consultar patient no webservice openMRS
        @GET("{results}/json/")
        Call<patient>searchPatient(@Path("/patient?q=Marcos&v=default&limit=7") String patient);
}


