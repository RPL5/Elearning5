package com.androidprojectrpl.k5.learning_kelompok5.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mahasiswa {
    private String id;

    @SerializedName("user")
    @Expose
    private String username;

    @SerializedName("pass")
    @Expose
    private String password;

    @SerializedName("name")
    @Expose
    private String namaMhs;

    @Expose
    private String nim;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
