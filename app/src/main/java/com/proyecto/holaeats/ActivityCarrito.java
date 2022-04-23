package com.proyecto.holaeats;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.proyecto.holaeats.adaptadores.AdaptadorCarrito;
import com.proyecto.holaeats.api.Apis;
import com.proyecto.holaeats.api.SQLITEBase;
import com.proyecto.holaeats.api.ServiceFactura;
import com.proyecto.holaeats.api.ServicePersona;
import com.proyecto.holaeats.api.Utilidades;
import com.proyecto.holaeats.modelo.CarritoCompras;
import com.proyecto.holaeats.modelo.FacturaDetalle;
import com.proyecto.holaeats.modelo.FacturaEnc;
import com.proyecto.holaeats.modelo.Persona;
import com.proyecto.holaeats.modelo.Producto;
import com.proyecto.holaeats.modelo.ResponseClass;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivityCarrito extends AppCompatActivity {
     SQLITEBase sqliteBase;
   AdaptadorCarrito adaptadorCarrito;
    RecyclerView recyclerView;
   ArrayList<CarritoCompras> carritoCompras ;
    TextView txtcantidad ,txtnombre,txtidplato,txtprecio,txtidcarrito,txtidproducto;

    ImageView carritoimagen;
    Button btnsiguinte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_pedidos);
        txtidplato=findViewById(R.id.textidPlaqtoCarrito);
        txtnombre=findViewById(R.id.txtcarritonombreplato);
        txtcantidad=findViewById(R.id.txtprecioCarrito);
        txtprecio=findViewById(R.id.txtprecioCarrito);
        txtidcarrito=findViewById(R.id.txtidcarrito);
        txtidplato=findViewById(R.id.textidPlaqtoCarrito);
        carritoimagen=findViewById(R.id.imagenCarrito);
        recyclerView=findViewById(R.id.itemsCarrito);
        btnsiguinte=findViewById(R.id.botonContinuarCarrito);



        //carritoCompras.add(CarritoCompras("","",null,null,null));
        sqliteBase=new SQLITEBase(getApplicationContext(),"carrito_base",null,3);
        carritoCompras=new ArrayList<>();
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
         traerdatos();
        adaptadorCarrito= new AdaptadorCarrito(this,carritoCompras);
        recyclerView.setAdapter(adaptadorCarrito);



    }
    public void traerdatos() {
        SQLiteDatabase db = sqliteBase.getReadableDatabase();
        CarritoCompras compras = null;
        // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_CARRITO, null);

        while (cursor.moveToNext()) {
            CarritoCompras c = new CarritoCompras();
            c.setId_producto(cursor.getString(1));
            c.setNombre(cursor.getString(2));
            c.setCantidad(cursor.getInt(3));
            c.setPrecio(cursor.getDouble(4));
            c.setImagen(cursor.getString(5));
            carritoCompras.add(c);

        }

    }
    public void grabarApi() {
        Producto p = new Producto();
        btnsiguinte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }





}