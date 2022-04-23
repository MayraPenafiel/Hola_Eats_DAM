package com.proyecto.holaeats.api;

import com.proyecto.holaeats.modelo.FacturaDetalle;
import com.proyecto.holaeats.modelo.FacturaEnc;
import com.proyecto.holaeats.modelo.Persona;
import com.proyecto.holaeats.modelo.ResponseClass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceFactura {
    @POST("factura")
    Call<FacturaEnc> creaFactura(@Body FacturaEnc facturaEnc);
    @POST("factura_detalle")
    Call <FacturaDetalle> crearDetalle(@Body FacturaDetalle facdetalle);

}
