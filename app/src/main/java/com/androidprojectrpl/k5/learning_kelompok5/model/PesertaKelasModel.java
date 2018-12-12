package com.androidprojectrpl.k5.learning_kelompok5.model;

public class PesertaKelasModel {
    private String nim;
    private String nama;

    public PesertaKelasModel(){
        this.nim = getNim();
        this.nama = getNama();
    }

    public PesertaKelasModel(String nim,String nama){
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
