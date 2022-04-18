package com.proyecto.holaeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.proyecto.holaeats.modelo.Producto;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ActividadDetallePlato extends AppCompatActivity {
   //// DETALEEEEEEEEEEEEEEEEEEEEEE
   private Producto producto;
    List<Producto> listaproducto;
    ImageView imagenVer;
    TextView txtnombre ,txtdescripcion,txtprecio, txtstock;
    Button btnañadir;
    EditText editCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_plato);
        imagenVer=findViewById(R.id.imagen_detalleid);
        txtnombre=findViewById(R.id.textdetallenombrePlato);
        txtdescripcion=findViewById(R.id.textdetalle_descripcion);
        txtprecio=findViewById(R.id.textdetallle_precio);
        txtstock=findViewById(R.id.textdetalle_stock);
        editCantidad=findViewById(R.id.editTextCantidad);
        btnañadir=findViewById(R.id.botonAñadirCarrito);
        iniciarActividad();
        añadir();



    }

    public void iniciarActividad(){
        producto= (Producto) getIntent().getExtras().getSerializable("itemDetalle");//mismo nombre que el adapter
        Picasso.get()
                .load(producto.getFoto())
                .error(R.mipmap.ic_launcher)
                .into(imagenVer);
        txtnombre.setText(producto.getNombre());
        txtdescripcion.setText(producto.getDescripcion());



    }
    public  void añadir(){
        Producto producto=new Producto();
        btnañadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActividadDetallePlato.this, ActivityCarrito.class);

                i.putExtra("datos",txtnombre.getText().toString());
                i.putExtra("dato1",editCantidad.getText().toString());
                startActivity(i);
            }
        });
    }

}