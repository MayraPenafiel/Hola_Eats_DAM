package com.proyecto.holaeats.modelo;

import java.io.Serializable;

public class Producto implements Serializable {

    private Long id;
    private Byte foto;
    private String categoria;
    private String descripcion;
    private Double precio;
    private Integer stock;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getFoto() {
        return foto;
    }

    public void setFoto(Byte foto) {
        this.foto = foto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Producto() {
    }

    public Producto(Long id, Byte foto, String categoria, String descripcion, Double precio, Integer stock) {
        this.id = id;
        this.foto = foto;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(Byte foto, String categoria, String descripcion, Double precio, Integer stock) {
        this.foto = foto;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }
}
