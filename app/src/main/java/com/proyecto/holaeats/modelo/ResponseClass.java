package com.proyecto.holaeats.modelo;
import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class ResponseClass implements Serializable {
    @SerializedName("id_persona")
    private int id_persona;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public void setId_persona(int id) {
        this.id_persona = id;
    }

    public int getId_persona() {
        return id_persona;
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

    @Override
    public String toString() {
        return
                "ResponseClass{" +
                        "id = '" + id_persona+ '\'' +
                        ",username = '" + username + '\'' +
                        ",password = '" + password + '\'' +
                        "}";
    }

}
