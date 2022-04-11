package com.proyecto.holaeats.modelo;
import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class Persona implements Serializable{


    @SerializedName("cedula")
    private String cedula;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("apellido")
    private String apellido;

    @SerializedName("correo")

    private String correo;

    @SerializedName("telefono")

    private String telefono;
    @SerializedName("direccion")

    private String direccion;

    @SerializedName("rol")

    private String rol= "Cliente";


    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public Persona() {

    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public Persona(String cedula, String nombre, String apellido, String correo, String telefono, String direccion, String rol, String username, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rol = "Cliente";
        this.username = username;
        this.password = password;
    }

    public Persona(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return
                "ResponseRegisterClass{" +
                        "username = '" + username + '\'' +
                        ",password = '" + password + '\'' +
                        "}";
    }


}
