package com.example.coctailapp.UI.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.coctailapp.Models.IngredientList
import com.example.coctailapp.R
import com.example.coctailapp.Services.RetrofitInitializer
import kotlinx.android.synthetic.main.item_drink.*
import retrofit2.Call
import retrofit2.Response

class IngredientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient)
        var name = intent.getStringExtra("ingredient")
        getIngredientByName(name)
    }

    fun getIngredientByName(name : String){
        var s = RetrofitInitializer().serviceDrinks()
        var call = s.getIngredientByName(name)

        call.enqueue(object : retrofit2.Callback<IngredientList> {
            override fun onFailure(call: Call<IngredientList>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

            override fun onResponse( call: Call<IngredientList>?, response: Response<IngredientList>?){
                response?.let {
                    if (it.code() == 200) {
                        var name = findViewById<TextView>(R.id.name)
                        //name.text = it.body().ingredients.toString()
                        var description = findViewById<TextView>(R.id.description);
                        //description.text = it.body().ingredients.strDescription
                        var type = findViewById<TextView>(R.id.type)
                        //type.text = it.body().ingredients.strType
                        var alcohol = findViewById<TextView>(R.id.alcohol)
                        //alcohol.text = it.body().ingredients.strABC
                    }
                }
            }
        })

    }

}
