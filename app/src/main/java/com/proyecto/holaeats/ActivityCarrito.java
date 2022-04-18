package com.proyecto.holaeats;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.proyecto.holaeats.FragmentsPlatos.FragmentEntradasTiki;
import com.proyecto.holaeats.adaptadores.AdaptadorCarrito;
import com.proyecto.holaeats.adaptadores.RecyclerAdaptadorPlatos;
import com.proyecto.holaeats.modelo.FacturaEnc;
import com.proyecto.holaeats.modelo.Producto;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ActivityCarrito extends AppCompatActivity {
    List<FacturaEnc> listaproducto ;
   AdaptadorCarrito adaptadorCarrito;
    RecyclerView recyclerView;
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

        adaptadorCarrito = new AdaptadorCarrito(this, listaproducto);
        recyclerView.setAdapter(adaptadorCarrito);



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