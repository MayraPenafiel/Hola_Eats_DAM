package com.proyecto.holaeats.modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pedido implements Serializable {

    //Atributos
    @SerializedName("id_pedido")
    private Long idPedido;

    @SerializedName("tipoPago")
    private String tipoPago;

    @SerializedName("estado")
    private String estado;

    //Metodos getter y setter

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Constructores
    public Pedido() {
    }
    public Pedido(Long idPedido, String tipoPago, String estado) {
        this.idPedido = idPedido;
        this.tipoPago = tipoPago;
        this.estado = estado;
    }
    public Pedido(String tipoPago, String estado) {
        this.tipoPago = tipoPago;
        this.estado = estado;
    }
}
