package com.androidprojectrpl.k5.learning_kelompok5.model;

public class PostModel {
    private String name,remarks, photos, status;
    private String title,time,tag,makul, tahun_ajaran, semester;

    public PostModel(){
        this.name = getName();
        this.remarks = getRemarks();
        this.photos = getPhotos();
        this.status = getStatus();
        this.title = getTitle();
        this.time = getTime();
        this.tag = getTag();
        this.makul = getMakul();

    }

    public PostModel(String nama, String gelar, String photo, String desc, String judul, String waktu, String filter, String matkul, String tahun_ajaran, String semester){
        this.name = nama;
        this.remarks = gelar;
        this.photos = photo;
        this.status = desc;
        this.title = judul;
        this.time = waktu;
        this.tag = filter;
        this.makul = matkul;
        this.tahun_ajaran = tahun_ajaran;
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMakul() {
        return makul;
    }

    public void setMakul(String makul) {
        this.makul = makul;
    }

    public String getTahun_ajaran() {
        return tahun_ajaran;
    }

    public void setTahun_ajaran(String tahun_ajaran) {
        this.tahun_ajaran = tahun_ajaran;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
