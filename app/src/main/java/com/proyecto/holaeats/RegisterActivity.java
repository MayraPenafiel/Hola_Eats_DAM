package com.proyecto.holaeats;

import androidx.appcompat.app.AppCompatActivity;



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
                                Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(RegisterActivity.this, "something went wrong! please try again", Toast.LENGTH_SHORT).show();
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
            etRegisterPassword.setError("password must be atleast 6 characters");
            etRegisterPassword.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etRegisterPassword.getText().toString())) {
            etRegisterPassword.setError("password cannot be empty");
            etRegisterPassword.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validateUserName() {
        if (TextUtils.isEmpty(etRegisterUsername.getText().toString())) {
            etRegisterUsername.setError("username cannot be empty");
            etRegisterUsername.requestFocus();
            return false;
        } else if (!etRegisterUsername.getText().toString().contains("@gmail.com")) {
            etRegisterUsername.setError("email must contain @gmail.com");
            etRegisterUsername.requestFocus();
            return false;
        }

        return true;
    }

    private void initializeListeners() {
        etRegisterUsername = findViewById(R.id.editTextTextEmail);
        etRegisterPassword = findViewById(R.id.editTextTextContraseña);
        btnRegister = findViewById(R.id.btnregistrarsesion);
        txtcedula = findViewById(R.id.editTextTextPersonCedula);
        txtnombre = findViewById(R.id.editTextTextPersonNombre);
        txtapellido = findViewById(R.id.editTextTextPersonApellido);
        txtcorreo = findViewById(R.id.editTextTextEmail);
        txtdireccion = findViewById(R.id.editTextTextPersonDireccion);
        txttelefono = findViewById(R.id.editTextPhone);
    }








}