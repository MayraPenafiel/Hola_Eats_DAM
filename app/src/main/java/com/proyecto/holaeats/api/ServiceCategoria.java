package com.proyecto.holaeats.api;

import com.proyecto.holaeats.modelo.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceCategoria {
    @GET("listarProducto")
    Call<List<Producto>>getCartegoria();
}
