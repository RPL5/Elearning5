package com.androidprojectrpl.k5.learning_kelompok5.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidprojectrpl.k5.learning_kelompok5.R;
import com.androidprojectrpl.k5.learning_kelompok5.model.PesertaKelasModel;

import java.util.ArrayList;

public class PesertaAdapter extends RecyclerView.Adapter<PesertaAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PesertaKelasModel> listPeserta;

    public PesertaAdapter(Context context) {
        this.context = context;
    }
    public ArrayList<PesertaKelasModel> getListPeserta() {
        return listPeserta;
    }

    public void setListPeserta(ArrayList<PesertaKelasModel> listPeserta) {
        this.listPeserta = listPeserta;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_peserta,viewGroup,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.tvNim.setText(getListPeserta().get(position).getNim());
        viewHolder.tvNama.setText(getListPeserta().get(position).getNama());

    }

    @Override
    public int getItemCount(){return getListPeserta().size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNim, tvNama;
        public ViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.nama_peserta);
            tvNim = itemView.findViewById(R.id.nim_peserta);

        }
    }
}
