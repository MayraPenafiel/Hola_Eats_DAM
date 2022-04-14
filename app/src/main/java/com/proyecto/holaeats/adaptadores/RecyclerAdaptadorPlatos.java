package com.proyecto.holaeats.adaptadores;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.proyecto.holaeats.R;
import com.proyecto.holaeats.modelo.Producto;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdaptadorPlatos extends RecyclerView.Adapter<RecyclerAdaptadorPlatos.ViewHolder> {

    LayoutInflater inflater;
    private List<Producto> listaproducto;
    private List<Producto> originallistaproducto;


    public RecyclerAdaptadorPlatos(Context context, List<Producto> listaproducto) {
        this.inflater = LayoutInflater.from(context);
        this.listaproducto = listaproducto;
        this.originallistaproducto = new ArrayList<>();

        originallistaproducto.addAll(listaproducto);
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
       private TextView txtnombreplato;
        ImageView fotoplato;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtnombreplato=(TextView)itemView.findViewById(R.id.menunombre_plato1);
            fotoplato=(ImageView)itemView.findViewById(R.id.opcionimagenPlato1);

        }

    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.grid_platos,parent,false);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtnombreplato.setText(listaproducto.get(position).getNombre_producto());
        holder.fotoplato.setImageResource(listaproducto.get(position).getFoto_producto());

    }


    @Override
    public int getItemCount() {
        return listaproducto.size();
    }

}
