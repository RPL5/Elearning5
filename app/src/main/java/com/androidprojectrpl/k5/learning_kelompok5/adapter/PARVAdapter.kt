package com.androidprojectrpl.k5.learning_kelompok5.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.androidprojectrpl.k5.learning_kelompok5.R
import com.androidprojectrpl.k5.learning_kelompok5.model.ClassUser

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
        fun bind(data : ClassUser){

        }
    }
}