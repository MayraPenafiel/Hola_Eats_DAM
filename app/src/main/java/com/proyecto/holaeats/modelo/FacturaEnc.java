package com.proyecto.holaeats.modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class FacturaEnc implements Serializable {

    private Long idFactura;
    private Date fecha;
    private Double total;
    private String forma_pago;
    private Persona persona;
    private FacturaDetalle facturaDetalle;



    public FacturaEnc(Long idFactura, Date fecha, Double total, String forma_pago, Persona persona, FacturaDetalle facturaDetalle) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.total = total;
        this.forma_pago = forma_pago;
        this.persona = persona;
        this.facturaDetalle = facturaDetalle;
    }
    public FacturaEnc() {
        super();
    }
    public FacturaEnc(Date fecha, Double total, Persona persona,FacturaDetalle detalle) {
        super();
        this.fecha = fecha;
        this.total = total;
        this.persona = persona;
        this.facturaDetalle = detalle;
    }

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

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public FacturaDetalle getFacturaDetalle() {
        return facturaDetalle;
    }

    public void setFacturaDetalle(FacturaDetalle facturaDetalle) {
        this.facturaDetalle = facturaDetalle;
    }


}
