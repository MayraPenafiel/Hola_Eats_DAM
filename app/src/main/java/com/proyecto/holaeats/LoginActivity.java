package com.proyecto.holaeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;

import com.proyecto.holaeats.api.Apis;
import com.proyecto.holaeats.api.ServicePersona;
import com.proyecto.holaeats.modelo.Persona;
import com.proyecto.holaeats.modelo.ResponseClass;

public class LoginActivity extends AppCompatActivity {


    TextView tvRegister;
    EditText etUsername, etPassword;
    Button btnLogin, btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //metodo que inicializa los listener//
        initializeListeners();
        //metodo que contiene la llamada a la actividad de registro//
        newPersona();


//metodo para ingresar usuario y contraseña//

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUsername() && validatePassword()) {
                    Persona responseRegisterClass = new Persona (etUsername.getText().toString(), etPassword.getText().toString());

                    ServicePersona apiService = Apis.getInstance().create(ServicePersona.class);
                    apiService.getUser(responseRegisterClass).enqueue(new Callback<ResponseClass>() {
                        @Override
                        public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {
                            if (response.body() != null) {

                                Toast.makeText(LoginActivity.this, "Iniciando sesión", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, ActivityMainPlatos.class);
                                intent.putExtra("username", response.body().getUsername());
                                intent.putExtra("id_persona",response.body().getId_persona());
                                MainActivity.ID_CLENTE=response.body().getId_persona();

                                    Persona p=new Persona();
                                    //p.setId_persona("id_persona",response.body().getId_persona());
                                    System.out.println(MainActivity.ID_CLENTE+" lo84541585215");
                                   // System.out.printf(response.body().getId_persona()+"id response"+response.body().getPassword()+response.body().getUsername()+response.body().getId_persona()+"XDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");


                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseClass> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Credenciales Invalidos", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });
//----------------------------------------------------------------------------------------------------//

    }




    public  void newPersona(){

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });

    }


    private boolean validateUsername() {
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError("Nombre de usuario incorrecto");
            //System.out.println(etUsername+"USUARIOOOOOOOOO");
            etUsername.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validatePassword() {
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError("Contraseña incorrecta");
            //System.out.println(etPassword+"CONTRAAAAAAAAAAAAAAA");
            etPassword.requestFocus();
            return false;
        }
        return true;
    }

    private void initializeListeners() {
        etUsername = findViewById(R.id.txtusuario);
        etPassword = findViewById(R.id.txtcontrasenia);
        //tvRegister = findViewById(R.id.tvRegister);
        btnLogin = findViewById(R.id.btniniciarsesion);
        btnRegistrar = findViewById(R.id.btnregistrarse);

    }





}