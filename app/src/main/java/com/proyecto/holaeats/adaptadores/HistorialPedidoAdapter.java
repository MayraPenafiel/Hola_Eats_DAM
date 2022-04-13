package com.proyecto.holaeats.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.proyecto.holaeats.HistorialPedidosActivity;
import com.proyecto.holaeats.R;
import com.proyecto.holaeats.modelo.Pedido;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HistorialPedidoAdapter extends ArrayAdapter<Pedido> {

    public HistorialPedidoAdapter(Context context, ArrayList<Pedido> pedidoArrayList){
        super(context, R.layout.historial_item,pedidoArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Pedido pedido = getItem(position);

        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.historial_item,parent,false);
        }

        //ImageView imageView = convertView.findViewById(R.id.imagen);
        TextView titulo =convertView.findViewById(R.id.titulo);
        TextView descripcion = convertView.findViewById(R.id.descripcion);
        TextView total = convertView.findViewById(R.id.total);

        //imageView.setImageResource(person.image_id);
        //titulo.setText(person.name);
        //descripcion.setText(person.lasMassage);
        //total.setText(person.lasMsgTime);

        return convertView;
    }


}
