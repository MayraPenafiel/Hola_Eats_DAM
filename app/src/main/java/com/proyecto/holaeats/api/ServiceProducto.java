package com.proyecto.holaeats.api;


import com.proyecto.holaeats.modelo.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceProducto {
    @GET("productos")
    Call<List<Producto>>productos();
    @GET("listarProducto?categoria=Entradas%20Tiki")
    Call<List<Producto>>getCartegoria();
    @GET("listarProducto?categoria=Tiki%20House")
    Call<List<Producto>>getCartegoria1();
    @GET("listarProducto?categoria=Tiki%20Fuertes")
    Call<List<Producto>>getCartegoria2();

    @GET("listarProducto?categoria=Tiki%20Tradicionales")
    Call<List<Producto>>getCartegoria3();
    @GET("listarProducto?categoria=Sopas%20Tiki")
    Call<List<Producto>>getCartegoria4();

}

