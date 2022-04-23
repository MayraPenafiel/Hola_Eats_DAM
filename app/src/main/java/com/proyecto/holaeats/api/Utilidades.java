package com.proyecto.holaeats.api;

public class Utilidades {

    public static final String TABLA_CARRITO="carrito";
    public static final String TABLA_FACTURAENC="factura";
    public static final String TABLA_FACTDETA="factura_detalle";
    public static final String CREAR_TABLA_CARRITO="CREATE TABLE " +
            ""+TABLA_CARRITO+" ("+ "id_carrito INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "id_producto TEXT,"+
            "nombre TEXT," +
            "cantidad INTEGER," +
            "precio double," +
            "imagen TEXT)";
    public static final String CREAR_TABLA_FACTURAENC="CREATE TABLE " +
            ""+TABLA_FACTURAENC+" ("+ "id_factura INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "fecha DATE,"+
            "total DOUBLE," +
            "forma_pago TEXT," +
            "id_Cliente INTEGER)";
    //DATE('now')
    public static final String CREAR_TABLA_FACTURADETA="CREATE TABLE " +
            ""+TABLA_FACTDETA+" ("+ "id_detalle INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "id_producto TEXT,"+
            "cantidad INTEGER," +
            "precio double," +
            "id_enca INTEGER)";

}
