package com.example.coctailapp.UI.Adapters

import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coctailapp.Models.DrinkList
import com.example.coctailapp.Models.drink
import com.example.coctailapp.R

class RecyclerViewAdapter(var context: Context,var list: DrinkList) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapter {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolderAdapter(view)
    }

    override fun getItemCount(): Int {
        return list.drinks.size
    }

    override fun onBindViewHolder(holder: ViewHolderAdapter, position: Int) {
        holder.bind(context, list.drinks[position])
    }

    class ViewHolderAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(context: Context, item: drink) {
            var thumb = itemView.findViewById<ImageView>(R.id.thumb)
            Glide.with(context).load(item.strDrinkThumb).into(thumb)
        }
    }





}
