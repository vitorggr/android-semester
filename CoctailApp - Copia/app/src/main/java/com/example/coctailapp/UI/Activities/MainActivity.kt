package com.example.coctailapp.UI.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.coctailapp.Models.drink
import com.example.coctailapp.Models.DrinkList
import com.example.coctailapp.R
import com.example.coctailapp.Services.RetrofitInitializer
import com.example.coctailapp.UI.Adapters.DrinkFullListAdapter
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        getAllDrinks()
    }

    fun getAllDrinks() {
        var s = RetrofitInitializer().serviceDrinks()

        var call = s.getAll("a")

        call.enqueue(object : retrofit2.Callback<DrinkList> {
            override fun onResponse(call: Call<DrinkList>?, response: Response<DrinkList>?) {
                response?.let {

                    if (it.code() == 200) {
                        Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_LONG).show()
                            list.adapter = DrinkFullListAdapter(this@MainActivity,it.body().drinks)
                    }

                }
            }

            override fun onFailure(call: Call<DrinkList>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Deu ruim", Toast.LENGTH_LONG).show()
            }
        })

    }




}
