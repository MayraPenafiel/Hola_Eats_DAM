package com.proyecto.holaeats.api;

import java.util.List;
import com.proyecto.holaeats.modelo.Persona;
import com.proyecto.holaeats.modelo.ResponseClass;

import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServicePersona {
    //@GET("listar")
    //Call<List<Persona>> getPersonas();

    @PUT("/addUser")
    Call<ResponseClass> addUser(@Body Persona responseRegisterClass);


    @POST("/getUser")
    Call<ResponseClass> getUser(@Body Persona responseRegisterClass);
}






