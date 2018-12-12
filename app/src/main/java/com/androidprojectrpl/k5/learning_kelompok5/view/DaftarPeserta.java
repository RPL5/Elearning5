package com.androidprojectrpl.k5.learning_kelompok5.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidprojectrpl.k5.learning_kelompok5.Data.DataPeserta;
import com.androidprojectrpl.k5.learning_kelompok5.R;
import com.androidprojectrpl.k5.learning_kelompok5.adapter.PesertaAdapter;
import com.androidprojectrpl.k5.learning_kelompok5.model.Mahasiswa;
import com.androidprojectrpl.k5.learning_kelompok5.model.PesertaKelasModel;

import java.util.ArrayList;

public class DaftarPeserta extends AppCompatActivity {
    private RecyclerView rvPeserta;
    private ArrayList<PesertaKelasModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_peserta);
        rvPeserta = findViewById(R.id.rv_peserta);
        rvPeserta.setHasFixedSize(true);

        list.addAll(DataPeserta.getListPeserta());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvPeserta.setLayoutManager(new LinearLayoutManager(this));
        PesertaAdapter pesertaAdapter = new PesertaAdapter(this);
        pesertaAdapter.setListPeserta(list);
        rvPeserta.setAdapter(pesertaAdapter);
    }

}
