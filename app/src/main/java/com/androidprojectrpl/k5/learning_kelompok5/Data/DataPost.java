package com.androidprojectrpl.k5.learning_kelompok5.Data;

import com.androidprojectrpl.k5.learning_kelompok5.model.PostModel;

import java.util.ArrayList;

public class DataPost {
    public static String[][] data = new String[][]{
            {"Sumarsono", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png", "Upload Materi Baru","berikut adalah materi kuliah yang disampaikan pada hari senin, mohon dipelajari","2 jam yang lalu","materi","Pemrograman web","2017/2018","Ganjil"},
            {"Nurochman", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png","Tugas pengganti","Tugas pengganti mata kuliah pada hari rabu kemarin, mencari data perusahaan yang bergerak dibidang ecommerce","2 hari yang lalu","Tugas","Basis Data","2017/2018","Genap"},
            {"Rahmat Hidayat", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png","Upload Materi Baru","berikut adalah materi kuliah yang disampaikan pada hari senin, mohon dipelajari","3 hari yang lalu","materi","Kecerdasan Buatan","2018/2019","Ganjil"},
            {"Agus Mulyanto", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png","Upload Materi Baru","berikut adalah materi kuliah yang disampaikan pada hari senin, mohon dipelajari","5 hari yang lalu","materi","kommas","2018/2019","Ganjil"},
            {"Didik Setiawan", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png","Upload Materi Baru","berikut adalah materi kuliah yang disampaikan pada hari senin, mohon dipelajari","1 minggu yang lalu","materi","Struktur Data","2016/2017","Genap"},
            {"Bambang Sugiantoro", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png","Upload Materi Baru","berikut adalah materi kuliah yang disampaikan pada hari senin, mohon dipelajari","1 minggu yang lalu","materi","Tauhid","2016/2017","Ganjil"},
            {"Taufik Nuruzzaman", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png","Tugas baru","Tugas pengganti mata kuliah pada hari rabu kemarin, mencari data perusahaan yang bergerak dibidang ecommerce","1 bulan yang lalu","tugas","Statistika dan Probabilitas","2017/2018","Ganjil"},
            {"Sumarsono", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png", "Upload Materi Baru","berikut adalah materi kuliah yang disampaikan pada hari senin, mohon dipelajari","2 jam yang lalu","pengumuman","pemweb","2017/2018","Ganjil"},
            {"Nurochman", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png","Tugas pengganti","Tugas pengganti mata kuliah pada hari rabu kemarin, mencari data perusahaan yang bergerak dibidang ecommerce","2 hari yang lalu","Tugas","Basis Data","2017/2018","Genap"},
            {"Rahmat Hidayat", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png","Upload Materi Baru","berikut adalah materi kuliah yang disampaikan pada hari senin, mohon dipelajari","3 hari yang lalu","materi","Kecerdasan Buatan","2018/2019","Ganjil"},
            {"Taufik Nuruzzaman", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png","Upload Materi Baru","berikut adalah materi kuliah yang disampaikan pada hari senin, mohon dipelajari","5 hari yang lalu","materi","Komputer dan Masyarakat","2018/2019","Ganjil"},
            {"Didik Setiawan", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png","Pengumuman","berikut adalah materi kuliah yang disampaikan pada hari senin, mohon dipelajari","1 minggu yang lalu","Pengumuman","Struktur Data","2016/2017","Genap"},
            {"Nurochman", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png","Pengumuman","berikut adalah materi kuliah yang disampaikan pada hari senin, mohon dipelajari","1 minggu yang lalu","pengumuman","Tauhid","2016/2017","Ganjil"},
            {"Taufik Nuruzzaman", "Dosen S1 Teknik Informatika", "http://ujianonline.frezateam.com/___/img/pic_login.png","Quiz pengganti","Tugas pengganti mata kuliah pada hari rabu kemarin, mencari data perusahaan yang bergerak dibidang ecommerce","1 bulan yang lalu","Quiz","Statistika dan Probabilitas","2017/2018","Ganjil"},

    };

    public static ArrayList<PostModel> getListData(){
        PostModel postModel;
        ArrayList<PostModel> list = new ArrayList<>();
        for (String[] aData : data) {
            postModel = new PostModel();
            postModel.setName(aData[0]);
            postModel.setRemarks(aData[1]);
            postModel.setPhotos(aData[2]);
            postModel.setStatus(aData[4]);
            postModel.setTitle(aData[3]);
            postModel.setTime(aData[5]);
            postModel.setTag(aData[6]);
            postModel.setMakul(aData[7]);

            list.add(postModel);
        }

        return list;
    }
    public static ArrayList<PostModel> getListDataMateri(){
        PostModel postModel;
        ArrayList<PostModel> list = new ArrayList<>();
        for (String[] aData : data) {
            if (aData[6].equals("materi")) {
                postModel = new PostModel();
                postModel.setName(aData[0]);
                postModel.setRemarks(aData[1]);
                postModel.setPhotos(aData[2]);
                postModel.setStatus(aData[4]);
                postModel.setTitle(aData[3]);
                postModel.setTime(aData[5]);
                postModel.setTag(aData[6]);
                postModel.setMakul(aData[7]);

                list.add(postModel);
            }
        }

        return list;
    }

    public static ArrayList<PostModel> getListDataUtama(String Tahun, String Semester){
        PostModel postModel;
        ArrayList<PostModel> list = new ArrayList<>();
        for (String[] aData : data) {
            if (aData[8].equals(Tahun) && aData[9].equals(Semester)) {
                postModel = new PostModel();
                postModel.setName(aData[0]);
                postModel.setRemarks(aData[1]);
                postModel.setPhotos(aData[2]);
                postModel.setStatus(aData[4]);
                postModel.setTitle(aData[3]);
                postModel.setTime(aData[5]);
                postModel.setTag(aData[6]);
                postModel.setMakul(aData[7]);

                list.add(postModel);
            }
        }

        return list;
    }

    public static ArrayList<PostModel> getListDataTugas(){
        PostModel postModel = null;
        ArrayList<PostModel> list = new ArrayList<>();
        for (String[] aData : data) {
            if (aData[6]=="Tugas") {
                postModel = new PostModel();
                postModel.setName(aData[0]);
                postModel.setRemarks(aData[1]);
                postModel.setPhotos(aData[2]);
                postModel.setStatus(aData[4]);
                postModel.setTitle(aData[3]);
                postModel.setTime(aData[5]);
                postModel.setTag(aData[6]);
                postModel.setMakul(aData[7]);

                list.add(postModel);
            }
        }

        return list;
    }

    public static ArrayList<PostModel> getListDataPengumuman(){
        PostModel postModel = null;
        ArrayList<PostModel> list = new ArrayList<>();
        for (String[] aData : data) {
            if (aData[6]=="Pengumuman") {
                postModel = new PostModel();
                postModel.setName(aData[0]);
                postModel.setRemarks(aData[1]);
                postModel.setPhotos(aData[2]);
                postModel.setStatus(aData[4]);
                postModel.setTitle(aData[3]);
                postModel.setTime(aData[5]);
                postModel.setTag(aData[6]);
                postModel.setMakul(aData[7]);

                list.add(postModel);
            }
        }

        return list;
    }

    public static ArrayList<PostModel> getListDataQuiz(){
        PostModel postModel = null;
        ArrayList<PostModel> list = new ArrayList<>();
        for (String[] aData : data) {
            if (aData[6].equals("Quiz")) {
                postModel = new PostModel();
                postModel.setName(aData[0]);
                postModel.setRemarks(aData[1]);
                postModel.setPhotos(aData[2]);
                postModel.setStatus(aData[4]);
                postModel.setTitle(aData[3]);
                postModel.setTime(aData[5]);
                postModel.setTag(aData[6]);
                postModel.setMakul(aData[7]);

                list.add(postModel);
            }
        }

        return list;
    }
    public static ArrayList<PostModel> getListDataMatkul(String matkul){
        PostModel postModel;
        ArrayList<PostModel> list = new ArrayList<>();
        for (String[] aData : data) {
            if (aData[7].equals(matkul)) {
                postModel = new PostModel();
                postModel.setName(aData[0]);
                postModel.setRemarks(aData[1]);
                postModel.setPhotos(aData[2]);
                postModel.setStatus(aData[4]);
                postModel.setTitle(aData[3]);
                postModel.setTime(aData[5]);
                postModel.setTag(aData[6]);
                postModel.setMakul(aData[7]);

                list.add(postModel);
            }
        }

        return list;
    }
}

