package com.proyecto.holaeats.FragmentsPlatos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.proyecto.holaeats.R;
import com.proyecto.holaeats.api.Apis;
import com.proyecto.holaeats.api.ServiceProducto;
import com.proyecto.holaeats.modelo.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class FragmentEntradasTiki extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //Variables********************************

   List<Producto> listaProducto;
   RecyclerAdaptadorPlatos adaptadorPlatos;
    RecyclerView recyclerView;
    Retrofit retrofit;




    public FragmentEntradasTiki() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEntradasTiki.
     */
    // TODO: Rename and change types and number of parameters
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
        View vista=inflater.inflate(R.layout.fragment_entradas_tiki,container,false);

        //recyclerProductos=(RecyclerView)vista.findViewById(R.id.RecyclerIdPlato);
        recyclerView=(RecyclerView)vista.findViewById(R.id.RecyclerIdPlato);
        //recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        //verProductos();
        //RecyclerAdaptadorPlatos  adaptadorPlatos=new RecyclerAdaptadorPlatos(listaProducto);
        //recyclerView.setAdapter(adaptadorPlatos);
        //AdapterProducto  adaptador=new AdapterProducto(listaProducto);
       // recyclerProductos.setAdapter(adaptador);
        initValues();
        return vista;

    }
    private  void initValues(){

        //LinearLayoutManager manager=new GridLayoutManager(getContext(),2);
        //recyclerView.setLayoutManager(manager);
        getItemsSQL();
    }
    public void verProductos(){
        listaProducto.add(new Producto("1","12","Cochas",R.drawable.ceviche_de_concha,null,"Marizco","Con camrones",23,10));
        listaProducto.add(new Producto("1","12","Cochas",R.drawable.ceviche_de_concha,null,"Marizco","Con camrones",23,10));
        listaProducto.add(new Producto("1","12","Cochas",R.drawable.ceviche_de_concha,null,"Marizco","Con camrones",23,10));
        listaProducto.add(new Producto("1","12","Cochas",R.drawable.ceviche_de_concha,null,"Marizco","Con camrones",23,10));
        listaProducto.add(new Producto("1","12","Cochas",R.drawable.ceviche_de_concha,null,"Marizco","Con camrones",23,10));
    }

    private void getItemsSQL() {
        ServiceProducto service = Apis.getInstance().create(ServiceProducto.class);
        Call<List<Producto>> call =service.getProductos();
           call.enqueue(new Callback<List<Producto>>() {
         @Override
         public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
             LinearLayoutManager manager=new GridLayoutManager(getContext(),2);
             recyclerView.setLayoutManager(manager);
             listaProducto=response.body();
             adaptadorPlatos=new RecyclerAdaptadorPlatos(getContext(),listaProducto);
             recyclerView.setAdapter(adaptadorPlatos);

         }

         @Override
         public void onFailure(Call<List<Producto>> call, Throwable t) {

             Toast.makeText(getActivity(), "Error: "+t.getMessage(), Toast.LENGTH_LONG).show();
         }
     });
    }


}