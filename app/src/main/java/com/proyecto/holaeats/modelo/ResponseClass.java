package com.proyecto.holaeats.modelo;
import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class ResponseClass implements Serializable {
    @SerializedName("personaId")
    private int personaId;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public void setId_persona(int id) {
        this.personaId = id;
    }

    public int getId_persona() {
        return personaId;
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
                        "id = '" + personaId+ '\'' +
                        ",username = '" + username + '\'' +
                        ",password = '" + password + '\'' +
                        "}";
    }

}
