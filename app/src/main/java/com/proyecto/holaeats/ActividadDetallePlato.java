package com.proyecto.holaeats;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.proyecto.holaeats.api.SQLITEBase;
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
        txtprecio.setText(String.valueOf(producto.getPrecio()));
        txtstock.setText(String.valueOf(producto.getStock()));

        //Double.valueOf(txtprecio.setText(producto.getPrecio().toString().doubleValue());
        //fat=Double.valueOf(f).doubleValue();



    }
    public  void añadir(){
        final SQLITEBase base = new SQLITEBase(this,"carrito_base",null,3);

        btnañadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //base.CarritoPedidos(
                       // txtnombre.getText().toString(),Integer.parseI,NULLnt(editCantidad.getText().toString()),Double.parseDouble(txtprecio.getText().toString()),imagenVer.toString());


                String nombre = txtnombre.getText().toString();
                int    cantidad = Integer.parseInt(editCantidad.getText().toString());
                double precio = Double.parseDouble(txtprecio.getText().toString());
                String foto = imagenVer.toString();

                Boolean checkinsertdata = base.CarritoPedidos(nombre,precio,cantidad,foto);
                if(checkinsertdata==true) {
                    Toast.makeText(getApplicationContext(), "Nuevos Datos Ingresados", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Datos no Ingresados", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void addCarrito(){



    }

}