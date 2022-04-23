package com.proyecto.holaeats;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.proyecto.holaeats.adaptadores.AdaptadorCarrito;
import com.proyecto.holaeats.api.SQLITEBase;
import com.proyecto.holaeats.api.Utilidades;
import com.proyecto.holaeats.modelo.CarritoCompras;
import com.proyecto.holaeats.modelo.FacturaEnc;
import com.proyecto.holaeats.modelo.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ActivityCarrito extends AppCompatActivity {
    SQLITEBase sqliteBase;
    public Context context;
    AdaptadorCarrito adaptadorCarrito;
    RecyclerView recyclerView;
    ArrayList<CarritoCompras> carritoCompras ;
    TextView txtcantidad ,txtnombre,txtTotal;
    ImageView carritoimagen;
    Button botoncontinuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_pedidos);
        setTitle("Carrito de Compras");

        txtnombre=findViewById(R.id.txtcarritonombreplato);
        txtcantidad=findViewById(R.id.txtprecioCarrito);
        carritoimagen=findViewById(R.id.imagenCarrito);
        recyclerView=findViewById(R.id.itemsCarrito);
        txtTotal=findViewById(R.id.textTotalPagar);
        botoncontinuar=findViewById(R.id.btnContinuarCarrito);

        //carritoCompras.add(CarritoCompras("","",null,null,null));
        sqliteBase=new SQLITEBase(getApplicationContext(),"carrito_base",null,4);
        carritoCompras=new ArrayList<>();
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        traerdatos();
        adaptadorCarrito= new AdaptadorCarrito(this,carritoCompras);
        recyclerView.setAdapter(adaptadorCarrito);
        enviardatos();

        //Barra de navegación
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setSelectedItemId(R.id.carrito);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){

                case R.id.home:
                    startActivity(new Intent(getApplicationContext()
                            ,ActivityMainPlatos.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.history:
                    startActivity(new Intent(getApplicationContext()
                            ,HistorialPedidosActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.carrito:
                    return  true;
                case  R.id.Cuenta:;
                    startActivity(new Intent(getApplicationContext(),
                            ActivityPerfil.class));
                    overridePendingTransition(0,0);
                    return true;

            }
            return false;
        }
    };

    public void traerdatos(){
        SQLiteDatabase db =sqliteBase.getReadableDatabase();
        CarritoCompras compras=null;
        // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_CARRITO,null);

        while (cursor.moveToNext()){
            CarritoCompras c =new CarritoCompras();
            c.setNombre(cursor.getString(2));
            c.setCantidad(cursor.getInt(3));
            c.setPrecio(cursor.getDouble(4));
            c.setImagen(cursor.getString(5));
            carritoCompras.add(c);

        }
        double total=0;
        for (int i = 0; i < carritoCompras.size(); i++) {
            total= ((carritoCompras.get(i).getPrecio())*carritoCompras.get(i).getCantidad()+total);
            txtTotal.setText(String.valueOf("$"+total));
            System.out.println(total+"Aqui total");
        }

    }
    public void enviardatos(){
        botoncontinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(ActivityCarrito.this,ActivityInformacionPago.class);
                i.putExtra("total",txtTotal.getText().toString());
                startActivity(i);
            }
        });

    }




}