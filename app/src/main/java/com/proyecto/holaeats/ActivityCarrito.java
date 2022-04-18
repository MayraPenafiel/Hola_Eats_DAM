package com.proyecto.holaeats;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.proyecto.holaeats.modelo.Producto;
import com.squareup.picasso.Picasso;


public class ActivityCarrito extends AppCompatActivity {
    Producto producto ;
    TextView txtcantidad ,txtnombre;
    ImageView carritoimagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_pedidos);
        txtnombre=findViewById(R.id.textCarritoPlato);
        txtcantidad=findViewById(R.id.textCantidadCarrito);
        carritoimagen=findViewById(R.id.imagenCarrito);
        traerDatos();


    }
    public void traerDatos(){
        producto= (Producto) getIntent().getExtras().getSerializable("datos");
        Picasso.get()
                .load(producto.getFoto())
                .error(R.mipmap.ic_launcher)
                .into(carritoimagen);
        txtnombre.setText(producto.getNombre());

    }
}