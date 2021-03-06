package com.proyecto.holaeats;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.proyecto.holaeats.api.Apis;
import com.proyecto.holaeats.api.ServicePersona;
import com.proyecto.holaeats.modelo.Persona;
import com.proyecto.holaeats.modelo.ResponseClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText txtcedula, txtnombre, txtapellido, txtcorreo, txtdireccion, txttelefono
            ,etRegisterUsername, etRegisterPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initializeListeners();
        onClickListeners();
    }

    private void onClickListeners() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUserName() && validatePassword()) {
                    Persona responseRegisterClass = new Persona();
                    //ResponseRegisterClass p = new   ResponseRegisterClass();
                    responseRegisterClass.setCedula(txtcedula.getText().toString());
                    responseRegisterClass.setNombre(txtnombre.getText().toString());
                    responseRegisterClass.setApellido(txtapellido.getText().toString());
                    responseRegisterClass.setCorreo(txtcorreo.getText().toString());
                    responseRegisterClass.setDireccion(txtdireccion.getText().toString());
                    responseRegisterClass.setTelefono(txttelefono.getText().toString());
                    responseRegisterClass.setPassword(etRegisterPassword.getText().toString());
                    responseRegisterClass.setUsername(etRegisterUsername.getText().toString());

                    ServicePersona apiService = Apis.getInstance().create(ServicePersona.class);
                    apiService.addUser(responseRegisterClass).enqueue(new Callback<ResponseClass>() {
                        @Override
                        public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {
                            if (response.body() != null) {
                                Toast.makeText(RegisterActivity.this, "Registration con exito", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);


                            } else {
                                Toast.makeText(RegisterActivity.this, "algo salio mal! vuelva a intentarlo", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseClass> call, Throwable t) {

                        }
                    });


                }

            }
        });
    }

    private boolean validatePassword() {
        if (etRegisterPassword.getText().toString().length() < 6) {
            etRegisterPassword.setError("la contrase??a debe tener mas de 6 caracteres");
            etRegisterPassword.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etRegisterPassword.getText().toString())) {
            etRegisterPassword.setError("contrase??a no permititda");
            etRegisterPassword.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validateUserName() {
        if (TextUtils.isEmpty(etRegisterUsername.getText().toString())) {
            etRegisterUsername.setError("usuario no permitido");
            etRegisterUsername.requestFocus();
            return false;
        } else if (!etRegisterUsername.getText().toString().contains("@gmail.com")) {
            etRegisterUsername.setError("email de contener @gmail.com");
            etRegisterUsername.requestFocus();
            return false;
        }

        return true;
    }

    private void initializeListeners() {
        etRegisterUsername = findViewById(R.id.editTextTextEmail);
        etRegisterPassword = findViewById(R.id.editTextTextContrase??a);
        btnRegister = findViewById(R.id.btnregistrarsesion);
        txtcedula = findViewById(R.id.editTextTextPersonCedula);
        txtnombre = findViewById(R.id.editTextTextPersonNombre);
        txtapellido = findViewById(R.id.editTextTextPersonApellido);
        txtcorreo = findViewById(R.id.editTextTextEmail);
        txtdireccion = findViewById(R.id.editTextTextPersonDireccion);
        txttelefono = findViewById(R.id.editTextPhone);
    }








}