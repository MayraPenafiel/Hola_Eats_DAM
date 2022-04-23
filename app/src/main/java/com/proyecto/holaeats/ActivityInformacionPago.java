package com.proyecto.holaeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyecto.holaeats.api.SQLITEBase;

import java.util.Calendar;

public class ActivityInformacionPago extends AppCompatActivity {
    EditText numtarjeta,nombres,fechatxt,editidpersona,txtentrega;
    TextView totalCarrito;
    Button continuarboton;
    ImageButton botonfecha;
    private  int dia,mes,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_pago);
        numtarjeta=findViewById(R.id.editnumtarjetapago);
        nombres=findViewById(R.id.editidpersona);
        fechatxt=findViewById(R.id.editfecha);
        botonfecha=findViewById(R.id.botonfecha);
        continuarboton=findViewById(R.id.botonContinuarinfo);
        totalCarrito=findViewById(R.id.txttotal);
        editidpersona=findViewById(R.id.editidpersona);
        txtentrega=findViewById(R.id.editTextentrega);
        llamar();
        onClickListeners();




    }
    private void onClickListeners() {
        final SQLITEBase base = new SQLITEBase(this,"carrito_base",null,4);
        continuarboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String fecha = fechatxt.getText().toString();
                String codtarjeta=numtarjeta.getText().toString();
                String entrega=txtentrega.getText().toString();
                String id_cliente=editidpersona.getText().toString();
                double total = Double.parseDouble(totalCarrito.getText().toString());



                Boolean checkinsertdata = base.informacionPago(fecha,codtarjeta,entrega,id_cliente,total);
                if(checkinsertdata==true) {
                    Toast.makeText(getApplicationContext(), "Nuevos Datos Ingresados", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Datos no Ingresados", Toast.LENGTH_SHORT).show();
                }



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

                /*DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        fecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                }
                        ,dia,mes,year);
                datePickerDialog.show();*/
            }
        });
    }
    public void llamar(){
        Intent intent=getIntent();
        totalCarrito.setText(intent.getStringExtra("total"));




    }

}