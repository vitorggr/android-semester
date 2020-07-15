package com.example.coctailapp.UI.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.coctailapp.Models.drink
import com.example.coctailapp.R
//import com.bumptech.glide.Glide

public class DrinkFullListAdapter (var context : Context, var drinks :List<drink>): BaseAdapter(){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_drink,null)

        var name = view.findViewById<TextView>(R.id.name)
        name.text = drinks[position].strIngredient1

        var instructions = view.findViewById<TextView>(R.id.instructions)
        instructions.text = drinks[position].strInstructions

        var thumb = view.findViewById<ImageView>(R.id.image)

        Glide.with(context).load(drinks[position].strDrinkThumb).into(thumb)

      //  var image = view.findViewById<ImageView>(R.id.image)
      //  Glide
      //      .with(context)
      //      .load(list[position].strDrinkThumb)
      //      .into(image)

        return view

    }



    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return drinks.size
    }



}