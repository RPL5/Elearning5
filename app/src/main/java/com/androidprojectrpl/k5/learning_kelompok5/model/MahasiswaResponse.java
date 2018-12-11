package com.androidprojectrpl.k5.learning_kelompok5.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MahasiswaResponse {

    @SerializedName("user")
    @Expose
    private List<Mahasiswa> user = null;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;


    public List<Mahasiswa> getUser() {
        return user;
    }

    public void setUser(List<Mahasiswa> user) {
        this.user = user;
    }
}
