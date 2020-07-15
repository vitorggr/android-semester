package com.example.coctailapp.UI.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.coctailapp.Models.DrinkList
import com.example.coctailapp.R
import com.example.coctailapp.Services.RetrofitInitializer
import com.example.coctailapp.UI.Adapters.DrinkAdapter
import com.example.coctailapp.UI.Adapters.DrinkListAdapter
import kotlinx.android.synthetic.main.activity_category_list.*
import kotlinx.android.synthetic.main.activity_category_list.list
import kotlinx.android.synthetic.main.activity_drink.*
import kotlinx.android.synthetic.main.activity_drink_list.*
import retrofit2.Call
import retrofit2.Response

class DrinkListByCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)
        var x = intent.getStringExtra("categoria")
        getListByCategorie(x)
    }

    fun getListByCategorie(parametro : String){
        var s = RetrofitInitializer().serviceDrinks()
        var call = s.getByCategorie(parametro)

        call.enqueue(object : retrofit2.Callback<DrinkList> {
            override fun onResponse(call: Call<DrinkList>?, response: Response<DrinkList>?) {
                response?.let {
                    if (it.code() == 200) {
                        list.adapter = DrinkListAdapter(this@DrinkListByCategoryActivity, it.body().drinks)
                    }
                }
            }


            override fun onFailure(call: Call<DrinkList>?, t: Throwable?) {
            }
        })

        list.setOnItemClickListener { parent, view, position, id ->
            var x = parent.adapter.getItem(position).toString()
            var intent = Intent(this, DrinkActivity::class.java)
            intent.putExtra("drinkselecionado", x)
            startActivity(intent)
        }

    }

}
