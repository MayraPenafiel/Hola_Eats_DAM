package com.proyecto.holaeats.modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FacturaDetalle implements Serializable {

    //Atributos
    @SerializedName("detalle_id")
    private Long detalleId;

    @SerializedName("description")
    private String description;

    @SerializedName("subtotal")
    private Double subtotal;

    //Metodos getter y setter
    public Long getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(Long detalleId) {
        this.detalleId = detalleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public FacturaDetalle() {
    }

    public FacturaDetalle(Long detalleId, String description, Double subtotal) {
        this.detalleId = detalleId;
        this.description = description;
        this.subtotal = subtotal;
    }
}
