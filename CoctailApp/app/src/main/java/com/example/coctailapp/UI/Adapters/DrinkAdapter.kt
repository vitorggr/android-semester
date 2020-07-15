package com.example.coctailapp.UI.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.example.coctailapp.Models.drink
import com.example.coctailapp.R
import com.example.coctailapp.R.id.image
import com.example.coctailapp.UI.Activities.IngredientActivity

public class DrinkAdapter (var context : Context, var drinks :List<drink>): BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_drink,null)

        var name = view.findViewById<TextView>(R.id.name)
        name.text = drinks[position].strDrink

        var instructions = view.findViewById<TextView>(R.id.instructions)
        instructions.text = drinks[position].strInstructions

        var ingredient1 = view.findViewById<TextView>(R.id.ingredient1)
        ingredient1.text = drinks[position].strIngredient1

        var ingredient2 = view.findViewById<TextView>(R.id.ingredient2)
        ingredient2.text = drinks[position].strIngredient2

        var ingredient3 = view.findViewById<TextView>(R.id.ingredient3)
        ingredient3.text = drinks[position].strIngredient3

        var ingredient4 = view.findViewById<TextView>(R.id.ingredient4)
        ingredient4.text = drinks[position].strIngredient4

        var ingredient5 = view.findViewById<TextView>(R.id.ingredient5)
        ingredient5.text = drinks[position].strIngredient5

        var thumb = view.findViewById<ImageView>(image)
        Glide.with(context).load(drinks[position].strDrinkThumb).into(thumb)




        return view
    }


    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    override fun getCount(): Int {
        return drinks.size
    }







}