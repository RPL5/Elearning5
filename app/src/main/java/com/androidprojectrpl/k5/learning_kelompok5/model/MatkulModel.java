package com.androidprojectrpl.k5.learning_kelompok5.model;

import com.google.gson.annotations.SerializedName;

public class MatkulModel {
    private String id;

    @SerializedName("nama_makul")
    private String makul;

    private String sks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMakul() {
        return makul;
    }

    public void setMakul(String makul) {
        this.makul = makul;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }
}
