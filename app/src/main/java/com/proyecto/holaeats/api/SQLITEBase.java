package com.proyecto.holaeats.api;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQLITEBase extends SQLiteOpenHelper {
    private static String DATABASE_NOMBRE= "carrito_base";
    private static int VERSIONDB= 1;

    private static String TABLA_CARRITO= "create table carrito(" +
            "id_producto INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "nombre TEXT," +
            "cantidad INTEGER," +
            "precio double," +
            "imagen TEXT)";


    public SQLITEBase(@Nullable Context context) {
        super(context,DATABASE_NOMBRE , null, VERSIONDB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_CARRITO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase Database, int i, int i1) {
        Database.execSQL(TABLA_CARRITO);

    }
    public boolean CarritoPedidos(String nombre,   String cantidad, String precio,String img){

        SQLiteDatabase base= getWritableDatabase();

        if (base!=null){
            try{

                base.execSQL("INSERT INTO carrito VALUES("+null+",'"+nombre+"',"+cantidad+","+precio+",'"+img+"')");
                base.close();
                return true;
            }catch (SQLiteConstraintException e){
                return false;
            }

        }else{
            return false;
        }
    }

}
