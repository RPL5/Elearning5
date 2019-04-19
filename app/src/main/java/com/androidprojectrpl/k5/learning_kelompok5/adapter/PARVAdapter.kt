package com.androidprojectrpl.k5.learning_kelompok5.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.androidprojectrpl.k5.learning_kelompok5.R
import com.androidprojectrpl.k5.learning_kelompok5.model.ClassUser
import com.bumptech.glide.Glide

class PARVAdapter(
        val context : Context,
        var listData : List<ClassUser>) : RecyclerView.Adapter<PARVAdapter.PARVViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PARVViewHolder =
            PARVViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_data_home, p0, false))

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(p0: PARVViewHolder, p1: Int) {

    }

    inner class PARVViewHolder(v : View) : RecyclerView.ViewHolder(v){
        internal val image : ImageView = v.findViewById(R.id.rv_home_image_data)
        internal val name : TextView = v.findViewById(R.id.rv_home_name_data)
        internal val gelar : TextView = v.findViewById(R.id.rv_home_gelar_data)
        internal val judul : TextView = v.findViewById(R.id.rv_home_Title)
        internal val deskripsi : TextView = v.findViewById(R.id.rv_home_content_description_data)
        internal val time : TextView = v.findViewById(R.id.rv_time)
        fun bind(data : ClassUser){
            Glide.with(context)
                    .load("http://ujianonline.frezateam.com/___/img/pic_login.png")
                    .into(image)
            name.text = data.name_class
            gelar.text = ""

        }
    }
}