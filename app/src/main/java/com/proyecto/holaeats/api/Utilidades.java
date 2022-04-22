package com.proyecto.holaeats.api;

public class Utilidades {

    public static final String TABLA_CARRITO="carrito";
    public static final String CREAR_TABLA_CARRITO="CREATE TABLE " +
            ""+TABLA_CARRITO+" ("+ "id_carrito INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "id_producto TEXT,"+
            "nombre TEXT," +
            "cantidad INTEGER," +
            "precio double," +
            "imagen TEXT)";

}
