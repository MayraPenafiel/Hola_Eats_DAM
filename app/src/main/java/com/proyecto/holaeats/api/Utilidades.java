package com.proyecto.holaeats.api;

public class Utilidades {

    public static final String TABLA_CARRITO="carrito";
    public static final String CREAR_TABLA_CARRITO="CREATE TABLE " +
            ""+TABLA_CARRITO+" ("+ "id_producto INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "nombre TEXT," +
            "cantidad INTEGER," +
            "precio double," +
            "imagen TEXT)";

}
