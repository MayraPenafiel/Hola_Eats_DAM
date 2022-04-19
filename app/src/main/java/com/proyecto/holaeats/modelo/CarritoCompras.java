package com.proyecto.holaeats.modelo;

public class CarritoCompras {
    private String nombre;
    private int cantidad;
    private Double precio;
    private String imagen;

    public CarritoCompras(String nombre, int cantidad, Double precio ,String imagen) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.imagen=imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
