package com.proyecto.holaeats;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.proyecto.holaeats.adaptadores.AdaptadorCarrito;
import com.proyecto.holaeats.modelo.CarritoCompras;
import com.proyecto.holaeats.modelo.FacturaEnc;
import com.proyecto.holaeats.modelo.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ActivityCarrito extends AppCompatActivity {
    List<FacturaEnc> listaproducto ;
   AdaptadorCarrito adaptadorCarrito;
    RecyclerView recyclerView;
    List<CarritoCompras> carritoCompras ;
    TextView txtcantidad ,txtnombre;
    ImageView carritoimagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_pedidos);
        txtnombre=findViewById(R.id.txtcarritonombreplato);
        txtcantidad=findViewById(R.id.txtprecioCarrito);
        carritoimagen=findViewById(R.id.imagenCarrito);
        recyclerView=findViewById(R.id.itemsCarrito);

        carritoCompras= new ArrayList<>();
        //carritoCompras.add(CarritoCompras("","",null,null,null));
        adaptadorCarrito= new AdaptadorCarrito(this,carritoCompras);
        recyclerView.setAdapter(adaptadorCarrito);
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);



    }

}