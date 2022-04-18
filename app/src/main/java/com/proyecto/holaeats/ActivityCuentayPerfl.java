package com.proyecto.holaeats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityCuentayPerfl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_cuentay_perfil);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setSelectedItemId(R.id.Cuenta);
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
                    startActivity(new Intent(getApplicationContext()
                            ,HistorialPedidosActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.Cuenta:
                    return true;
            }
            return false;
        }
    };
}