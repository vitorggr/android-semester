package com.example.coctailapp.UI.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coctailapp.R
import kotlinx.android.synthetic.main.activity_categories.*

class CategoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        beer.setOnClickListener {
            getIntent("Beer")
        }

        cocktail.setOnClickListener {
            getIntent("Cocktail")
        }

        ordinary.setOnClickListener {
            getIntent("Ordinary_Drink")
        }

        shake.setOnClickListener {
            getIntent("Milk_/_Float_/_Shake")
        }

        soft.setOnClickListener {
            getIntent("Soft_Drink_/_Soda")
        }

        shot.setOnClickListener {
            getIntent("Shot")
        }
    }


    fun getIntent(parametro : String){
        var intent = Intent(this,DrinkListByCategoryActivity::class.java)
        intent.putExtra("categoria", parametro)
        startActivity(intent)
    }



}
