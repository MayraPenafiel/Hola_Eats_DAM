package com.proyecto.holaeats.FragmentsPlatos;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.holaeats.ActividadDetallePlato;
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


public class FragmentEntradasTiki extends Fragment implements RecyclerAdaptadorPlatos.RecyclerIntemClick {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //Variables********************************

   List<Producto> listaproducto ;
   // ArrayList<Producto> productoLista;


   RecyclerAdaptadorPlatos adaptadorPlatos;
    RecyclerView recyclerView;




    public FragmentEntradasTiki() {
        // Required empty public constructor
    }


    public static FragmentEntradasTiki newInstance(String param1, String param2) {
        FragmentEntradasTiki fragment = new FragmentEntradasTiki();
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
        ViewGroup vista=(ViewGroup) inflater.inflate(R.layout.fragment_entradas_tiki,container,false);

        recyclerView=vista.findViewById(R.id.RecyclerIdPlato);
        getItemsSQL();
        LinearLayoutManager manager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(manager);
        return vista;

    }

    //// METODO RETROFIT********************************+

    private void getItemsSQL()  {

            listaproducto = new ArrayList<>();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.100.210:8080/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ServiceProducto json = retrofit.create(ServiceProducto.class);
            //Call<List<Producto>> call = json.productos();
            Call<List<Producto>> call = json.getCartegoria();
            call.enqueue(new Callback<List<Producto>>() {
                @Override
                public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                    List<Producto> post = response.body();
                    for (Producto producto : post) {

                            producto.setNombre(producto.getNombre());
                            producto.setFoto(producto.getFoto());
                            System.out.println(producto.getNombre() + " NOMBRESSSSSS");
                            producto.setFoto(producto.getFoto());

                        listaproducto.add(producto);
                    }
                    System.out.println(listaproducto.size() + " iiiiiiiiiiiiiiiiiiiiiddddddd");
                    adaptadorPlatos = new RecyclerAdaptadorPlatos(getContext(), listaproducto, FragmentEntradasTiki.this);
                    recyclerView.setAdapter(adaptadorPlatos);

                }

                @Override
                public void onFailure(Call<List<Producto>> call, Throwable t) {

                }
            });


    }


    @Override
    public void itemClick(Producto producto) {
        Intent intent= new Intent(getContext(),ActividadDetallePlato.class);
        intent.putExtra("itemDetalle",producto); //Cualquier n ombre en put extra
        startActivity(intent);
    }
}