package com.proyecto.holaeats;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyecto.holaeats.api.Apis;
import com.proyecto.holaeats.api.ServicePersona;
import com.proyecto.holaeats.modelo.FacturaEnc;
import com.proyecto.holaeats.modelo.Persona;
import com.proyecto.holaeats.modelo.ResponseClass;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityInformacionPago extends AppCompatActivity {
    /*EditText numtarjeta,nombres,fecha,cvv,txtcedula;
    Button continuarboton;
    ImageButton botonfecha;
    private  int dia,mes,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_pago);
        numtarjeta=findViewById(R.id.editnumtarjetapago);
        nombres=findViewById(R.id.editnombrecompleto);
        fecha=findViewById(R.id.editfecha);
        botonfecha=findViewById(R.id.botonfecha);
        continuarboton=findViewById(R.id.botonContinuarinfo);




    }
    private void onClickListeners() {
        continuarboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    FacturaEnc responseRegisterClass = new FacturaEnc();
                    //ResponseRegisterClass p = new   ResponseRegisterClass();
                    responseRegisterClass.setCedula(txtcedula.getText().toString());
                    responseRegisterClass.setFecha(fecha.getText().toString());
                    responseRegisterClass.setForma_pago(cvv.getText().toString());
                    responseRegisterClass.setPersona(nombres.getText().toString());
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
        });
    }
    public void  fecha(){
        botonfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c= Calendar.getInstance();
                dia=c.get(Calendar.DAY_OF_MONTH);
                mes=c.get(Calendar.MONTH);
                year=c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        fecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                }
                        ,dia,mes,year);
                datePickerDialog.show();
            }
        });
    }*/
}