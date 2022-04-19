package com.proyecto.holaeats.adaptadores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.proyecto.holaeats.R;
import com.proyecto.holaeats.modelo.CarritoCompras;
import com.proyecto.holaeats.modelo.FacturaDetalle;
import com.proyecto.holaeats.modelo.FacturaEnc;
import com.proyecto.holaeats.modelo.Producto;
import com.squareup.picasso.Picasso;


import java.util.List;


public class AdaptadorCarrito extends RecyclerView.Adapter<AdaptadorCarrito.CarritoHolder> {


    Context context;
    List<CarritoCompras> carritolist;
    List<FacturaEnc> listaCarrito;
    List<FacturaDetalle> listaDeatlle;

    public AdaptadorCarrito(Context context, List<FacturaDetalle> listaDeatlle) {
        this.context = context;
        this.listaDeatlle= listaDeatlle;
    }

    @NonNull
    @Override
    public CarritoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carito,parent,false);
        return new CarritoHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CarritoHolder holder,@SuppressLint("RecyclerView") int position) {
        Producto p=new Producto();
        final CarritoCompras item=carritolist.get(position);
        holder.txtnombreplato.setText(item.getNombre());
        holder.txtprecio.setText("$"+String.valueOf(item.getPrecio()));
        holder.txtcantidad.setText(String.valueOf(item.getCantidad()));
        Picasso.get()
                .load(item.getImagen())
                .error(R.mipmap.ic_launcher)
                .into(holder.fotoplato);

        System.out.println(listaCarrito.get(position).getIdFactura()+"  NOMBRESSSSSSSSSSSSSSSSS");

    }


    @Override
    public int getItemCount() {

        return listaCarrito.size() ;
    }

    public class CarritoHolder extends RecyclerView.ViewHolder {
        TextView txtnombreplato,txtcantidad,txtprecio;
        ImageView fotoplato;

        public CarritoHolder(@NonNull View itemView) {

            super(itemView);
            txtnombreplato=itemView.findViewById(R.id.txtcarritonombreplato);
            txtcantidad=itemView.findViewById(R.id.txtCantidadCarrito);
            txtprecio=itemView.findViewById(R.id.txtprecioCarrito);
            fotoplato=itemView.findViewById(R.id.imagenCarrito);
        }
    }
}
