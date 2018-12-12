package com.androidprojectrpl.k5.learning_kelompok5.Data;

import com.androidprojectrpl.k5.learning_kelompok5.model.Mahasiswa;
import com.androidprojectrpl.k5.learning_kelompok5.model.PesertaKelasModel;

import java.util.ArrayList;

public class DataPeserta {
    public static String[][] peserta = new String[][] {
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"},
            {"1","16650002","Fajri Ramadhan"}
    };

    public static ArrayList<PesertaKelasModel> getListPeserta(){
       PesertaKelasModel pesertaKelasModel = null;
        ArrayList<PesertaKelasModel> list = new ArrayList<>();
        for (String[] aData : peserta) {
            pesertaKelasModel = new PesertaKelasModel();
            pesertaKelasModel.setNama(aData[2]);
            pesertaKelasModel.setNim(aData[1]);

            list.add(pesertaKelasModel);
        }
        return list;
    }
}
