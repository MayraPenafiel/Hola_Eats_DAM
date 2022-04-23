package com.proyecto.holaeats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HistorialPedidosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_pedidos);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setSelectedItemId(R.id.history);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){

                case R.id.home:
                    startActivity(new Intent(getApplicationContext()
                            ,ActivityMainPlatos.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.history:
                    return true;
                case R.id.carrito:
                    startActivity(new Intent(getApplicationContext()
                            ,ActivityCarrito.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.Cuenta:
                    startActivity(new Intent(getApplicationContext(),ActivityPerfil.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        }
    };
}