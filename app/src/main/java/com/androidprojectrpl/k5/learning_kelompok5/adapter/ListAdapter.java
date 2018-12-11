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
import com.androidprojectrpl.k5.learning_kelompok5.view.PostModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.CategoryViewHolder> {


    private Context context;
    private ArrayList<PostModel> listDosen;

    public ListAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<PostModel> getListDosen() {
        return listDosen;
    }

    public void setListDosen(ArrayList<PostModel> listDosen) {
        this.listDosen = listDosen;
    }



    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_data_home, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder categoryViewHolder, final int position) {
        categoryViewHolder.tvName.setText(getListDosen().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListDosen().get(position).getRemarks());
        categoryViewHolder.tvStatus.setText(getListDosen().get(position).getStatus());
        categoryViewHolder.tvTitle.setText(getListDosen().get(position).getTitle());
        categoryViewHolder.tvTime.setText(getListDosen().get(position).getTime());

        Glide.with(context)
                .load(getListDosen().get(position).getPhotos())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return getListDosen().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        TextView tvStatus;
        ImageView imgPhoto;
        TextView tvTitle;
        TextView tvTime;
        TextView tvTag;
        TextView tvMakul;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.rv_home_name_data);
            tvRemarks = itemView.findViewById(R.id.rv_home_gelar_data);
            tvStatus = itemView.findViewById(R.id.rv_home_content_description_data);
            imgPhoto = itemView.findViewById(R.id.rv_home_image_data);
            tvTitle = itemView.findViewById(R.id.rv_home_Title);
            tvTime = itemView.findViewById(R.id.rv_time);
        }
    }
}
