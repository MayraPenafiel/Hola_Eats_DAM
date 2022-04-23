package com.proyecto.holaeats.FragmentsPlatos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.holaeats.ActividadDetallePlato;
import com.proyecto.holaeats.MainActivity;
import com.proyecto.holaeats.R;
import com.proyecto.holaeats.adaptadores.RecyclerAdaptadorPlatos;
import com.proyecto.holaeats.api.ServiceProducto;
import com.proyecto.holaeats.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragmentTikiFuertes extends Fragment implements RecyclerAdaptadorPlatos.RecyclerIntemClick  {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    List<Producto> listaproducto ;
    RecyclerAdaptadorPlatos adaptadorPlatos;
    RecyclerView recyclerView;

    public FragmentTikiFuertes() {
        // Required empty public constructor
    }

    public static FragmentTikiFuertes newInstance(String param1, String param2) {
        FragmentTikiFuertes fragment = new FragmentTikiFuertes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tiki_fuertes, container, false);
    }
    private void getItemsSQL()  {
        listaproducto=new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceProducto json = retrofit.create(ServiceProducto.class);

        Call<List<Producto>> call =json.productos();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                List<Producto> post = response.body();
                for (Producto producto : post) {
                    producto.setNombre(producto.getNombre());
                    producto.setFoto(producto.getFoto());
                    System.out.println(producto.getNombre()+" sdfdsdfsfdsfsd");
                    listaproducto.add(producto);
                }
                System.out.println(listaproducto.size()+ " iiiiiiiiiiiiiiiiiiiiiddddddd");
                adaptadorPlatos=new RecyclerAdaptadorPlatos(getContext(),listaproducto,FragmentTikiFuertes.this);
                recyclerView.setAdapter(adaptadorPlatos);

            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });

    }

    @Override
    public void itemClick(Producto producto) {
        Intent intent= new Intent(getContext() , ActividadDetallePlato.class);
        intent.putExtra("itemDetalle",producto); //Cualquier n ombre en put extra
        startActivity(intent);
    }
}