package com.proyecto.holaeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.proyecto.holaeats.FragmentsPlatos.FragmentEntradasTiki;
import com.proyecto.holaeats.FragmentsPlatos.FragmentSopasTiki;
import com.proyecto.holaeats.FragmentsPlatos.FragmentTikiFuertes;
import com.proyecto.holaeats.FragmentsPlatos.FragmentTikiHouse;
import com.proyecto.holaeats.FragmentsPlatos.FragmentTradicionales;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActivityMainPlatos extends AppCompatActivity {
        FragmentTransaction transaction;
        Fragment fentradas,fhouse,fsopas,ffuertes,ftradicional;
        CircleImageView img1,img2,img3,img4,img5;
        View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_platos);
        fentradas = new FragmentEntradasTiki();
        fhouse = new FragmentTikiHouse();
        fsopas = new FragmentSopasTiki();
        ffuertes = new FragmentTikiFuertes();
        ftradicional = new FragmentTradicionales();
        img1=(CircleImageView)findViewById(R.id.imgEntradas);
        img2=(CircleImageView)findViewById(R.id.imgHouse);

        //Reemplazar un fragmen por otro
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentprincipal, fentradas).commit();

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setSelectedItemId(R.id.home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){

                case R.id.home:
                    return true;
                case R.id.history:
                    startActivity(new Intent(getApplicationContext()
                            ,HistorialPedidosActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.carrito:
                    startActivity(new Intent(getApplicationContext()
                            ,ActivityCarrito.class));
                    overridePendingTransition(0,0);
                    return  true;
                case  R.id.Cuenta:;
                startActivity(new Intent(getApplicationContext(),
                        ActivityPerfil.class));
                overridePendingTransition(0,0);
                return true;

            }
            return false;
        }
    };




    public void onClick(View view){


        transaction=getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.imgEntradas:

                        transaction.replace(R.id.fragmentprincipal,fentradas);
                        transaction.addToBackStack(null);


                break;
            case R.id.imgHouse:

                       transaction.replace(R.id.fragmentprincipal,fhouse);
                       transaction.addToBackStack(null);

                break;
            case R.id.imgSopas:
                transaction.replace(R.id.fragmentprincipal,fsopas);
                transaction.addToBackStack(null);
                break;
            case R.id.imgFuertes:
                transaction.replace(R.id.fragmentprincipal,ffuertes);
                transaction.addToBackStack(null);
                break;
            case R.id.imgTradicional:
                transaction.replace(R.id.fragmentprincipal,ftradicional);
                transaction.addToBackStack(null);
                break;


        }
        transaction.commit();



    }
}