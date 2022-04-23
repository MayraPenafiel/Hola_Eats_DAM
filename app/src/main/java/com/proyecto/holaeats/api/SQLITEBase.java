package com.proyecto.holaeats.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

public class SQLITEBase extends SQLiteOpenHelper {



   public SQLITEBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
       super(context, name, factory, version);
   }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_CARRITO);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_FACTURAENC);

    }

    @Override
    public void onUpgrade(SQLiteDatabase Database, int i, int i1) {


        Database.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CARRITO);
        Database.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_FACTURAENC);
        onCreate(Database);


    }

    public Boolean CarritoPedidos(Long id_producto,String nombre, double precio,int cantidad,String imagen)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_producto",id_producto);
        contentValues.put("nombre", nombre);
        contentValues.put("precio", precio);
        contentValues.put("cantidad",cantidad);
        contentValues.put("imagen", imagen);
        long result=DB.insert("carrito", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean informacionPago(String fecha, String pago,String destino,String id_producto,double total)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("fecha", fecha);
        contentValues.put("forma_pago", pago);
        contentValues.put("destino",destino);
        contentValues.put("id_producto", id_producto);
        contentValues.put("total", total);
        long result=DB.insert("factura", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public void noQuery( String noqsl){
        this.getWritableDatabase().execSQL(noqsl);


    }
    public Cursor query(String sql){

        return this.getReadableDatabase().rawQuery(sql,null);


    }
    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from carritoclose", null);
        return cursor;
    }

}
