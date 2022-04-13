package com.proyecto.holaeats.modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class FacturaEnc implements Serializable {

    //Atributos
    @SerializedName("id_factura")
    private Long idFactura;

    @SerializedName("fecha")
    private Date fecha;

    @SerializedName("total")
    private Double total;

    //Metodos getter y setter
    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    //Constructores
    public FacturaEnc(Long idFactura, Date fecha, Double total) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.total = total;
    }
    public FacturaEnc() {
    }

}
