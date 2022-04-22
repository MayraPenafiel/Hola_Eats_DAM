package com.proyecto.holaeats.modelo;

public class CarritoCompras {
    private String id_carrito;
    private String id_producto;
    private String nombre;
    private int cantidad;
    private Double precio;
    private String imagen;

    public CarritoCompras(String id_carrito, String id_producto, String nombre, int cantidad, Double precio, String imagen) {
        this.id_carrito = id_carrito;
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.imagen = imagen;
    }

    public CarritoCompras() {
    }

    public String getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(String id_carrito) {
        this.id_carrito = id_carrito;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
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
