package com.proyecto.holaeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Animation animacion= AnimationUtils.loadAnimation( this,R.anim.desplazamiento_abajo);

        ImageView logoIVDibujo =findViewById(R.id.icono_logo);

        logoIVDibujo.setAnimation(animacion);


        //new Handler().postDelayed(new Runnable() {
       //     @Override
       //     public void run() {
       //         Intent intent= new Intent(MainActivity.this, Interfaz_Perfil.class);
       //         startActivity(intent);
       //         finish();
       //     }
        //}, 4000);
    }
}