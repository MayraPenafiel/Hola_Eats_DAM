package com.proyecto.holaeats.modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class FacturaDetalle implements Serializable {
    private Long idDetalle;

    private String cantidad;
    private String precio;

    private Producto producto;


    public FacturaDetalle() {
        super();
    }

    public FacturaDetalle(String tipoPago, String estado) {
        super();
        this.cantidad = tipoPago;
        this.precio = estado;


    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
